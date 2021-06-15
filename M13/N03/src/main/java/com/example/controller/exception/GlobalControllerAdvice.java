package com.example.controller.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalControllerAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND) // 404
	public String handleException(EmployeeNotFoundException e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
	public String handleException(SQLException e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
}
