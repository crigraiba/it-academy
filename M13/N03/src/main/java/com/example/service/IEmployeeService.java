package com.example.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.domain.Employee;

public interface IEmployeeService {
	
	// Lectura:
	public ArrayList<Employee> read();
	
	public Optional<Employee> readById(int id);
	
	// Creaci�:
	public void create(Employee employee);
	
	// Eliminaci�:
	public void delete(int id);
	
	// Actualitzaci�:
	public void update(Employee employee);

	// Filtratge:
	public ArrayList<Employee> filterByJob(String job);
	
}
