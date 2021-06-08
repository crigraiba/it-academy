package com.example.service;

import java.util.ArrayList;

import com.example.domain.Employee;

public interface IEmployeeService {
	
	// Lectura:
	public ArrayList<Employee> read();
	
	public Employee readById(int id);
	
	// Creació:
	public void create(Employee employee);
	
	// Eliminació:
	public void delete(int id);
	
	// Actualització:
	public void update(Employee employee);

	// Filtratge:
	public ArrayList<Employee> filterByJob(String job);
	
}
