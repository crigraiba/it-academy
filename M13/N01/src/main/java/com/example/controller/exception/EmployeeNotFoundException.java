package com.example.controller.exception;

public class EmployeeNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException(int id) {
		super("No s'ha trobat cap empleat amb id = " + id + " a la base de dades.");
	}
	
}
