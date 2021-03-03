package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	@Override
	public void addWheels(List<Wheel> frontWheel, List<Wheel> backWheel) {
		addOneWheel(frontWheel);
		addOneWheel(backWheel);
	}
	
	public void addOneWheel(List<Wheel> wheel) {
		try {
			if (wheel.size() != 1)
				throw new Exception();
		} catch (Exception e) {
			System.err.println("wheel.size() != 2");
		}
		
		Wheel singleWheel = wheel.get(0);
		
		this.wheels.add(singleWheel);
	}

}
