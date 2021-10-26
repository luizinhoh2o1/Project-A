package com.alone.projecta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.projecta.domain.Account;
import com.alone.projecta.domain.Server;
import com.alone.projecta.dto.AccountDTO;
import com.alone.projecta.repository.AccountRepository;
import com.alone.projecta.services.exception.ObjectNotFoundException;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	public List<Account> findAll() {
		return repository.findAll();
	} 
	
	public Account findById(String id) {
		Optional<Account> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public Account findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	public List<Server> findAllServersAccount(String username) {
		return findByUsername(username).getServers();
	}
	
	public Account insert(Account obj) {
		return repository.insert(obj);
	}
	
	public void deleteById(String id) {
		if (findById(id) != null) {
			repository.deleteById(id);
		}
	}
	
	public Account update(Account obj) {
		Account newObj = repository.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public Account insertServerAccount(Server objServer, String id) {
		Account newObj = findById(id);
		newObj.getServers().add(objServer);
		return repository.save(newObj);
	}

	public void updateData(Account newObj, Account obj) {
		newObj.setName(obj.getName());
		newObj.setUsername(obj.getUsername());
		newObj.setPassword(obj.getPassword());
		newObj.setServers(obj.getServers());
		newObj.setEmail(obj.getEmail());
	}
	
	public Account fromDTO(AccountDTO objDTO) {
		return new Account(
			objDTO.getId(),
			objDTO.getName(),
			objDTO.getUsername(),
			objDTO.getPassword(),
			objDTO.getEmail()
		);
	}
}
