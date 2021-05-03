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
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						System.err.println("\t" + getName() + " Fil adormit interromput."); // TODO
						
						return;
					}
					
					System.out.println("\t\t" + getName() + " Potència/W = " + currentPower); // TODO
					
					if (Math.abs(currentPower-targetPower) > Math.abs(increment))
						currentPower += increment;
					else // Math.abs(currentPower-targetPower) =< Math.abs(increment)
						currentPower = targetPower;
				}
				
				System.out.println("\t\t" + getName() + " Potència/W = " + currentPower + " Objectiu assolit."); // TODO
			}
		};
		
		t.setName(identifier + "-" + (i+1));
		t.start();
		
		return t;
	}
	
}
