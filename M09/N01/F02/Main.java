
public class Main {

	public static void main(String[] args) {
		// Creem dues inst�ncies de la classe Rocket:
		Rocket rocket1 = new Rocket("32WESSDS", new int[] {10, 30, 80});
		Rocket rocket2 = new Rocket("LDSFJA32", new int[] {30, 40, 50, 50, 30, 10});
		
		// Mostrem per consola les dades relatives a cadascuna de les inst�ncies:
		System.out.println(rocket1.getIdentifier() + " (" + rocket1.getNumPropellers() + " propulsors): Pot�ncia m�xima/W = " + rocket1.getPropellers());
		System.out.println(rocket2.getIdentifier() + " (" + rocket2.getNumPropellers() + " propulsors): Pot�ncia m�xima/W = " + rocket2.getPropellers());
	}

}

class Rocket {
	
	private String identifier;
	private Propeller[] propellers;
	
	// M�tode constructor:
	public Rocket(String identifier, int[] propellersMaxPower) {
		this.identifier = identifier;
		// Donem un tamany a l'Array propellers:
		propellers = new Propeller[propellersMaxPower.length];
		// Omplim l'Array propellers amb inst�ncies de la classe Propeller:
		for (int i = 0; i < propellers.length; i++)
			propellers[i] = new Propeller(propellersMaxPower[i]);
	}
	
	// M�todes getters:
	public String getIdentifier() {
		return identifier;
	}
	
	public int getNumPropellers() {
		return propellers.length;
	}
	
	public String getPropellers() {
		StringBuilder sb = new StringBuilder();
		
		for (Propeller propeller : propellers) {
			sb.append(propeller.getMaxPower());
			
			if (!propeller.equals(propellers[propellers.length-1]))
				sb.append(", "); // Separaci� entre valors
		}
		
		return sb.toString();
	}
	
}

class Propeller {
	
	private int maxPower;
	
	// M�tode constructor:
	public Propeller(int maxPower) {
		this.maxPower = maxPower;
	}
	
	// M�tode getter:
	public int getMaxPower() {
		return maxPower;
	}
	
}
