package com.vehicles.project;

import java.util.List;

public class Truck extends Vehicle {
	
	public Truck(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	@Override
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}
	
	public void addTwoWheels(List<Wheel> wheels) {
		try {
			if (wheels.size() != 2)
				throw new Exception();
		} catch (Exception e) {
			System.err.println("wheels.size() != 2");
		}
		
		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);
		
		try {
			if(!rightWheel.equals(leftWheel))
				throw new Exception();
		} catch (Exception e) {
			System.err.println("!rightWheel.equals(leftWheel)");
		}
		
		this.wheels.add(rightWheel);
		this.wheels.add(leftWheel);
	}

}
