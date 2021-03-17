import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Creem dues inst�ncies de la classe Rocket:
		Rocket rocket1 = new Rocket("32WESSDS", new int[] {10, 30, 80});
		Rocket rocket2 = new Rocket("LDSFJA32", new int[] {30, 40, 50, 50, 30, 10});
		
		// Mostrem per consola les dades relatives a cadascuna de les inst�ncies:
		System.out.println(rocket1.getIdentifier() + " (" + rocket1.getNumPropellers() + " propulsors): Pot�ncia m�xima/W = " + rocket1.getPropellers());
		System.out.println(rocket2.getIdentifier() + " (" + rocket2.getNumPropellers() + " propulsors): Pot�ncia m�xima/W = " + rocket2.getPropellers());
	
		// Comen�a la carrera de coets!
		/*boolean finished; // FIXME Carreres infinites + m�tode
		int choice;
		
		finished = false;
		do{*/
			race(rocket1, rocket2);
			
			/*choice = 0;
			do { // Validaci� de l'input:
				System.out.println("Tria una opci�:\n1. Crear una nova carrera\n2. Sortir");
				
				try {
					choice = Integer.parseInt(sc.nextLine());
					
					if (choice == 2)
						finished = true;
				} catch (NumberFormatException e) {
					System.err.println("Aquesta opci� no �s v�lida.");
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
		 * [x] Llan�ar una excepci� si targetPower > maxPower o < 0
		 * [ ] Indicar a quin cohet i propulsor pertany cada fil -> i, identifier
		 * [ ] Quin coet guanya ?
		 * [x] L'usuari introdueix les pot�ncies objectiu
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
		do { // Validaci� de l'input:
			try {
				// Es fan 3 comprovacions:
				// La quantitat de valors introdu�ts ha de coincidir amb la quantitat total de propulsors.
				
				System.out.println("Introdueix les pot�ncies objectiu (en W i separades per comes):");
				
				/* 
				 * Es genera l'exemple en funci� del n�mero total de propulsors. �til si vari�ssim la
				 * quantitat de propulsors d'algun dels coets.
				 */
				
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < rocket1.getNumPropellers()+rocket2.getNumPropellers(); i++) {
					sb.append(i+1);
					
					if (i < rocket1.getNumPropellers()+rocket2.getNumPropellers()-1)
						sb.append(","); // Separaci� entre valors
				}
				System.out.println("Per exemple: " + sb.toString());
				
				inputString = sc.nextLine();
				inputArray = inputString.split(",");
				
				if (inputArray.length != rocket1.getNumPropellers()+rocket2.getNumPropellers())
					throw new Exception("Has d'introduir " + (rocket1.getNumPropellers()+rocket2.getNumPropellers()) + " valors.");
			
				// Els valors introdu�ts han de ser n�meros enters.
				
				for (int i = 0; i < rocket1.getNumPropellers()+rocket2.getNumPropellers(); i++) {
					if (i < rocket1.getNumPropellers())
						propellersTargetPower1[i] = Integer.parseInt(inputArray[i]);
					else
						propellersTargetPower2[i-rocket1.getNumPropellers()] = Integer.parseInt(inputArray[i-rocket1.getNumPropellers()]);
				}
			
				// La pot�ncia objectiu no pot ser inferior a 0 o superior a la pot�ncia m�xima del propulsor.
				
				rocket1.changeSpeed(propellersTargetPower1);
				rocket2.changeSpeed(propellersTargetPower2);
			} catch (NumberFormatException e) {
				System.err.println("Has d'introduir n�meros enters.");
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
	
	// Altres m�todes:
	public void changeSpeed(int[] propellersTargetPower) throws Exception {
		for (int i = 0; i < propellers.length; i++) {
			// Es llan�a una excepci� si la pot�ncia objectiu no �s v�lida:
			if (propellersTargetPower[i] < 0)
				throw new Exception("La pot�ncia objectiu no pot ser inferior a 0.");
			else if (propellersTargetPower[i] > propellers[i].getMaxPower())
				throw new Exception("La pot�ncia objectiu no pot ser superior a la pot�ncia m�xima del propulsor.");
			
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
	
	// M�tode constructor:
	public Propeller(int maxPower) {
		this.maxPower = maxPower;
	}
	
	// M�tode getter:
	public int getMaxPower() {
		return maxPower;
	}
	
	public int getCurrentPower() {
		return currentPower;
	}
	
	// Altres m�todes:
	public void decreasePower(int targetPower) {
		Thread t = new Thread() { // Fil an�nim
			@Override
			public void run() {
				while (currentPower > targetPower) {
					System.out.println(getName() + " Pot�ncia/W = " + currentPower);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					currentPower--;
				}
				
				System.out.println(getName() + " Pot�ncia/W = " + currentPower + " Objectiu assolit");
			}
		};
		
		t.start();
	}
	
	public void increasePower(int targetPower) {
		Thread t = new Thread() { // Fil an�nim
			@Override
			public void run() {
				while (currentPower < targetPower) {
					System.out.println(getName() + " Pot�ncia/W = " + currentPower);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					currentPower++;
				}
				
				System.out.println(getName() + " Pot�ncia/W = " + currentPower + " Objectiu assolit");
			}
		};
		
		t.start();
	}
	
}
