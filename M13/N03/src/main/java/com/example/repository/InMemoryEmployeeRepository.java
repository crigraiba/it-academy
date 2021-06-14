package com.example.repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.domain.EJob;
import com.example.domain.Employee;

@Repository
public class InMemoryEmployeeRepository {
	
	private ArrayList<Employee> employees;
	private int count = 1; // Autoincrement
	
	public InMemoryEmployeeRepository() {
		employees = new ArrayList<Employee>();
		
		String[] names = {
				"Anna", "Ariadna", "Marta", "Cristina",
				"Gloria", "Zaarai", "Àliç", "Esther",
				"Fabiola", "Viviana", "Emily", "Érika"
			};
		
		for (int i = 0; i < names.length; i++) {
			employees.add(new Employee(names[i++], EJob.ADVOCAT));
			employees.add(new Employee(names[i++], EJob.CAIXER));
			employees.add(new Employee(names[i++], EJob.ENGINYER));
			employees.add(new Employee(names[i], EJob.QUÍMIC));
		}
		
		for (Employee employee : employees)
			employee.setId(count++);
	}
	
	// Lectura:
	public ArrayList<Employee> read() {
		return employees;
	}
	
	public Optional<Employee> readById(int id) {
		for (Employee employee : employees) {
			if (id == employee.getId())
				return Optional.of(employee);
		}
		
		return Optional.empty();
	}
	
	// Creació:
	public void create(Employee employee) {
		employee.setId(count++);
		employees.add(employee);
	}
	
	// Eliminació:
	public void delete(int id) {
		Employee employee = this.readById(id).get();
		employees.remove(employee);
	}
	
	// Actualització:
	public void update(Employee update) {
		Employee employee = this.readById(update.getId()).get();
		
		employee.setName(update.getName());
		employee.setJob(update.getJob());
		employee.setSalary(update.getSalary());
	}
	
	// Filtratge:
	public ArrayList<Employee> filterByJob(String job) {
		return employees
			.stream()
			.filter(employee -> job == employee.getJob())
			.collect(Collectors.toCollection(ArrayList<Employee>::new));
	}

}
