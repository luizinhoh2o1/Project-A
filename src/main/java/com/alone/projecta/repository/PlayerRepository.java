package com.alone.projecta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alone.projecta.domain.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String>{

}
