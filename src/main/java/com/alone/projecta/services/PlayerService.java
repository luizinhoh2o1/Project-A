package com.alone.projecta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.projecta.domain.Player;
import com.alone.projecta.dto.PlayerDTO;
import com.alone.projecta.repository.PlayerRepository;
import com.alone.projecta.services.exception.ObjectNotFoundException;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository repository;
	
	public List<Player> findAll() {
		return repository.findAll();
	}
	
	public Player findById(String id) {
		Optional<Player> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public Player insert(Player obj) {
		return repository.insert(obj);
	}
	
	public void deleteById(String id) {
		if (findById(id) != null) {
			repository.deleteById(id);
		}
	}
	
	public Player fromDTO(PlayerDTO objDTO) {
		return new Player(
			objDTO.getId(),
			objDTO.getNickname(),
			objDTO.getPlayerOn(),
			objDTO.getExpiration()
		);
	}
}
