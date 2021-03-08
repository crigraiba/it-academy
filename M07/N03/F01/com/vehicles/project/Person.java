package com.vehicles.project;

import java.time.LocalDate;

public class Person {

	protected String name;
	protected String lastName;
	protected LocalDate dateOfBirth;
	protected DriverLicense driverLicense;
	
	protected int id;
	private static int COUNTER_PEOPLE = 1;
	
	public Person(String name, String lastName, LocalDate dateOfBirth, DriverLicense driverLicense) {
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.driverLicense = driverLicense;
		
		id = COUNTER_PEOPLE;
		COUNTER_PEOPLE++;
	}
	
	public int getPersonId() {
		return id;
	}
	
}
