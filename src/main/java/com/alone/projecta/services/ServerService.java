package com.alone.projecta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.projecta.domain.Server;
import com.alone.projecta.dto.CommandToServerDTO;
import com.alone.projecta.dto.ServerDTO;
import com.alone.projecta.repository.ServerRepository;
import com.alone.projecta.services.exception.ObjectNotFoundException;

@Service
public class ServerService {

	@Autowired
	private ServerRepository repository;

	public List<Server> findAll() {
		return repository.findAll();
	}

	public Server findById(String id) {
		Optional<Server> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public Server findByTokenServer(String token) {
		return repository.searchTokenServer(token);
	}

	public Server insert(Server obj) {
		return repository.insert(obj);
	}

	public void deleteById(String id) {
		if (findById(id) != null) {
			repository.deleteById(id);
		}
	}

	public Server update(Server obj) {
		Server newObj = repository.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	public Server insertCommandToServer(CommandToServerDTO commandDto, String token) {
		Server obj = findByTokenServer(token);
		obj.getCmdToServer().setCommand(commandDto.getCommand());
		return repository.save(obj);
	}

	public Server removeCommandToServer(String token) {
		Server newObj = findByTokenServer(token);
		newObj.getCmdToServer().setCommand("");
		return repository.save(newObj);
	}

	public void updateData(Server newObj, Server obj) {
		newObj.setName(obj.getName());
		newObj.setHosting(obj.getHosting());
		newObj.setIp(obj.getIp());
	}

	public Server fromDTO(ServerDTO objDTO) {
		return new Server(objDTO.getId(), objDTO.getName(), objDTO.getHosting(), objDTO.getIp(), objDTO.getToken());
	}
}
