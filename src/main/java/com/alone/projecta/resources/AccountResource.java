package com.alone.projecta.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alone.projecta.domain.Account;
import com.alone.projecta.domain.Server;
import com.alone.projecta.dto.AccountDTO;
import com.alone.projecta.services.AccountService;

@RestController
@RequestMapping(value="/accounts")
public class AccountResource {
	
	@Autowired
	private AccountService service;
	
	//Listar todas as Account
	@GetMapping
	public ResponseEntity<List<AccountDTO>> findAll() {
		List<Account> list = service.findAll();
		List<AccountDTO> listDTO = list.stream().map(x -> new AccountDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//Buscar Account por ID
	@GetMapping(value="/{id}")
	public ResponseEntity<AccountDTO> findById(@PathVariable String id) {
		Account obj = service.findById(id);
		return ResponseEntity.ok().body(new AccountDTO(obj));
	}
	
	//Listar Servers da Account
	@GetMapping(value="/{id}/servers")
	public ResponseEntity<List<Server>> findServers(@PathVariable String id) {
		Account obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getServers());
	}
	
	//Inserir uma Account no MongoDB
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AccountDTO objDTO) {
		Account obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Deletar Account por ID
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	//Atualizar dados da Account
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody AccountDTO objDto, @PathVariable String id) {
		Account obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
