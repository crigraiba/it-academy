package com.vehicles.project;

import java.time.LocalDate;

public class VehicleOwner extends Person {

	private boolean insurance;
	private boolean ownsGarage;
	
	public VehicleOwner(String name, String lastName, LocalDate dateOfBirth, DriverLicense driverLicense) {
		super(name, lastName, dateOfBirth, driverLicense);
	}
	
	public void setAdditionalData(boolean insurance, boolean ownsGarage) {
		this.insurance = insurance;
		this.ownsGarage = ownsGarage;
	}
	
	public int getDriverLicenseType() {
		int type = driverLicense.getDriverLicenseType();
		return type;
	}
	
	public String printVehicleOwner() {
		String textInsurance;
		String textOwnsGarage;
		
		if (insurance == true) {
			textInsurance = "Té assegurança";
		} else {
			textInsurance = "No té assegurança";
		}
		if (ownsGarage == true) {
			textOwnsGarage = "Té garatge propi";
		} else {
			textOwnsGarage = "No té garatge propi";
		}
		
		return "[ID = " + getPersonId() + ", Nom = " + name + ", Cognoms = " + lastName + ", Data de naixement = " + dateOfBirth + ", " + textInsurance + ", " + textOwnsGarage + ", Llicència de conduir: "+ driverLicense.getInfo() + "]";
	}
	
}
