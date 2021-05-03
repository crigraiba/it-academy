package model.domain;

import java.util.List;
import java.util.ArrayList;

public class Rocket {
	
	private String identifier;
	private Propeller[] propellers;
	
	// Mètode constructor:
	public Rocket(String identifier, int[] maxPowerArray) {
		this.identifier = identifier;
		
		// Donem un tamany a l'Array propellers:
		propellers = new Propeller[maxPowerArray.length];
		// L'omplim amb instàncies de la classe Propeller:
		for (int i = 0; i < propellers.length; i++)
			propellers[i] = new Propeller(maxPowerArray[i]);
	}
	
	// Mètodes getter:
	public String getIdentifier() {
		return identifier;
	}
	
	public Propeller[] getPropellers() {
		return propellers;
	}
	
	// Altres mètodes:
	@Override
	public String toString() {
		StringBuilder sbCurrentPower = new StringBuilder();
		StringBuilder sbMaxPower = new StringBuilder();
		
		for (Propeller propeller : propellers) {
			sbCurrentPower.append(propeller.getCurrentPower());
			sbMaxPower.append(propeller.getMaxPower());
			
			// Separació entre valors:
			if(!propeller.equals(propellers[propellers.length-1])) {
				sbCurrentPower.append(", ");
				sbMaxPower.append(", ");
			}
		}
		
		return "Coet " + identifier + " (" + propellers.length + " propulsors):\n\tPotència actual/W = " + sbCurrentPower.toString() + "\n\tPotència màxima/W = " + sbMaxPower.toString();
	}

	// Determina si cal disminuir o augmentar la potència actual de cada propulsor:
	public List<Thread> changeTotalPower(int[] targetPowerArray) throws Exception {
		// Validació de la potència objectiu de cada propulsor:
		this.validateTargetPowerArray(targetPowerArray);
		
		List<Thread> threads = new ArrayList<>();
		
		Thread t = null;
		for (int i = 0; i < propellers.length; i++) {
			if (propellers[i].getCurrentPower() > targetPowerArray[i]) // currentPower > targetPower
				t = propellers[i].changeCurrentPower(identifier, i, targetPowerArray[i], -1); // disminució
			else if (propellers[i].getCurrentPower() < targetPowerArray[i]) // currentPower < targetPower
				t = propellers[i].changeCurrentPower(identifier, i, targetPowerArray[i], +1); // augment
			else // currentPower = targetPower
				System.out.println("\t\t" + identifier + " Propulsor " + i + " No requereix modificació.");
			
			threads.add(t);
		}
		
		return threads;
	}
	
	public int[] getTargetPowerArray(int targetVelocity) throws Exception {
		int currentTotalPower = 0, targetTotalPower = 0, requiredTotalPower;
		int[] targetPowerArray = new int[propellers.length];
		int currentVelocity;
		
		// Càlcul de la potència total inicial:
		for (Propeller propeller : propellers)
			currentTotalPower += propeller.getCurrentPower();
		
		// Càlcul de la velocitat inicial:
		currentVelocity = (int) (100*Math.sqrt(currentTotalPower));
		
		// Càlcul de la potència total final:
		requiredTotalPower = (int) Math.pow(targetVelocity/100, 2)-currentTotalPower;
		targetTotalPower = currentTotalPower + requiredTotalPower;
		
		// Validació de la velocitat objectiu:
		this.validateTargetVelocity(currentTotalPower, requiredTotalPower, targetVelocity);
		
		// Impressió de la velocitat objectiu i els resultats dels càlculs:
		System.out.println(
			"Coet " + identifier + " Dades:"
			+ "\n\tPotència total inicial/W = " + currentTotalPower
			+ "\n\tPotència total final/W = " + targetTotalPower
			+ "\n\tVelocitat inicial/(m/s) = " + currentVelocity
			+ "\n\tVelocitat final/(m/s) = " + targetVelocity
		);
		
		// System.out.println("requiredTotalPower = " + requiredTotalPower); // TODO
		
		// Càlcul de la potència final de cada propulsor:
		for (int i = 0; i < propellers.length; i++)
			targetPowerArray[i] = propellers[i].getCurrentPower();
		
		for (int i = 0; i < Math.abs(requiredTotalPower); i++) {
			// Distribució equitativa:
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
					targetPowerArray[j]--; // disminució
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
				throw new Exception(identifier + " Propulsor " + i + " La potència objectiu no pot ser negativa.");
			else if (targetPowerArray[i] > propellers[i].getMaxPower())
				throw new Exception(identifier + " Propulsor " + i + " No es pot superar la seva potència màxima.");
		}
	}
	
	public void validateTargetVelocity(int currentTotalPower, int requiredTotalPower, int targetVelocity) throws Exception {
		int maxTotalPower = 0, maxVelocity;
		
		// Càlcul de la potència total màxima:
		for (Propeller propeller : propellers)
			maxTotalPower += propeller.getMaxPower();
		
		// Càlcul de la velocitat màxima:
		maxVelocity = (int) (100*Math.sqrt(maxTotalPower));
		
		if (targetVelocity < 0)
			throw new Exception(identifier + " La velocitat objectiu no pot ser negativa.");
		else if (maxTotalPower-currentTotalPower < Math.abs(requiredTotalPower))
			throw new Exception(identifier + " La velocitat objtectiu no pot ser superior a " + maxVelocity + " m/s.");
	}
	
}
