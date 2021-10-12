package com.alone.projecta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alone.projecta.domain.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{
	Account findByUsername(String username);
}
