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

		// Modifiquem la potència total dels coets:
		rocketController.changeTotalPower(new int[] {5, 15, 40}, new int[] {15, 20, 25, 25, 15, 5}); // estat inicial
		rocketController.printRockets();

		// rocketController.changeTotalPower(new int[] {10, 10, 10}, new int[] {10, 10, 10, 10, 10, 10});
		// rocketController.printRockets();
		
		// Modifiquem la velocitat dels coets:
		rocketController.changeVelocities(200, 600); // Exemple d'acceleració
		rocketController.printRockets();
		
		rocketController.changeVelocities(0, 200); // Exemple de deceleració
		rocketController.printRockets();
	}

}
