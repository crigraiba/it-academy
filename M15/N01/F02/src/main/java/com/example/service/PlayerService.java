package com.example.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.repository.mysql.IMySQLPlayerRepository;
import com.example.repository.mongo.IMongoDBPlayerRepository;
import com.example.domain.Player;

@Service
public class PlayerService {

	@Autowired
	//IMySQLPlayerRepository iPlayerRepository;
	IMongoDBPlayerRepository iPlayerRepository;
	
	public List<Player> read() {
		return iPlayerRepository.findAll();
	}

	public Optional<Player> readById(String id) {
		return iPlayerRepository.findById(id);
	}
	
	public void create(Player player) {
		player.setDate(LocalDate.now());
		
		iPlayerRepository.save(player);
	}

	public void update(Player player) {
		iPlayerRepository.save(player);
	}
	
}
