package com.example.domain;

public class Employee {
	
	private int id;
	private static int count = 1;
	private String name, job;
	private double salary;
	
	// Mètodes constructors:
	public Employee() {
	}
	
	public Employee(String name, EJob job) {
		//this.id = count++;
		this.name = name;
		this.job = job.name();
		this.salary = job.getSalary();
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
