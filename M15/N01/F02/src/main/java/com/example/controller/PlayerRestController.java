package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.example.service.PlayerService;
import com.example.domain.Player;

@RestController
@RequestMapping("/players")
public class PlayerRestController {
	
	@Autowired
	PlayerService playerService;
	
	// Lectura:
	/**
	 * Retorna una llista de jugadors.
	 * @return Llista de jugadors.
	 */
	
	@GetMapping
	public List<Player> read() {
		return playerService.read();
	}
	
	// Creació:
	/**
	 * Crea un jugador.
	 * @param player Nou jugador.
	 */
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Player player) {
		playerService.create(player);
	}
	
	// Actualització:
	/**
	 * Actualitza el nom d'un jugador.
	 * @param id Identificador únic del jugador.
	 * @param player Jugador.
	 */
	
	@PutMapping("/{id}")
	public void update(@PathVariable String id, @RequestBody Player player) {
		player.setId(id);
		playerService.update(player);
	}
	
}
