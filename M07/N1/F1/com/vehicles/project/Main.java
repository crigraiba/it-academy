package com.vehicles.project;

public class Main {

	public static void main(String[] args) {
		
		// Demana a l'usuari que introdueixi els valors de plate, brand i color:
		String[] stringArray = VehicleMenu.getVehicleParams();
		// Instancia la classe Car passant com a arguments els valors obtinguts anteriorment:
		VehicleMenu.createVehicle(stringArray);
		// Demana a l'usuari que introdueixi els valors de brand i diameter referents a les rodes i les crea:
		Vehicle vehicle = VehicleMenu.createWheels();
		// Imprimeix les dades del vehicle constru�t:
		System.out.println(vehicle.printVehicle());
		
	}

}
