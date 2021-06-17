package com.example.controller;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.repository.IPlayerRepository;
import com.example.domain.Player;

@RestController
@RequestMapping("/players")
public class PlayerRestController {
	
	@Autowired
	IPlayerRepository repository;
	
	// Lectura:
	/**
	 * Retorna una llista de tots els jugadors.
	 * @return Llista de jugadors.
	 */
	
	@GetMapping
	public List<Player> read() {
		return repository.findAll();
	}
	
	// Creació:
	/**
	 * Crea un jugador.
	 * @param player Nou jugador.
	 */
	
	@PostMapping
	public void create(@RequestParam Player player) {
		repository.save(player);
	}
	
	// Actualització:
	/**
	 * Actualitza el nom d'un jugador.
	 * @param id Identificador únic del jugador.
	 * @param player Jugador.
	 */
	
	@PutMapping("/{id}")
	public void update(@RequestParam String id, @RequestBody Player player) {
		player.setId(id);
		repository.save(player);
	}
	
	/**
	 * Retorna una llista de tots els jugadors ordenats de forma descendent
	 * en funció del seu percentatge d'èxit.
	 * @return Llista ordenada de jugadors.
	 */
	
	@GetMapping("/ranking")
	public List<Player> readRanking() {
		List<Player> players = repository.findAll()
			.stream()
			.sorted(Comparator.comparing(Player::getName)) // TODO
			.collect(Collectors.toList());
		
		return players;
	}
	
	/**
	 * Retorna el jugador amb pitjor percentatge d'èxit.
	 * @return Jugador amb pitjor percentatge d'èxit.
	 */
	
	@GetMapping("/ranking/loser")
	public Optional<Player> readLoser() {
		return repository.findAll()
				.stream()
				.min(Comparator.comparing(Player::getName)); // TODO
	}
	
	/**
	 * Retorna el jugador amb millor percentatge d'èxit.
	 * @return Jugador amb millor percentatge d'èxit.
	 */
	
	@GetMapping("/ranking/winner")
	public Optional<Player> readWinner() {
		return repository.findAll()
			.stream()
			.max(Comparator.comparing(Player::getName)); // TODO
	}
	
}
