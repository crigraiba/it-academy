package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.PlayerService;
import com.example.domain.Player;

@RestController
@RequestMapping("/ranking")
public class RankingRestController {

	@Autowired
	PlayerService playerService;
	
	// S'exclouen els jugadors amb 0 tirades.
	
	/**
	 * Retorna el percentatge mig d'èxit de tots els jugadors.
	 * @return Percentatge mig d'èxit.
	 */
	
	@GetMapping
	public int read() {
		List<Player> players = playerService.read();
		
		return players.stream() // Stream<Player>
			.filter(player -> player.getWinRate() != -1) // Stream<Player>
			.map(Player::getWinRate) // Stream<Integer>
			.collect(Collectors.summingInt(Integer::intValue)) / players.size();
	}
	
	/**
	 * Retorna el jugador amb pitjor percentatge d'èxit.
	 * @return Jugador amb pitjor percentatge d'èxit.
	 */
	
	@GetMapping("/loser")
	public Optional<Player> readLoser() {
		return playerService.read() // List<Player>
			.stream() // Stream<Player>
			.filter(player -> player.getWinRate() != -1) // Stream<Player>
			.min(Comparator.comparing(Player::getWinRate)); // Optional<Player>
	}
	
	/**
	 * Retorna el jugador amb millor percentatge d'èxit.
	 * @return Jugador amb millor percentatge d'èxit.
	 */
	
	@GetMapping("/winner")
	public Optional<Player> readWinner() {
		return playerService.read() // List<Player>
			.stream() // Stream<Player>
			.filter(player -> player.getWinRate() != -1) // Stream<Player>
			.max(Comparator.comparing(Player::getWinRate)); // Optional<Player>
	}

}
