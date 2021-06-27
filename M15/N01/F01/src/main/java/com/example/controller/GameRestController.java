package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.example.service.PlayerService;
import com.example.service.GameService;
import com.example.domain.Player;
import com.example.domain.Game;
import com.example.controller.exception.PlayerNotFoundException;

@RestController
@RequestMapping("/players/{id}/games")
public class GameRestController {

	@Autowired
	PlayerService playerService;
	@Autowired
	GameService gameService;
	
	// Lectura:
	/**
	 * Retorna una llista de totes les tirades d'un jugador.
	 * @param id Identificador únic del jugador.
	 * @return Llista de tirades.
	 */
	
	@GetMapping
	public List<Game> readByPlayerId(@PathVariable int id) {
		// Comprovem que el jugador existeixi:
		playerService.readById(id)
			.orElseThrow(() -> new PlayerNotFoundException(id));
		
		return gameService.readByPlayerId(id);
	}
	
	// Creació:
	/**
	 * Crea una tirada.
	 * @param id Identificador únic del jugador.
	 * @param game Nova tirada.
	 */
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@PathVariable int id) {
		// Comprovem que el jugador existeixi:
		Player player = playerService.readById(id)
			.orElseThrow(() -> new PlayerNotFoundException(id));
		
		Game game = new Game();
		game.setPlayer(player);
		
		gameService.create(game);
	}
	
	// Eliminació:
	/**
	 * Elimina totes les tirades d'un jugador.
	 * @param id Identificador únic del jugador.
	 */
	
	@DeleteMapping
	public void deleteByPlayerId(@PathVariable int id) {
		// Comprovem que el jugador existeixi:
		playerService.readById(id)
			.orElseThrow(() -> new PlayerNotFoundException(id));
		
		gameService.deleteByPlayerId(id);
	}
	
}
