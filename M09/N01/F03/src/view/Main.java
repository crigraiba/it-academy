// Carrera de coets

package view;

import controller.RocketController;

public class Main {
	
	private static RocketController rocketController = new RocketController();

	public static void main(String[] args) {
		// Creem dues instàncies de la classe Rocket:
		rocketController.createRocket("32WESSDS", new int[] {10, 30, 80});
		rocketController.createRocket("LDSFJA32", new int[] {30, 40, 50, 50, 30, 10});
		
		rocketController.printRockets();
		
		// Modifiquem la velocitat dels coets:
		rocketController.changeTotalPower("32WESSDS", new int[] {5, 15, 40});
		rocketController.changeTotalPower("LDSFJA32", new int[] {15, 20, 25, 25, 15, 5});
	}

}
