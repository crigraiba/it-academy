package com.vehicles.project;

import java.time.LocalDate;

public class Driver extends Person {

	public Driver(String name, String lastName, LocalDate dateOfBirth, DriverLicense driverLicense) {
		super(name, lastName, dateOfBirth, driverLicense);
	}
	
	public int getDriverLicenseType() {
		int type = driverLicense.getDriverLicenseType();
		return type;
	}
	
	public String printDriver() {
		return "DADES DEL CONDUCTOR\n\nNom = " + name + "\nCognoms = " + lastName + "\nData de naixement = " + dateOfBirth + driverLicense.getInfo();
	}
	
}
