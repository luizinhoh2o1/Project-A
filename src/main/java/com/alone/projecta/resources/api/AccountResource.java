package com.alone.projecta.resources.api;

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
import com.alone.projecta.dto.ServerDTO;
import com.alone.projecta.services.AccountService;
import com.alone.projecta.services.ServerService;

@RestController
@RequestMapping(value="/accounts")
public class AccountResource {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private ServerService serverService;
	
	//Listar todas as Account
	@GetMapping
	public ResponseEntity<List<AccountDTO>> findAll() {
		List<Account> list = accountService.findAll();
		List<AccountDTO> listDTO = list.stream().map(x -> new AccountDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//Buscar Account por ID
	@GetMapping(value="/{id}")
	public ResponseEntity<AccountDTO> findById(@PathVariable String id) {
		Account obj = accountService.findById(id);
		return ResponseEntity.ok().body(new AccountDTO(obj));
	}
	
	//Listar Servers da Account
	@GetMapping(value="/{id}/servers")
	public ResponseEntity<List<Server>> findServers(@PathVariable String id) {
		Account obj = accountService.findById(id);
		return ResponseEntity.ok().body(obj.getServers());
	}
	
	//Inserir uma Account no MongoDB
	@PostMapping
	public ResponseEntity<Void> insertAccount(@RequestBody AccountDTO objDTO) {
		Account obj = accountService.fromDTO(objDTO);
		obj.setId(null);
		obj = accountService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Inserir Server na Account
	@PutMapping(value="/{id}/insert-server")
	public ResponseEntity<Void> insertServerAccount(@RequestBody ServerDTO serverDTO, @PathVariable String id) {
		Server objServer = serverService.fromDTO(serverDTO);
		objServer.setId(null);
		objServer = serverService.insert(objServer);
		accountService.insertServerAccount(objServer, id);
		return ResponseEntity.noContent().build();
	}
	
	//Deletar Account por ID
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		accountService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	//Atualizar dados da Account por ID
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody AccountDTO objDto, @PathVariable String id) {
		Account obj = accountService.fromDTO(objDto);
		obj.setId(id);
		obj = accountService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
