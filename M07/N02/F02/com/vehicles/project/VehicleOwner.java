package com.vehicles.project;

import java.time.LocalDate;

public class VehicleOwner extends Person {

	private boolean insurance;
	private boolean ownsGarage;
	
	public VehicleOwner(String name, String lastName, LocalDate dateOfBirth, DriverLicense driverLicense) {
		super(name, lastName, dateOfBirth, driverLicense);
	}
	
}
