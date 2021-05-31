package com.example.controller.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String resource, int id) {
		super("No s'ha trobat cap " + resource + " amb id = " + id + " a la base de dades.");
	}
	
}
