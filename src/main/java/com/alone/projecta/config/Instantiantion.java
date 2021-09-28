package com.alone.projecta.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alone.projecta.domain.Account;
import com.alone.projecta.domain.Player;
import com.alone.projecta.domain.Server;
import com.alone.projecta.repository.AccountRepository;
import com.alone.projecta.repository.PlayerRepository;
import com.alone.projecta.repository.ServerRepository;

@Configuration
public class Instantiantion implements CommandLineRunner{

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ServerRepository serverRepository;
	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date data =  new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, 3);
		data = cal.getTime(); 
		
		accountRepository.deleteAll();
		serverRepository.deleteAll();
		playerRepository.deleteAll();
		
		Player p1 = new Player(null, "Teddy", true, data);
		Player p2 = new Player(null, "Tony_Gamer", true, data);
		
		Server serv1 = new Server(null, "Server One", "LocalHost Server 1", "127.0.0.1");
		Server serv2 = new Server(null, "Server Two", "LocalHost Server 2", "127.0.0.1");
		
		Account acc1 = new Account(null, "Alessandro", "luizinho", "123456", "alessandroluiz@gmail.com");
		Account acc2 = new Account(null, "Pedro", "pedrinho", "123123", "pedrinho@gmail.com");
		
		playerRepository.saveAll(Arrays.asList(p1, p2));
		serv1.getPlayers().addAll(Arrays.asList(p1, p2));
		serverRepository.saveAll(Arrays.asList(serv1, serv2));
		acc1.getServers().addAll(Arrays.asList(serv1, serv2));
		accountRepository.saveAll(Arrays.asList(acc1, acc2));
	}

}
