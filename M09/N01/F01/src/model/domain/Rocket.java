package model.domain;

public class Rocket {
	
	private String identifier;
	private Propeller[] propellers;
	
	// M�tode constructor:
	public Rocket(String identifier, int numPropellers) {
		this.identifier = identifier;
		
		// Donem un tamany a l'Array propellers:
		propellers = new Propeller[numPropellers];
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
		return "Coet " + identifier + " (" + propellers.length + " propulsors)";
	}
	
}
