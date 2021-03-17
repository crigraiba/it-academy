
public class Main {

	public static void main(String[] args) {
		Rocket rocket1 = new Rocket("32WESSDS", 3);
		Rocket rocket2 = new Rocket("LDSFJA32", 6);

		System.out.println(rocket1.getIdentifier() + ": " + rocket1.getNumPropellers() + " propulsors");
		System.out.println(rocket2.getIdentifier() + ": " + rocket2.getNumPropellers() + " propulsors");
	}

}

class Rocket {
	
	private String identifier;
	private Propeller[] propellers;
	
	// Mètode constructor:
	public Rocket(String identifier, int numPropellers) {
		this.identifier = identifier;
		propellers = new Propeller[numPropellers];
	}
	
	// Mètodes getters:
	public String getIdentifier() {
		return identifier;
	}
	
	public int getNumPropellers() {
		return propellers.length;
	}
	
}

class Propeller {
	
	// Mètode constructor:
	public Propeller() {
	}
	
}
