package com.example.controller.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // 404
public class EmployeeNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException(int id) {
		super("No s'ha trobat cap empleat amb ID=" + id + " a la base de dades.");
	}
	
}
