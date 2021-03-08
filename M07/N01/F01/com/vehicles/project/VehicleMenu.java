package com.vehicles.project;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class VehicleMenu {

	private static Vehicle vehicle;
	
	static Scanner sc = new Scanner(System.in);
	
	public static String[] getVehicleParams() {
		String[] stringArray = new String[3];
		
		System.out.print("Matrícula = ");
		stringArray[0] = sc.nextLine();
		System.out.print("Marca = ");
		stringArray[1] = sc.nextLine();
		System.out.print("Color = ");
		stringArray[2] = sc.nextLine();
		
		return stringArray;
	}
	
	public static void createVehicle(String[] stringArray) {
		String plate, brand, color;
		
		plate = stringArray[0];
		brand = stringArray[1];
		color = stringArray[2];
		
		vehicle = new Car(plate, brand, color);
	}
	
	public static Vehicle createWheels() {
		String brand;
		double diameter;
		
		List<Wheel> frontWheels = new ArrayList<>();
		List<Wheel> backWheels = new ArrayList<>();
		
		for (int i = 0; i < 2*2; i++) {
			if (i == 0) {
				System.out.println("\nRodes davanteres");
			} else if (i == 2) {
				System.out.println("\nRodes traseres");
			}
			
			System.out.println("Roda nº" + (i+1));
			System.out.print("Marca = ");
			brand = sc.nextLine();
			do {
				try {
					System.out.print("Diàmetre (en m) = ");
					diameter = Double.parseDouble(sc.nextLine());
				} catch (NumberFormatException e) {
					System.err.println("Has d'introduir un número entre 0.4 i 4.");
					diameter = 0;
				}
			} while (diameter <= 0);
			
			if (i < 2) {
				frontWheels.add(new Wheel(brand, diameter));
			} else {
				backWheels.add(new Wheel(brand, diameter));
			}
		}
		
		vehicle.addWheels(frontWheels, backWheels);
		
		sc.close();
		
		return vehicle;
	}
	
}
