
public class Main {

	public static void main(String[] args) {
		// Creem dues instàncies de la classe Rocket:
		Rocket rocket1 = new Rocket("32WESSDS", new int[] {10, 30, 80});
		Rocket rocket2 = new Rocket("LDSFJA32", new int[] {30, 40, 50, 50, 30, 10});
		
		// Mostrem per consola les dades relatives a cadascuna de les instàncies:
		System.out.println(rocket1.getIdentifier() + " (" + rocket1.getNumPropellers() + " propulsors): Potència màxima/W = " + rocket1.getPropellers());
		System.out.println(rocket2.getIdentifier() + " (" + rocket2.getNumPropellers() + " propulsors): Potència màxima/W = " + rocket2.getPropellers());
	
		// Indiquem quina és la potència objectiu de cada propulsor:
		rocket1.changeSpeed(new int[] {0, 20, 90});
		rocket2.changeSpeed(new int[] {10, -10, 50, 40, 30, 5});
		
		/*
		 * TODO
		 * [x] 1 propeller = 1 thread, en total n'han d'haver 9
		 * Thread thread = new Thread();
		 * thread.start();
		 * 
		 * [x] Llançar una excepció si targetPower > maxPower o < 0
		 * [ ] Indicar a quin cohet i propulsor pertany cada fil
		 */

		/*
		 * TODO
		 * propellersTargetPower = new int[] {x, y, z}
		 * if x < currentPower -> decreasePower
		 * if x > currentPower -> increasePower
		 */
		
		// Comença la carrera de coets!
	}

}

class Rocket {
	
	private String identifier;
	private Propeller[] propellers;
	
	// Mètode constructor:
	public Rocket(String identifier, int[] propellersMaxPower) {
		this.identifier = identifier;
		// Donem un tamany a l'Array propellers:
		propellers = new Propeller[propellersMaxPower.length];
		// Omplim l'Array propellers amb instàncies de la classe Propeller:
		for (int i = 0; i < propellers.length; i++)
			propellers[i] = new Propeller(propellersMaxPower[i]);
	}
	
	// Mètodes getters:
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
				sb.append(", "); // Separació entre valors
		}
		
		return sb.toString();
	}
	
	// Altres mètodes:
	public void changeSpeed(int[] propellersTargetPower) {
		for (int i = 0; i < propellers.length; i++) {
			try {
				// Es llança una excepció si la potència objectiu no és vàlida:
				if (propellersTargetPower[i] < 0)
					throw new Exception("La potència objectiu no pot ser inferior a 0.");
				else if (propellersTargetPower[i] > propellers[i].getMaxPower())
					throw new Exception("La potència objectiu no pot ser superior a la potència màxima del propulsor.");
				
				if (propellers[i].getCurrentPower() < propellersTargetPower[i])
					propellers[i].increasePower(propellersTargetPower[i]); // speedUp
				else if (propellers[i].getCurrentPower() > propellersTargetPower[i])
					propellers[i].decreasePower(propellersTargetPower[i]); // speedDown
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
}

class Propeller {
	
	private int maxPower;
	private int currentPower = 0;
	
	// Mètode constructor:
	public Propeller(int maxPower) {
		this.maxPower = maxPower;
	}
	
	// Mètode getter:
	public int getMaxPower() {
		return maxPower;
	}
	
	public int getCurrentPower() {
		return currentPower;
	}
	
	// Altres mètodes:
	public void decreasePower(int targetPower) {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (currentPower > targetPower) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					currentPower--;
					System.out.println(getName() + " Potència/W = " + currentPower);
				}
			}
		};
		
		t.start();
	}
	
	public void increasePower(int targetPower) {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (currentPower < targetPower) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					currentPower++;
					System.out.println(getName() + " Potència/W = " + currentPower);
				}
				
				System.out.println("El " + getName() + " ha acabat.");
			}
		};
		
		t.start();
	}
	
}
