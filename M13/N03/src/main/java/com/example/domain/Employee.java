package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "job")
	private String job;
	@Column(name = "salary")
	private double salary;
	
	// Mètodes constructors:
	public Employee() {
	}
	
	public Employee(int id, String name, String job, double salary) {
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
	}
	
	// Mètodes setter:
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public void setSalary(double job) {
		this.salary = job;
	}
	
	// Mètodes getter:
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getJob() {
		return job;
	}
	
	public double getSalary() {
		return salary;
	}
	
	// Altres mètodes:
	@Override
	public String toString() {
		return "ID=" + id + ", Nom=" + name + ", Feina=" + job + ", Salari=" + salary;
	}
	
}
