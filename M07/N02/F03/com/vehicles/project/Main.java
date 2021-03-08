package com.vehicles.project;

public class Main {

	public static void main(String[] args) {
		String[] stringArray;
		Vehicle vehicle;
		int type, choice;
		boolean invalidChoice, invalidDriver;
		
		// FASE DE CREACI� DEL TITULAR DEL VEHICLE:
		// Crea una inst�ncia de VehicleOwner i DriverLicense, demanant a l'usuari que introdueixi totes les dades necess�ries:
		type = PersonMenu.createVehicleOwner();
		
		invalidChoice = true;
		do { // FASE DE CREACI� DEL VEHICLE:
			try {
				// Pregunta a l'usuari quin vehicle vol crear:
				choice = VehicleMenu.chooseVehicle();
				if (type != choice) {
					throw new Exception("invalid choice");
				} else {
					invalidChoice = false;
				}
				// Demana a l'usuari que introdueixi els valors de plate, brand i color:
				stringArray = VehicleMenu.getVehicleParams();
				// Instancia la classe escollida passant com a arguments els valors obtinguts anteriorment:
				VehicleMenu.createVehicle(stringArray);
				// Demana a l'usuari que introdueixi els valors de brand i diameter referents a les rodes i les crea:
				vehicle = VehicleMenu.createWheels();
				
				invalidDriver = true;
				do { // FASE DE CREACI� DEL CONDUCTOR:
					try {
						// Assigna un conductor al vehicle, que pot ser el propi titular del vehicle:
						type = PersonMenu.chooseDriver();
						if (type != choice) {
							throw new Exception("invalid driver");
						} else {
							invalidDriver = false;
						}
					} catch (Exception e) {
						System.err.println("No �s possible crear aquest conductor. La llic�ncia de conduir ha de correspondre amb el tipus de vehicle.");
					}
				} while (invalidDriver == true);
				
				// Imprimeix les dades del vehicle constru�t:
				System.out.println(vehicle.printVehicle(choice));
				// Imprimeix les dades del titular del vehicle i del conductor:
				System.out.println(PersonMenu.printVehicleOwnerAndDriver());
			} catch (Exception e) {
				System.err.println("No �s possible crear aquest vehicle. La llic�ncia de conduir ha de correspondre amb el tipus de vehicle.");
			}
		} while (invalidChoice == true);
	}

}
