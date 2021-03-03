package com.vehicles.project;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonMenu {
	
	static Scanner sc = new Scanner(System.in);
	
	static VehicleOwner vehicleOwner;
	static Driver driver;
	static DriverLicense driverLicense;
	static int type, response;
	private static String name, lastName;
	private static LocalDate dateOfBirth;
	private static boolean insurance, ownsGarage;

	public static void setPersonParams() {
		System.out.print("Nom = ");
		name = sc.nextLine();
		System.out.print("Cognoms = ");
		lastName = sc.nextLine();
		
		boolean isSet;
		do {
			try {
				System.out.print("Data de naixement = ");
				dateOfBirth = LocalDate.parse(sc.nextLine());
				isSet = true;
			} catch (DateTimeParseException e) {
				System.err.println("El format de la data ha de ser AAAA-MM-DD.");
				isSet = false;
			}
		} while (!isSet);
		
		driverLicense = PersonMenu.createDriverLicense(name + " " + lastName);
	}
	
	public static DriverLicense createDriverLicense(String fullName) {
		System.out.println("\nLlicència de conduir");
		
		String id;
		LocalDate expirationDate = null;
		
		System.out.print("ID = ");
		id = sc.nextLine();
		
		System.out.println("Tria un tipus:\n1. MOTO\n2. COTXE\n3. CAMIÓ");
		do {
			try {
				type = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Has d'introduir un número.");
			}
		} while (type != 1 && type != 2 && type != 3);
		
		boolean isSet;
		do {
			try {
				System.out.print("Data de caducitat = ");
				expirationDate = LocalDate.parse(sc.nextLine());
				isSet = true;
			} catch (DateTimeParseException e) {
				System.err.println("El format de la data ha de ser AAAA-MM-DD.");
				isSet = false;
			}
		} while (!isSet);
		
		System.out.print("\n");
		
		return new DriverLicense(id, type, fullName, expirationDate);
	}
	
	public static int createVehicleOwner() {
		System.out.println("TITULAR DEL VEHICLE\n");
		
		PersonMenu.setPersonParams();
		
		vehicleOwner = new VehicleOwner(name, lastName, dateOfBirth, driverLicense);
		
		System.out.println("Té assegurança?\n1. SÍ\n2. NO");
		
		response = 0;
		do {
			try {
				response = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Has d'introduir un número.");
			}
		} while (response != 1 && response != 2);
		
		switch (response) {
		case 1:
			insurance = true;
			break;
		case 2:
			insurance = false;
		}

		System.out.println("Té garatge propi?\n1. SÍ\n2. NO");
		
		response = 0;
		do {
			try {
				response = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Has d'introduir un número.");
			}
		} while (response != 1 && response != 2);
		
		switch (response) {
		case 1:
			ownsGarage = true;
			break;
		case 2:
			ownsGarage = false;
		}
		
		vehicleOwner.setAdditionalData(insurance, ownsGarage);
		
		System.out.print("\n\n");
		
		return type;
	}
	
	public static int chooseDriver() {
		System.out.println("CONDUCTOR\n");
		// TODO if drivers list isEmpty?? preg si vehicleOwner és conductor
		System.out.println("El titular del vehicle en serà el conductor?\n1. SÍ\n2. NO");
		
		response = 0;
		do {
			try {
				response = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Has d'introduir un número.");
			}
		} while (response != 1 && response != 2);
		
		if (response == 1) {
			System.out.println("Has triat que el titular del vehicle en sigui el CONDUCTOR.\n");
			driver = new Driver(name, lastName, dateOfBirth, driverLicense);
		} else if (response == 2) {
			System.out.println("Cal crear un conductor.\n");
			driver = PersonMenu.createDriver();
			type = driver.getDriverLicenseType();
		}
		
		System.out.print("\n");
		
		return type;
	}
	
	public static Driver createDriver() {
		PersonMenu.setPersonParams();
		
		driver = new Driver(name, lastName, dateOfBirth, driverLicense);
		
		return driver;
	}
	
	static List<Person> peopleRepository = new ArrayList<>();
	
	public static void addToPeopleRepository(int subclass) {
		Person person;
		
		switch (subclass) {
		case 1:
			person = vehicleOwner;
			break;
		default: // case 2:
			person = driver;
		}
		
		peopleRepository.add(person);
	}
	
	public static String printPeopleRepositorySize() {
		return "Total de persones = " + peopleRepository.size();
	}
	
	public static void setVehicleOwner(Vehicle vehicle) {
		vehicle.setVehicleOwner(vehicleOwner);
	}
	
	public static void setDriver(Vehicle vehicle) {
		vehicle.setDriver(driver);
	}
}
