package com.example.controller.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice
public class GlobalControllerAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND) // 404
	public String handleException(EmployeeNotFoundException e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
}
