package com.vehicles.project;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class VehicleMenu {

	private static int choice;
	private static Vehicle vehicle;
	
	static Scanner sc = new Scanner(System.in);
	
	public static int chooseVehicle() {
		System.out.println("Tria una opció:\n1. MOTO\n2. COTXE\n3. CAMIÓ");
		
		do {
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Has d'introduir un número.");
			}
		} while (choice != 1 && choice != 2 && choice != 3);
		
		switch (choice) {
		case 1:
			System.out.println("Has triat l'opció 1. Es procedirà a crear una MOTO.\n");
			break;
		case 2:
			System.out.println("Has triat l'opció 2. Es procedirà a crear un COTXE.\n");
			break;
		case 3:
			System.out.println("Has triat l'opció 3. Es procedirà a crear un CAMIÓ.\n");
		}
		
		return choice;
	}
	
	public static String[] getVehicleParams() {
		String[] stringArray = new String[3];
		
		int num;
		int letter;
		do { // Validació de la matrícula:
			num = 0;
			letter = 0;
			
			System.out.print("Matrícula = ");
			stringArray[0] = sc.nextLine();
			
			try {
				for (int i = 0; i < stringArray[0].length(); i++) {
					if (Character.isDigit(stringArray[0].charAt(i))) {
						num += 1;
					} else if (Character.isLetter(stringArray[0].charAt(i))) {
						letter += 1;
					} else {
						throw new Exception();
					}
				}
				
				// num == 4 && (letter == 2 || letter == 3)
				if (num != 4 || (letter != 2 && letter != 3))
					throw new Exception();
			} catch (Exception e) {
				System.err.println("La matrícula ha de constar de 4 números i 2 o 3 lletres.");
			}
		} while (num != 4 || (letter != 2 && letter != 3));
		
		
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
		
		if (choice == 1) {
			vehicle = new Bike(plate, brand, color);
		} else if (choice == 2) {
			vehicle = new Car(plate, brand, color);
		} else if (choice == 3) {
			vehicle = new Truck(plate, brand, color);
		}
	}
	
	public static Vehicle createWheels() {
		String brand;
		double diameter;
		
		List<Wheel> frontWheels = new ArrayList<>();
		List<Wheel> backWheels = new ArrayList<>();
		
		for (int i = 0; i < choice*2; i++) {
			if (choice == 3)
				choice -= 1;
			
			if (i == 0) {
				System.out.println("\nRodes davanteres");
			} else if (i == choice) {
				System.out.println("\nRodes traseres");
			}
			
			System.out.println("Roda nº" + (i+1));
			System.out.print("Marca = ");
			brand = sc.nextLine();
			do { // Validació del diàmetre:
				try {
					System.out.print("Diàmetre (en m) = ");
					diameter = Double.parseDouble(sc.nextLine());
					if (!(diameter >= 0.4 && diameter <= 4))
						throw new NumberFormatException();
				} catch (NumberFormatException e) {
					System.err.println("Has d'introduir un número entre 0.4 i 4.");
					diameter = 0;
				}
			} while (!(diameter >= 0.4 && diameter <= 4));
			
			if (i < choice) {
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
