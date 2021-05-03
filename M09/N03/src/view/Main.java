// Carrera de coets

package view;

import controller.RocketController;

public class Main {
	
	private static RocketController rocketController = new RocketController();

	public static void main(String[] args) {
		// Creem dues instàncies de la classe Rocket:
		String identifier1, identifier2;
		
		identifier1 = "32WESSDS";
		identifier2 = "LDSFJA32";
		
		rocketController.createRocket(identifier1, new int[] {10, 30, 80});
		rocketController.createRocket(identifier2, new int[] {30, 40, 50, 50, 30, 10});
		
		rocketController.printRockets();
		
		// Construïm la interfície gràfica d'usuari:
		new GUI(rocketController, identifier1, identifier2);
	}

}
