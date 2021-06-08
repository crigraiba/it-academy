package com.example.repository;

import java.util.ArrayList;

import com.example.domain.Employee;

import org.springframework.data.repository.CrudRepository;

public interface IMySqlJpaEmployeeRepository extends CrudRepository<Employee, Integer> {
	
	ArrayList<Employee> findByJob(String job);
	
}
