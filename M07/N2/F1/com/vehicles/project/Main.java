package com.vehicles.project;

public class Main {

	public static void main(String[] args) {
		
		// Pregunta a l'usuari quin vehicle vol crear:
		int choice = VehicleMenu.chooseVehicle();
		// Demana a l'usuari que introdueixi els valors de plate, brand i color:
		String[] stringArray = VehicleMenu.getVehicleParams();
		// Instancia la classe escollida passant com a arguments els valors obtinguts anteriorment:
		VehicleMenu.createVehicle(stringArray);
		// Demana a l'usuari que introdueixi els valors de brand i diameter referents a les rodes i les crea:
		Vehicle vehicle = VehicleMenu.createWheels();
		// Imprimeix les dades del vehicle construït:
		System.out.println(vehicle.printVehicle(choice));
		
	}

}
