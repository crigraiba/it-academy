package com.vehicles.project;

import java.time.LocalDate;

public class Person {

	protected String name;
	protected String lastName;
	protected LocalDate dateOfBirth;
	protected DriverLicense driverLicense;
	
	public Person(String name, String lastName, LocalDate dateOfBirth, DriverLicense driverLicense) {
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.driverLicense = driverLicense;
	}
	
}
