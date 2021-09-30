package com.alone.projecta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.alone.projecta.domain.Server;
import com.alone.projecta.dto.PlayerDTO;

@Repository
public interface ServerRepository extends MongoRepository<Server, String>{
	
	@Query("{ 'tokenPost': {$regex: ?0, $options: 'i'} }")
	Server searchTokenPost(String token);
	
	@Query("{ 'players.nickname': {$regex: ?0, $options: 'i'} }")
	PlayerDTO searchNickname(String nickname);
}
