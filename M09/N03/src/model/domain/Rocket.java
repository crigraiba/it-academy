package model.domain;

import java.util.List;
import java.util.ArrayList;

public class Rocket {
	
	private String identifier;
	private Propeller[] propellers;
	private int increment = 1;
	
	// M�tode constructor:
	public Rocket(String identifier, int[] maxPowerArray) {
		this.identifier = identifier;
		
		// Donem un tamany a l'Array propellers:
		propellers = new Propeller[maxPowerArray.length];
		// L'omplim amb inst�ncies de la classe Propeller:
		for (int i = 0; i < propellers.length; i++)
			propellers[i] = new Propeller(maxPowerArray[i]);
	}
	
	// M�tode setter:
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	
	// M�todes getter:
	public String getIdentifier() {
		return identifier;
	}
	
	public Propeller[] getPropellers() {
		return propellers;
	}

	// C�lcul de la pot�ncia total actual:
	public int getCurrentTotalPower() {
		int currentTotalPower = 0;
		
		for (Propeller propeller : propellers)
			currentTotalPower += propeller.getCurrentPower();
		
		return currentTotalPower;
	}
	
	// C�lcul de la velocitat actual:
	public int getCurrentVelocity() {
		int currentTotalPower, currentVelocity;
		
		currentTotalPower = this.getCurrentTotalPower();
		
		currentVelocity = (int) (100*Math.sqrt(currentTotalPower));
		
		return currentVelocity;
	}
	
	// Altres m�todes:
	@Override
	public String toString() {
		StringBuilder sbCurrentPower = new StringBuilder();
		StringBuilder sbMaxPower = new StringBuilder();
		
		for (Propeller propeller : propellers) {
			sbCurrentPower.append(propeller.getCurrentPower());
			sbMaxPower.append(propeller.getMaxPower());
			
			// Separaci� entre valors:
			if(!propeller.equals(propellers[propellers.length-1])) {
				sbCurrentPower.append(", ");
				sbMaxPower.append(", ");
			}
		}
		
		return "Coet " + identifier + " (" + propellers.length + " propulsors):\n\tPot�ncia actual/W = "
			+ sbCurrentPower.toString() + "\n\tPot�ncia m�xima/W = " + sbMaxPower.toString()
			+ "\n\tVelocitat atual/(m/s) = " + this.getCurrentVelocity();
	}

	// Determina si cal disminuir o augmentar la pot�ncia actual de cada propulsor:
	public List<Thread> changeTotalPower(int[] targetPowerArray) throws Exception {
		// Validaci� de la pot�ncia objectiu de cada propulsor:
		this.validateTargetPowerArray(targetPowerArray);
		
		List<Thread> threads = new ArrayList<>();
		
		Thread t = null;
		for (int i = 0; i < propellers.length; i++) {
			if (propellers[i].getCurrentPower() > targetPowerArray[i]) // currentPower > targetPower
				t = propellers[i].changeCurrentPower(identifier, i, targetPowerArray[i], -increment); // disminuci�
			else if (propellers[i].getCurrentPower() < targetPowerArray[i]) // currentPower < targetPower
				t = propellers[i].changeCurrentPower(identifier, i, targetPowerArray[i], +increment); // augment
			else // currentPower = targetPower
				System.out.println("\t\t" + identifier + "-" + (i+1) + " No requereix modificaci�.");
			
			threads.add(t);
		}
		
		return threads;
	}
	
	public int[] getTargetPowerArray(int targetVelocity) throws Exception {
		int currentTotalPower = 0, requiredTotalPower;
		int[] targetPowerArray = new int[propellers.length];
		
		// C�lcul de la pot�ncia total inicial:
		currentTotalPower = this.getCurrentTotalPower();
		
		// C�lcul de la pot�ncia total final:
		requiredTotalPower = (int) Math.pow(targetVelocity/100, 2)-currentTotalPower;
		
		// Validaci� de la velocitat objectiu:
		this.validateTargetVelocity(currentTotalPower, requiredTotalPower, targetVelocity);
		
		// C�lcul de la pot�ncia final de cada propulsor:
		for (int i = 0; i < propellers.length; i++)
			targetPowerArray[i] = propellers[i].getCurrentPower();
		
		for (int i = 0; i < Math.abs(requiredTotalPower); i++) {
			// Distribuci� equitativa:
			for (int j = 0; j < propellers.length; j++) {
				if (i == Math.abs(requiredTotalPower))
						break;
				else if (
					(requiredTotalPower > 0 && targetPowerArray[j] == propellers[j].getMaxPower()) ||
					(requiredTotalPower < 0 && targetPowerArray[j] == 0)
				) { 
					if (j == propellers.length-1)
						i--;
					continue;
				}
				
				if (requiredTotalPower < 0) // negatiu
					targetPowerArray[j]--; // disminuci�
				else if (requiredTotalPower > 0) // positiu
					targetPowerArray[j]++; // augment
				
				if (j < propellers.length-1)
					i++;
			}
		}
		
		return targetPowerArray;
	}
	
	public void validateTargetPowerArray(int[] targetPowerArray) throws Exception {
		for (int i = 0; i < propellers.length; i++) {
			if (targetPowerArray[i] < 0)
				throw new Exception(identifier + " Propulsor " + i + " La pot�ncia objectiu no pot ser negativa.");
			else if (targetPowerArray[i] > propellers[i].getMaxPower())
				throw new Exception(identifier + " Propulsor " + i + " No es pot superar la seva pot�ncia m�xima.");
		}
	}
	
	public void validateTargetVelocity(int currentTotalPower, int requiredTotalPower, int targetVelocity) throws Exception {
		int maxTotalPower = 0, maxVelocity;
		
		// C�lcul de la pot�ncia total m�xima:
		for (Propeller propeller : propellers)
			maxTotalPower += propeller.getMaxPower();
		
		// C�lcul de la velocitat m�xima:
		maxVelocity = (int) (100*Math.sqrt(maxTotalPower));
		
		if (targetVelocity < 0)
			throw new Exception(identifier + " La velocitat objectiu no pot ser negativa.");
		else if (maxTotalPower-currentTotalPower < Math.abs(requiredTotalPower))
			throw new Exception(identifier + " La velocitat objtectiu no pot ser superior a " + maxVelocity + " m/s.");
	}
	
}
