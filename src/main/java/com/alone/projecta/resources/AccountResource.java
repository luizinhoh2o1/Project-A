package com.alone.projecta.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alone.projecta.domain.Account;
import com.alone.projecta.dto.AccountDTO;
import com.alone.projecta.services.AccountService;

@RestController
@RequestMapping(value="/accounts")
public class AccountResource {
	
	@Autowired
	private AccountService service;
	
	//listar todas as Account com a estrutura AccountDTO
	@GetMapping
	public ResponseEntity<List<AccountDTO>> findAll() {
		List<Account> list = service.findAll();
		List<AccountDTO> listDTO = list.stream().map(x -> new AccountDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AccountDTO objDTO) {
		Account obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
