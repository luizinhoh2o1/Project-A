package com.alone.projecta.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alone.projecta.domain.Server;
import com.alone.projecta.dto.ServerDTO;
import com.alone.projecta.services.ServerService;

@RestController
@RequestMapping(value="servers")
public class ServerResource {
	
	@Autowired
	private ServerService service;
	
	//Buscar server por ID
	@GetMapping(value="/{id}")
	public ResponseEntity<ServerDTO> findById(@PathVariable String id){
		Server obj = service.findById(id);
		return ResponseEntity.ok().body(new ServerDTO(obj));
	}
	
	//Listar todos os Servers
	@GetMapping
	public ResponseEntity<List<ServerDTO>> findAll() {
		List<Server> list = service.findAll();
		List<ServerDTO> listDTO = list.stream().map(x -> new ServerDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//Deletar Server por ID
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	//Atualizar dados do Server por ID
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody ServerDTO objDto, @PathVariable String id) {
		Server obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
