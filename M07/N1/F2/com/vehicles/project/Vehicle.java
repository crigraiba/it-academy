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
	
	public String printVehicle() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 2*2; i++) {
			if (i == 0) {
				sb.append("\n\nRodes davanteres");
			} else if (i == 2) {
				sb.append("\n\nRodes traseres");
			}
			
			sb.append("\nRoda n�" + (i+1) + "\n" + wheels.get(i).getInfo());
		}
		return "\n\nDADES DEL VEHICLE\n\nTipus = COTXE\nMatr�cula = " + plate + "\nMarca = " + brand + "\nColor = " + color + sb;
	}
	
}
