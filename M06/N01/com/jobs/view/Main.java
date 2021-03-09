package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	// Gesti� dels sous dels empleats d'una empresa
	
	// Flux d'execuci�: Main -> JobsController -> (IPaymentRate -> PaymentFactory) + Boss, Manager, Employee, Volunteer -> EmployeeRepository
	// Her�ncia: AbsStaffMember > Boss, Manager, Employee, Volunteer
	
	private static JobsController controller = new JobsController();
	
	public static void main(String[] args) {
		controller.createBoss("Pepe Boss", "Direcci�n molona 1", "666666666", 100.0);
		controller.createManager("Pedro Manager", "Direcci�n molona 2", "665266666", 80.0);
		controller.createEmployee("Laura Employee", "Direcci�n molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Direcci�n molona 4", "614266666");
		
		// S'aplica un augment o reducci� del salari base en funci� del tipus d'empleat
		controller.payAllEmployees();
		
		String allEmployees = controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees);
	}

}
