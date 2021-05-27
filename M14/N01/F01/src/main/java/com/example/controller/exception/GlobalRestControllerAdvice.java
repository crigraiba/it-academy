package com.example.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalRestControllerAdvice {
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND) // 404
	public String resourceNotFoundException(ResourceNotFoundException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		return e.getMessage();
	}
	
}
