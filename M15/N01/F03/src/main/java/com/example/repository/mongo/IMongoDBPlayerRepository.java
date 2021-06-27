package com.example.repository.mongo;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.domain.Player;

@Repository
public interface IMongoDBPlayerRepository extends MongoRepository<Player, String> {
}
