package com.example.controller.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalControllerAdvice {
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND) // 404
	public String handleException(ResourceNotFoundException e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
	@ExceptionHandler(value = ShopCapacityReachedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
	public String handleException(ShopCapacityReachedException e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return e.getClass().getSimpleName() + ": " + e.getMessage();
	}
	
}
