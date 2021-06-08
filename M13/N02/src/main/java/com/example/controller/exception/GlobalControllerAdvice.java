package com.example.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseBody
	public String handleException(EmployeeNotFoundException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public String handleException(SQLException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception e) {
		return e.getMessage();
	}
	
}
