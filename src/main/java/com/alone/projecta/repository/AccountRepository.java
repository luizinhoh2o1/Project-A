package com.alone.projecta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.alone.projecta.domain.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{
	@Query("{username:?0}")
	Account findByUsername(String username);
}
