package com.example.controller.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalControllerAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleException(EmployeeNotFoundException e) {
		return e.getClass() + " " + e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return e.getClass() + " " + e.getMessage();
	}
	
}
