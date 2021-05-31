package com.example.repository;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.domain.EJob;
import com.example.domain.Employee;

@Repository
public class InMemoryEmployeeRepository {
	
	private ArrayList<Employee> employees;
	
	public InMemoryEmployeeRepository() {
		employees = new ArrayList<Employee>();
		
		employees.add(new Employee("Anna", EJob.ADVOCAT));
		employees.add(new Employee("Ariadna", EJob.CAIXER));
		employees.add(new Employee("Marta", EJob.ENGINYER));
		employees.add(new Employee("Cristina", EJob.QUÍMIC));
		employees.add(new Employee("Gloria", EJob.ADVOCAT));
		employees.add(new Employee("Zaarai", EJob.CAIXER));
		employees.add(new Employee("Àliç", EJob.ENGINYER));
		employees.add(new Employee("Esther", EJob.QUÍMIC));
		employees.add(new Employee("Fabiola", EJob.ADVOCAT));
		employees.add(new Employee("Viviana", EJob.CAIXER));
		employees.add(new Employee("Emily", EJob.ENGINYER));
		employees.add(new Employee("Érika", EJob.QUÍMIC));
	}
	
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
	
	public void create(Employee employee) {
		employees.add(employee);
	}
	
	public void delete(int id) {
		Employee emp = this.readById(id);
		employees.remove(emp);
	}
	
	public void update(Employee employee) {
		Employee emp = this.readById(employee.getId());
		
		emp.setName(employee.getName());
		emp.setJob(employee.getJob());
		emp.setSalary(employee.getSalary());
	}
	
	public ArrayList<Employee> filterByJob(String job) {
		return employees
			.stream()
			.filter(emp -> job == emp.getJob())
			.collect(Collectors.toCollection(ArrayList<Employee>::new));
	}

}
