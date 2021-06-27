package com.example.repository.mongo;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.domain.Game;

@Repository
public interface IMongoDBGameRepository extends MongoRepository<Game, String> {

	ArrayList<Game> findAllByPlayerId(String id);

}
