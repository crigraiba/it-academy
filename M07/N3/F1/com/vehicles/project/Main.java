package com.vehicles.project;

import java.util.Scanner;

public class Main {
	
	/*
	 * TODO
	 * [ ] Llista de persones i de vehicles, quantitat personId i vehicleId ?
	 * [x] Vehicle -> Afegir camps vehicleOwner i Person[] drivers
	 * [x] Quan es crea un vehicle -> Afegir el vehicleOwner i tants driver com es vulgui
	 * [x] Poder crear m�ltiples persones i vehicles
	 * [x] Opci� finalitzar el programa!
	 */
	
	/*
	 * TODO
	 * [x] Afegir personId i vehicleId
	 * [ ] setDriver, setVehicleOwner
	 * [ ] Comentaris Main!
	 */
	
	/*
	 * TODO
	 * No cal break perqu� un vehicle ha de tenir un vehicleOwner i un driver com a m�nim.
	 * Un vehicleOwner pot ser propietari de varios vehicle.
	 * Un driver pot conduir varios vehicles.
	 * Primer fer que es crei un �nic vehicle amb aquest sistema, despr�s implementar que es puguin crear varios vehicles i varies persones.
	 * Tractar errors (option, introducci� d'una lletra...) i fer bucles a Main.
	 */

	public static void main(String[] args) {
		String[] stringArray;
		int choice, type, response;
		boolean isDone, isFinished;
		Vehicle vehicle;
		Driver driver;
		
		Scanner sc = new Scanner (System.in);
		
		isFinished = false;
		do {
			// FASE DE CREACI� D'UN VEHICLE:
			// Pregunta a l'usuari quin vehicle vol crear:
			choice = VehicleMenu.chooseVehicle();
			// Demana a l'usuari que introdueixi els valors dels atributs comuns per tots els vehicles:
			stringArray = VehicleMenu.getVehicleParams();
			// Instancia la classe escollida passant com a arguments els valors obtinguts anteriorment:
			VehicleMenu.createVehicle(stringArray);
			// Afegeix les rodes al vehicle:
			vehicle = VehicleMenu.createWheels();
			
			// Afegeix el vehicle al repositori de vehicles:
			VehicleMenu.addToVehiclesRepository();
			
			System.out.println("El vehicle s'ha creat correctament.\nA continuaci� cal crear el titular del vehicle.\n\n");
			
			// FASE DE CREACI� DEL TITULAR DEL VEHICLE:
			do {
				// Crea el titular del vehicle:
				type = PersonMenu.createVehicleOwner();
				try {
					if (type != choice)
						throw new Exception("invalid type");
				} catch (Exception e) {
					System.err.println("No �s possible crear aquest titular de vehicle. La llic�ncia de conduir ha de correspondre amb el tipus de vehicle.");
				}
			} while (type != choice);
			
			// Afegeix el titular del vehicle al repositori de persones:
			PersonMenu.addToPeopleRepository(1);
			// Inclou el titular del vehicle entre les variables de classe del vehicle:
			PersonMenu.setVehicleOwner(vehicle);
			
			System.out.println("El titular del vehicle s'ha creat correctament.\nA continuaci� cal crear els conductors del vehicle.\n\n");
			
			// FASE DE CREACI� DELS CONDUCTORS:
			isDone = false;
			do {
				if (vehicle.isDriversEmpty()) {
					// Crea un conductor, que pot ser el propi titular del vehicle:
					type = PersonMenu.chooseDriver();
				} else {
					do {
						driver = PersonMenu.createDriver();
						type = driver.getDriverLicenseType();
						try {
							if (type != choice)
								throw new Exception("invalid driver");
						} catch (Exception e) {
							System.err.println("No �s possible crear aquest conductor. La llic�ncia de conduir ha de correspondre amb el tipus de vehicle.");
						}
					} while (type != choice);
				}
				
				// Afegeix el conductor al repositori de persones:
				PersonMenu.addToPeopleRepository(2);
				// Inclou el conductor entre les variables de classe del vehicle:
				PersonMenu.setDriver(vehicle);
				
				System.out.println("El conductor s'ha creat correctament.\n\n");
				
				// Pregunta a l'usuari si vol realitzar una iteraci� m�s:
				System.out.println("Vols afegir un nou conductor?\n1. S�\n2. NO");
				do {
					try {
						response = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException e) {
						System.err.println("Has d'introduir un n�mero.");
						response = 0;
					}
				} while (response != 1 && response != 2);
				if (response == 2)
					isDone = true;
				
				System.out.print("\n\n");
			} while (isDone == false);
		
			// Pregunta a l'usuari si vol realitzar una iteraci� m�s:
			System.out.println("Vols afegir un nou vehicle?\n1. S�\n2. NO");
			do {
				try {
					response = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					System.err.println("Has d'introduir un n�mero.");
					response = 0;
				}
			} while (response != 1 && response != 2);
			if (response == 2)
				isFinished = true;
			
			System.out.print("\n\n");
		} while (isFinished == false);
			
		sc.close();

		// Mostra per pantalla les dades introdu�des per l'usuari:
		// Primer es mostren el total de vehicles i persones creats:
		System.out.println(VehicleMenu.printVehiclesRepositorySize());
		System.out.println(PersonMenu.printPeopleRepositorySize() + "\n");
		// Finalment, es mostren les dades relacionades amb tots els vehicles del repositori, que inclou la informaci� sobre les persones:
		System.out.println(VehicleMenu.printAllVehicles());
	}

}
