package com.example.controller.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
	
	@ExceptionHandler(PlayerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle(PlayerNotFoundException e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	public String handle(Exception e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
}
