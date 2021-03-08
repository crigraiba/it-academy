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
	
	public String printVehicleOwner() {
		String textInsurance;
		String textOwnsGarage;
		
		if (insurance == true) {
			textInsurance = "\nT� asseguran�a.";
		} else {
			textInsurance = "\nNo t� asseguran�a.";
		}
		if (ownsGarage == true) {
			textOwnsGarage = "\nT� garatge propi.";
		} else {
			textOwnsGarage = "\nNo t� garatge propi.";
		}
		
		return "DADES DEL TITULAR DEL VEHICLE\n\nNom = " + name + "\nCognoms = " + lastName + "\nData de naixement = " + dateOfBirth + textInsurance + textOwnsGarage + driverLicense.getInfo();
	}
	
}
