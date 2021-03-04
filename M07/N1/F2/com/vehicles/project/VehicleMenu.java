package com.vehicles.project;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class VehicleMenu {

	private static Vehicle vehicle;
	
	static Scanner sc = new Scanner(System.in);
	
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
