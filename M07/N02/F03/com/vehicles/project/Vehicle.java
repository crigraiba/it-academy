package com.vehicles.project;

import java.util.List;
import java.util.ArrayList;

public abstract class Vehicle {
	
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	
	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	
	public abstract void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels);
	
	public String printVehicle(int choice) {
		String textChoice = new String();
		
		if (choice == 1) {
			textChoice = "MOTO";
		} else if (choice == 2) {
			textChoice = "COTXE";
		} else if (choice == 3) {
			textChoice = "CAMIÓ";
			choice -= 1;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < choice*2; i++) {
			if (i == 0) {
				sb.append("\n\nRodes davanteres");
			} else if (i == choice) {
				sb.append("\n\nRodes traseres");
			}
			
			sb.append("\nRoda nº" + (i+1) + "\n" + wheels.get(i).getInfo());
		}
		
		return "DADES DEL VEHICLE\n\nTipus = " + textChoice + "\nMatrícula = " + plate + "\nMarca = " + brand + "\nColor = " + color + sb;
	}
	
}
