package com.vehicles.project;

public class Wheel {
	
	private String brand;
	private double diameter;
	
	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Wheel other = (Wheel) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (Double.doubleToLongBits(diameter) != Double.doubleToLongBits(other.diameter))
		 	return false;
		return true;
	}
	
	public String getInfo() {
		return "Marca = " + brand + "\nDiàmetre = " + diameter + " m";
	}
	
}
