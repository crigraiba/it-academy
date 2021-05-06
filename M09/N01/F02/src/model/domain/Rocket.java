package model.domain;

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
		StringBuilder sb = new StringBuilder();
		
		for (Propeller propeller : propellers) {
			sb.append(propeller.getMaxPower());
			
			// Separaci� entre valors:
			if(!propeller.equals(propellers[propellers.length-1]))
				sb.append(", ");
		}
		
		return "Coet " + identifier + " (" + propellers.length + " propulsors): Pot�ncia m�xima/W = " + sb.toString();
	}
	
}
