package com.example.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.repository.InMemoryEmployeeRepository;
import com.example.domain.Employee;
import com.example.domain.EJob;
import com.example.controller.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	InMemoryEmployeeRepository repository = new InMemoryEmployeeRepository();
	
	// Lectura:
	@GetMapping
	public ArrayList<Employee> read() {
		ArrayList<Employee> employees = repository.read();
		return employees;
	}
	
	@GetMapping("/{id}")
	public Employee readById(@PathVariable int id) {
		Employee employee = repository.readById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		return employee;
	}
	
	// Creació:
	@PostMapping
	public void create(@Valid @RequestParam String name, @Valid @RequestParam EJob job) {
		Employee employee = new Employee(name, job);
		
		repository.create(employee);
	}
	
	// Eliminació:
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		// Comprovem que l'empleat existeixi:
		this.readById(id);
		
		repository.delete(id);
	}
	
	// Actualització:
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @Valid @RequestBody Map<String, String> json) {
		// Comprovem que l'empleat existeixi:
		this.readById(id);
		
		String name = json.get("name");
		EJob job = EJob.valueOf(json.get("job"));
		
		Employee employee = new Employee(name, job);
		employee.setId(id);
		
		repository.update(employee);
	}
	
	// Filtratge:
	@GetMapping(params = "job")
	public ArrayList<Employee> filterByJob(@Valid @RequestParam EJob job) {
		ArrayList<Employee> employees = repository.filterByJob(job.name());
		return employees;
	}
	
}
