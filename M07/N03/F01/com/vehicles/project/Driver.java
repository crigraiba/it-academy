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
		return "[ID = " + getPersonId() + ", Nom = " + name + ", Cognoms = " + lastName + ", Data de naixement = " + dateOfBirth + ", Llicència de conduir: "+ driverLicense.getInfo() + "]";
	}
	
}
