package com.example.controller.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public String handle(Exception e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
}
