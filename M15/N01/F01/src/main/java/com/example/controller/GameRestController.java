package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.repository.IGameRepository;
import com.example.domain.Game;

@RestController
@RequestMapping("/players/{id}/games")
public class GameRestController {
	
	@Autowired
	IGameRepository repository;
	
	// Lectura:
	/**
	 * Retorna una llista de totes les tirades d'un jugador.
	 * @param id Identificador únic del jugador.
	 * @return Llista de tirades.
	 */
	
	@GetMapping
	public ArrayList<Game> read(@PathVariable String id) {
		return repository.findAllByPlayerId(id);
	}
	
	// Creació:
	/**
	 * Crea una tirada.
	 * @param id Identificador únic del jugador.
	 * @param game Nova tirada.
	 */
	
	@PostMapping
	public void create(@PathVariable String id, @RequestParam Game game) {
		game.setId(id);
		repository.save(game);
	}
	
	// Eliminació:
	/**
	 * Elimina totes les tirades d'un jugador.
	 * @param id Identificador únic del jugador.
	 */
	
	@DeleteMapping
	public void delete(@PathVariable String id) {
		repository.deleteAll(repository.findAllByPlayerId(id));
	}
	
}
