package model.domain;

public class Propeller {
	
	private int currentPower = 0;
	private int maxPower;
	
	// Mètode constructor:
	public Propeller(int maxPower) {
		this.maxPower = maxPower;
	}
	
	// Mètodes getter:
	public int getCurrentPower() {
		return currentPower;
	}
	
	public int getMaxPower() {
		return maxPower;
	}
	
	// Altres mètodes:
	// Modifica la potència actual fins assolir la potència objectiu:
	public Thread changeCurrentPower(String identifier, int i, int targetPower, int increment) {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (currentPower != targetPower) {
					System.out.println("\t\t" + identifier + " Propulsor " + i + " Potència/W = " + currentPower); // TODO
					
					currentPower += increment;
				}
				
				System.out.println("\t\t" + identifier + " Propulsor " + i + " Potència/W = " + currentPower + " Objectiu assolit."); // TODO
			}
		};
		
		t.start();
		
		return t;
	}
	
}
