package com.example.domain;

public enum EJob {
	
	// Cada feina té assignat un sou:
	ADVOCAT(2000), CAIXER(1750), ENGINYER(1500), QUÍMIC(1250);
	
	private double salary;
	
	private EJob(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}

}
