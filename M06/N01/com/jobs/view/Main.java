package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	// Gestió dels sous dels empleats d'una empresa
	
	// Flux d'execució: Main -> JobsController -> (IPaymentRate -> PaymentFactory) + Boss, Manager, Employee, Volunteer -> EmployeeRepository
	// Herència: AbsStaffMember > Boss, Manager, Employee, Volunteer
	
	private static JobsController controller = new JobsController();
	
	public static void main(String[] args) {
		controller.createBoss("Pepe Boss", "Dirección molona 1", "666666666", 100.0);
		controller.createManager("Pedro Manager", "Dirección molona 2", "665266666", 80.0);
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		
		// S'aplica un augment o reducció del salari base en funció del tipus d'empleat
		controller.payAllEmployees();
		
		String allEmployees = controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees);
	}

}
