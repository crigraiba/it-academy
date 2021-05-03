package model.domain;

import java.util.List;
import java.util.ArrayList;

public class Rocket {
	
	private String identifier;
	private Propeller[] propellers;
	
	// M�tode constructor:
	public Rocket(String identifier, int[] maxPowerArray) {
		this.identifier = identifier;
		
		// Donem un tamany a l'Array propellers:
		propellers = new Propeller[maxPowerArray.length];
		// L'omplim amb inst�ncies de la classe Propeller:
		for (int i = 0; i < propellers.length; i++)
			propellers[i] = new Propeller(maxPowerArray[i]);
	}
	
	// M�todes getter:
	public String getIdentifier() {
		return identifier;
	}
	
	public Propeller[] getPropellers() {
		return propellers;
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
		
		return "Coet " + identifier + " (" + propellers.length + " propulsors):\n\tPot�ncia actual/W = " + sbCurrentPower.toString() + "\n\tPot�ncia m�xima/W = " + sbMaxPower.toString();
	}

	// Determina si cal disminuir o augmentar la pot�ncia actual de cada propulsor:
	public List<Thread> changeTotalPower(int[] targetPowerArray) throws Exception {
		// Validaci� de la pot�ncia objectiu de cada propulsor:
		this.validateTargetPowerArray(targetPowerArray);
		
		List<Thread> threads = new ArrayList<>();
		
		Thread t = null;
		for (int i = 0; i < propellers.length; i++) {
			if (propellers[i].getCurrentPower() > targetPowerArray[i]) // currentPower > targetPower
				t = propellers[i].changeCurrentPower(identifier, i, targetPowerArray[i], -1); // disminuci�
			else if (propellers[i].getCurrentPower() < targetPowerArray[i]) // currentPower < targetPower
				t = propellers[i].changeCurrentPower(identifier, i, targetPowerArray[i], +1); // augment
			else // currentPower = targetPower
				System.out.println("\t\t" + identifier + " Propulsor " + i + " No requereix modificaci�.");
			
			threads.add(t);
		}
		
		return threads;
	}
	
	public int[] getTargetPowerArray(int targetVelocity) throws Exception {
		int currentTotalPower = 0, targetTotalPower = 0, requiredTotalPower;
		int[] targetPowerArray = new int[propellers.length];
		int currentVelocity;
		
		// C�lcul de la pot�ncia total inicial:
		for (Propeller propeller : propellers)
			currentTotalPower += propeller.getCurrentPower();
		
		// C�lcul de la velocitat inicial:
		currentVelocity = (int) (100*Math.sqrt(currentTotalPower));
		
		// C�lcul de la pot�ncia total final:
		requiredTotalPower = (int) Math.pow(targetVelocity/100, 2)-currentTotalPower;
		targetTotalPower = currentTotalPower + requiredTotalPower;
		
		// Validaci� de la velocitat objectiu:
		this.validateTargetVelocity(currentTotalPower, requiredTotalPower, targetVelocity);
		
		// Impressi� de la velocitat objectiu i els resultats dels c�lculs:
		System.out.println(
			"Coet " + identifier + " Dades:"
			+ "\n\tPot�ncia total inicial/W = " + currentTotalPower
			+ "\n\tPot�ncia total final/W = " + targetTotalPower
			+ "\n\tVelocitat inicial/(m/s) = " + currentVelocity
			+ "\n\tVelocitat final/(m/s) = " + targetVelocity
		);
		
		// System.out.println("requiredTotalPower = " + requiredTotalPower); // TODO
		
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
					 
					// System.out.println("continue"); // TODO
					continue;
				}
				
				if (requiredTotalPower < 0) // negatiu
					targetPowerArray[j]--; // disminuci�
				else if (requiredTotalPower > 0) // positiu
					targetPowerArray[j]++; // augment
				
				// System.out.println("Propulsor " + j + " -> " + targetPowerArray[j]); // TODO
				// System.out.println("i = " + i); // TODO
				
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
