package com.example.controller.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalControllerAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleException(EmployeeNotFoundException e) {
		return e.getClass() + " " + e.getMessage();
	}
	
	@ExceptionHandler(SQLException.class)
	public String handleException(SQLException e) {
		return e.getClass() + " " + e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return e.getClass() + " " + e.getMessage();
	}
	
}
