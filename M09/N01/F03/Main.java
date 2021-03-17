import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Creem dues instàncies de la classe Rocket:
		Rocket rocket1 = new Rocket("32WESSDS", new int[] {10, 30, 80});
		Rocket rocket2 = new Rocket("LDSFJA32", new int[] {30, 40, 50, 50, 30, 10});
		
		// Mostrem per consola les dades relatives a cadascuna de les instàncies:
		System.out.println(rocket1.getIdentifier() + " (" + rocket1.getNumPropellers() + " propulsors): Potència màxima/W = " + rocket1.getPropellers());
		System.out.println(rocket2.getIdentifier() + " (" + rocket2.getNumPropellers() + " propulsors): Potència màxima/W = " + rocket2.getPropellers());
	
		// Comença la carrera de coets!
		/*boolean finished; // FIXME Carreres infinites + mètode
		int choice;
		
		finished = false;
		do{*/
			race(rocket1, rocket2);
			
			/*choice = 0;
			do { // Validació de l'input:
				System.out.println("Tria una opció:\n1. Crear una nova carrera\n2. Sortir");
				
				try {
					choice = Integer.parseInt(sc.nextLine());
					
					if (choice == 2)
						finished = true;
				} catch (NumberFormatException e) {
					System.err.println("Aquesta opció no és vàlida.");
				}
			} while (choice != 1 & choice != 2);
		} while (finished == false);*/
		
		sc.close();
		
		/*
		 * TODO
		 * [x] 1 propeller = 1 thread, en total n'han d'haver 9
		 * Thread thread = new Thread();
		 * thread.start();
		 * 
		 * [x] Llançar una excepció si targetPower > maxPower o < 0
		 * [ ] Indicar a quin cohet i propulsor pertany cada fil -> i, identifier
		 * [ ] Quin coet guanya ?
		 * [x] L'usuari introdueix les potències objectiu
		 * [ ] Bucle infinit carreres
		 */

		/*
		 * TODO
		 * propellersTargetPower = new int[] {x, y, z}
		 * if x < currentPower -> decreasePower
		 * if x > currentPower -> increasePower
		 */
	}
	
	public static void race(Rocket rocket1, Rocket rocket2) {
		String inputString;
		String[] inputArray;
		int[] propellersTargetPower1, propellersTargetPower2;
		
		propellersTargetPower1 = new int[rocket1.getNumPropellers()];
		propellersTargetPower2 = new int[rocket2.getNumPropellers()];
		
		boolean invalidInput = false;
		do { // Validació de l'input:
			try {
				// Es fan 3 comprovacions:
				// La quantitat de valors introduïts ha de coincidir amb la quantitat total de propulsors.
				
				System.out.println("Introdueix les potències objectiu (en W i separades per comes):");
				
				/* 
				 * Es genera l'exemple en funció del número total de propulsors. Útil si variéssim la
				 * quantitat de propulsors d'algun dels coets.
				 */
				
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < rocket1.getNumPropellers()+rocket2.getNumPropellers(); i++) {
					sb.append(i+1);
					
					if (i < rocket1.getNumPropellers()+rocket2.getNumPropellers()-1)
						sb.append(","); // Separació entre valors
				}
				System.out.println("Per exemple: " + sb.toString());
				
				inputString = sc.nextLine();
				inputArray = inputString.split(",");
				
				if (inputArray.length != rocket1.getNumPropellers()+rocket2.getNumPropellers())
					throw new Exception("Has d'introduir " + (rocket1.getNumPropellers()+rocket2.getNumPropellers()) + " valors.");
			
				// Els valors introduïts han de ser números enters.
				
				for (int i = 0; i < rocket1.getNumPropellers()+rocket2.getNumPropellers(); i++) {
					if (i < rocket1.getNumPropellers())
						propellersTargetPower1[i] = Integer.parseInt(inputArray[i]);
					else
						propellersTargetPower2[i-rocket1.getNumPropellers()] = Integer.parseInt(inputArray[i-rocket1.getNumPropellers()]);
				}
			
				// La potència objectiu no pot ser inferior a 0 o superior a la potència màxima del propulsor.
				
				rocket1.changeSpeed(propellersTargetPower1);
				rocket2.changeSpeed(propellersTargetPower2);
			} catch (NumberFormatException e) {
				System.err.println("Has d'introduir números enters.");
				invalidInput = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				invalidInput = true;
			}
		} while (invalidInput == true);
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
	public void changeSpeed(int[] propellersTargetPower) throws Exception {
		for (int i = 0; i < propellers.length; i++) {
			// Es llança una excepció si la potència objectiu no és vàlida:
			if (propellersTargetPower[i] < 0)
				throw new Exception("La potència objectiu no pot ser inferior a 0.");
			else if (propellersTargetPower[i] > propellers[i].getMaxPower())
				throw new Exception("La potència objectiu no pot ser superior a la potència màxima del propulsor.");
			
			if (propellers[i].getCurrentPower() < propellersTargetPower[i])
				propellers[i].increasePower(propellersTargetPower[i]); // speedUp
			else if (propellers[i].getCurrentPower() > propellersTargetPower[i])
				propellers[i].decreasePower(propellersTargetPower[i]); // speedDown
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
		Thread t = new Thread() { // Fil anònim
			@Override
			public void run() {
				while (currentPower > targetPower) {
					System.out.println(getName() + " Potència/W = " + currentPower);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					currentPower--;
				}
				
				System.out.println(getName() + " Potència/W = " + currentPower + " Objectiu assolit");
			}
		};
		
		t.start();
	}
	
	public void increasePower(int targetPower) {
		Thread t = new Thread() { // Fil anònim
			@Override
			public void run() {
				while (currentPower < targetPower) {
					System.out.println(getName() + " Potència/W = " + currentPower);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					currentPower++;
				}
				
				System.out.println(getName() + " Potència/W = " + currentPower + " Objectiu assolit");
			}
		};
		
		t.start();
	}
	
}
