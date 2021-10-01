package com.alone.projecta.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alone.projecta.domain.Account;
import com.alone.projecta.domain.Server;
import com.alone.projecta.dto.PlayerDTO;
import com.alone.projecta.repository.AccountRepository;
import com.alone.projecta.repository.ServerRepository;
import com.alone.projecta.services.util.GenerateCurrentDate;

@Configuration
public class Instantiantion implements CommandLineRunner{

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ServerRepository serverRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		accountRepository.deleteAll();
		serverRepository.deleteAll();
		
		PlayerDTO p1 = new PlayerDTO("Teddy", GenerateCurrentDate.getCurrentDateAndExtendMonths(3));
		PlayerDTO p2 = new PlayerDTO("Tony_Gamer", GenerateCurrentDate.getCurrentDateAndExtendMonths(3));
		
		Server serv1 = new Server(null, "Server One", "LocalHost Server 1", "127.0.0.1", "123456");
		Server serv2 = new Server(null, "Server Two", "LocalHost Server 2", "127.0.0.1", "789456");
		
		Account acc1 = new Account(null, "Alessandro", "luizinho", "123456", "alessandroluiz@gmail.com");
		Account acc2 = new Account(null, "Pedro", "pedrinho", "123123", "pedrinho@gmail.com");
		
		serv1.getPlayers().addAll(Arrays.asList(p1, p2));
		serverRepository.saveAll(Arrays.asList(serv1, serv2));
		acc1.getServers().addAll(Arrays.asList(serv1, serv2));
		accountRepository.saveAll(Arrays.asList(acc1, acc2));
	}

}
