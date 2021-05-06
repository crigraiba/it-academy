package model.domain;

public class Propeller {
	
	private int currentPower = 0;
	private int maxPower;
	
	// M�tode constructor:
	public Propeller(int maxPower) {
		this.maxPower = maxPower;
	}
	
	// M�tode getter:
	public int getCurrentPower() {
		return currentPower;
	}
	
	public int getMaxPower() {
		return maxPower;
	}
	
	// Altres m�todes:
	// Modifica la pot�ncia actual fins assolir la pot�ncia objectiu:
	public void changeCurrentPower(String identifier, int i, int targetPower, int increment) {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (currentPower != targetPower) {
					System.out.println("\t" + identifier + " Propulsor " + i + " Pot�ncia/W = " + currentPower);
					
					currentPower += increment;
				}
				
				System.out.println("\t" + identifier + " Propulsor " + i + " Pot�ncia/W = " + currentPower + " Objectiu assolit.");
			}
		};
		
		t.start();
	}
	
}
