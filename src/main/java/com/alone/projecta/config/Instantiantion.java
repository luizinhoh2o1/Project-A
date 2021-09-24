package com.alone.projecta.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alone.projecta.domain.Account;
import com.alone.projecta.repository.AccountRepository;

@Configuration
public class Instantiantion implements CommandLineRunner{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void run(String... args) throws Exception {
		accountRepository.deleteAll();
		
		Account acc1 = new Account(null, "Alessandro", "luizinho", "123456", "alessandroluiz@gmail.com");
		Account acc2 = new Account(null, "Pedro", "pedrinho", "123123", "pedrinho@gmail.com");
		
		accountRepository.saveAll(Arrays.asList(acc1, acc2));
	}

}
