package model.domain;

public class Propeller {
	
	private int currentPower = 0;
	private int maxPower;
	
	// Mètode constructor:
	public Propeller(int maxPower) {
		this.maxPower = maxPower;
	}
	
	// Mètode getter:
	public int getCurrentPower() {
		return currentPower;
	}
	
	public int getMaxPower() {
		return maxPower;
	}
	
	// Altres mètodes:
	// Modifica la potència actual fins assolir la potència objectiu:
	public void changeCurrentPower(String identifier, int i, int targetPower, int increment) {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (currentPower != targetPower) {
					System.out.println("\t" + identifier + " Propulsor " + i + " Potència/W = " + currentPower);
					
					currentPower += increment;
				}
				
				System.out.println("\t" + identifier + " Propulsor " + i + " Potència/W = " + currentPower + " Objectiu assolit.");
			}
		};
		
		t.start();
	}
	
}
