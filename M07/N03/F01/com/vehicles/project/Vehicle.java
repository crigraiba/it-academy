package com.vehicles.project;

import java.util.List;
import java.util.ArrayList;

public abstract class Vehicle {
	
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	private VehicleOwner vehicleOwner;
	private List<Driver> drivers = new ArrayList<Driver>();
	
	protected int id;
	private static int COUNTER_VEHICLES = 1;
	
	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
		
		id = COUNTER_VEHICLES;
		COUNTER_VEHICLES++;
	}
	
	public abstract void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels);
	
	public void setVehicleOwner(VehicleOwner vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}
	
	public void setDriver(Driver driver) {
		this.drivers.add(driver);
	}
	
	public boolean isDriversEmpty() {
		return drivers.isEmpty();
	}
	
	public String printVehicle(int choice) {
		choice = vehicleOwner.getDriverLicenseType();
		
		String textChoice;

		if (choice == 1) {
			textChoice = "MOTO";
		} else if (choice == 2) {
			textChoice = "COTXE";
		} else { // choice == 3
			textChoice = "CAMI�";
			choice -= 1;
		}
		
		StringBuilder sbWheels = new StringBuilder();
		StringBuilder sbDrivers = new StringBuilder();
		
		sbWheels.append("[");
		for (int i = 0; i < choice*2; i++) {
			if (i == 0) {
				sbWheels.append("Rodes davanteres: [");
			} else if (i == choice) {
				sbWheels.append(", Rodes traseres: [");
			}
			
			sbWheels.append("Roda n�" + (i+1) + ": " + wheels.get(i).getInfo());
			
			if (i < choice*2-1 && i != choice-1) { // No s'afegeix ", " despr�s de l'�ltima roda davantera ni de l'�ltima roda trasera.
				sbWheels.append(", ");
			} else if (i == choice*2-1 || i == choice-1) { // S'afegeix "]" depr�s de l'�ltima roda davantera i de l'�ltima roda trasera.
				sbWheels.append("]");
			}
		}
		sbWheels.append("]");

		sbDrivers.append("[");
		for (int i = 0; i < drivers.size(); i++) {
			sbDrivers.append(drivers.get(i).printDriver());
			if (i < drivers.size()-1) { // S'afegeix ", " despr�s de tots els conductors menys de l'�ltim.
				sbDrivers.append(", ");
			}
		}
		sbDrivers.append("]");
		
		return "[ID = " + id + ", Tipus = " + textChoice + ", Matr�cula = " + plate + ", Marca = " + brand + ", Color = " + color + ", Rodes: " + sbWheels + ", Titular del vehicle: " + vehicleOwner.printVehicleOwner() + ", Conductors: " + sbDrivers + "]";
	}
	
}
