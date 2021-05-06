// Carrera de coets

package view;

public class Main {

	public static void main(String[] args) {
		// Creem dues instàncies de la classe Rocket:
		Rocket rocket1 = new Rocket("32WESSDS", 3);
		Rocket rocket2 = new Rocket("LDSFJA32", 6);
		
		System.out.println(rocket1.toString());
		System.out.println(rocket2.toString());
	}

}
