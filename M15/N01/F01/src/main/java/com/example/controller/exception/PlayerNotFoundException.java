package com.example.controller.exception;

public class PlayerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public PlayerNotFoundException(int id) {
		super("No s'ha trobat cap jugador amb id = " + id + " a la base de dades.");
	}

}
