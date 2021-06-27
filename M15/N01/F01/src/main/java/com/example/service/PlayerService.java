package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.jpa.IMySQLPlayerRepository;
import com.example.domain.Player;

@Service
public class PlayerService {

	@Autowired
	IMySQLPlayerRepository iPlayerRepository;
	
	public List<Player> read() {
		return iPlayerRepository.findAll();
	}

	public Optional<Player> readById(int id) {
		return iPlayerRepository.findById(id);
	}
	
	public void create(Player player) {
		iPlayerRepository.save(player);
	}

	public void update(Player player) {
		iPlayerRepository.save(player);
	}
	
}
