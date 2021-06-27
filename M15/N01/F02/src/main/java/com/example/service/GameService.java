package com.example.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.repository.jpa.IMySQLGameRepository;
import com.example.repository.mongo.IMongoDBGameRepository;
import com.example.domain.Game;

@Service
public class GameService {
	
	@Autowired
	//IMySQLGameRepository iGameRepository;
	IMongoDBGameRepository iGameRepository;

	public List<Game> readByPlayerId(String id) {
		return iGameRepository.findAllByPlayerId(id);
	}

	public void create(Game game) {
		// Assignem de forma aleatòria els valors dels daus:
		Random random = new Random();
		
		game.setDice1(random.nextInt(6) + 1);
		game.setDice2(random.nextInt(6) + 1);
		
		iGameRepository.save(game);
	}

	public void deleteByPlayerId(String id) {
		iGameRepository.deleteAll(iGameRepository.findAllByPlayerId(id));
	}
	
}
