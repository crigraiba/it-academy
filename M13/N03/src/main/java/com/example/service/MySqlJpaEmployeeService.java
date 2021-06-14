package com.example.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Employee;
import com.example.repository.IMySqlJpaEmployeeRepository;

@Service
public class MySqlJpaEmployeeService implements IEmployeeService {
	
	@Autowired
	IMySqlJpaEmployeeRepository repository;
	
	// Lectura:
	@Override
	public ArrayList<Employee> read() {
		return (ArrayList<Employee>) repository.findAll();
	}
	
	@Override
	public Optional<Employee> readById(int id) {
		return repository.findById(id);
		
		//return Optional.of(employee);
	}
	
	// Creació:
	@Override
	public void create(Employee employee) {
		repository.save(employee);
	}
	
	// Eliminació:
	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	// Actualització:
	@Override
	public void update(Employee employee) {
		repository.save(employee);
	}
	
	// Filtratge:
	@Override
	public ArrayList<Employee> filterByJob(String job) {
		return repository.findByJob(job);
	}
	
}
