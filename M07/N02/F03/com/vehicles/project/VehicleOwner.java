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
			textInsurance = "\nTé assegurança.";
		} else {
			textInsurance = "\nNo té assegurança.";
		}
		if (ownsGarage == true) {
			textOwnsGarage = "\nTé garatge propi.";
		} else {
			textOwnsGarage = "\nNo té garatge propi.";
		}
		
		return "DADES DEL TITULAR DEL VEHICLE\n\nNom = " + name + "\nCognoms = " + lastName + "\nData de naixement = " + dateOfBirth + textInsurance + textOwnsGarage + driverLicense.getInfo();
	}
	
}
