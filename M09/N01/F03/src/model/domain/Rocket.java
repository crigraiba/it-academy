package model.domain;

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
		StringBuilder sb = new StringBuilder();
		
		for (Propeller propeller : propellers) {
			sb.append(propeller.getMaxPower());
			
			// Separació entre valors:
			if(!propeller.equals(propellers[propellers.length-1]))
				sb.append(", ");
		}
		
		return "Coet " + identifier + " (" + propellers.length + " propulsors): Potència màxima/W = " + sb.toString();
	}

	// Determina si cal disminuir o augmentar la potència actual de cada propulsor:
	public void changeTotalPower(int[] targetPowerArray) {
		for (int i = 0; i < propellers.length; i++) {
			if (propellers[i].getCurrentPower() > targetPowerArray[i]) // currentPower > targetPower
				propellers[i].changeCurrentPower(identifier, i, targetPowerArray[i], -1); // disminució
			else if (propellers[i].getCurrentPower() < targetPowerArray[i]) // currentPower < targetPower
				propellers[i].changeCurrentPower(identifier, i, targetPowerArray[i], +1); // augment
			else // currentPower = targetPower
				System.out.println("\t" + identifier + " Propulsor " + i + " No requereix modificació.");
		}
	}
	
}
