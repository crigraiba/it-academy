package com.example.repository;

import java.util.ArrayList;
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
		
		for (int i = 0; i < names.length/4; i++) {
			employees.add(new Employee(count++, names[i], EJob.ADVOCAT.name(), EJob.ADVOCAT.getSalary()));
			employees.add(new Employee(count++, names[i+1], EJob.CAIXER.name(), EJob.CAIXER.getSalary()));
			employees.add(new Employee(count++, names[i+2], EJob.ENGINYER.name(), EJob.ENGINYER.getSalary()));
			employees.add(new Employee(count++, names[i+3], EJob.QUÍMIC.name(), EJob.QUÍMIC.getSalary()));
		}
	}
	
	// Lectura:
	public ArrayList<Employee> read() {
		return employees;
	}
	
	public Employee readById(int id) {
		for (Employee emp : employees) {
			if (id == emp.getId())
				return emp;
		}
		
		return null;
	}
	
	// Creació:
	public void create(Employee employee) {
		employee.setId(count++);
		employees.add(employee);
	}
	
	// Eliminació:
	public void delete(int id) {
		Employee emp = this.readById(id);
		employees.remove(emp);
	}
	
	// Actualització:
	public void update(Employee employee) {
		Employee emp = this.readById(employee.getId());
		
		emp.setName(employee.getName());
		emp.setJob(employee.getJob());
		emp.setSalary(employee.getSalary());
	}
	
	// Filtratge:
	public ArrayList<Employee> filterByJob(String job) {
		return employees
			.stream()
			.filter(employee -> job == employee.getJob())
			.collect(Collectors.toCollection(ArrayList<Employee>::new));
	}

}
