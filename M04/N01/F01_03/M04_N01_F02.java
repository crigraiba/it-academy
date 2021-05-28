// Control d'excepcions

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class M04_N01_F02 {

	public static void main(String[] args) {
		int b5 = 5, b10 = 10, b20 = 20, b50 = 50, b100 = 100, b200 = 200, b500 = 500;
		double total;
		
		// Introducció de plats i preus al menú:
		
		String[] plat = new String[5];
		double[] preu = new double[5];
		Map<String, Double> menu = new HashMap<>();		
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < plat.length; i++) {
			try {
				System.out.print("Plat "+(i+1)+" = ");
				plat[i] = sc.nextLine().toUpperCase();
				System.out.print("Preu "+(i+1)+" = ");
				preu[i] = Double.parseDouble(sc.nextLine()); // preu[i] = sc.nextDouble(); sc.nextLine();
				menu.put(plat[i], preu[i]);
			} catch (NumberFormatException e) {
				System.out.println(e.getClass().getName()+": "+e.getMessage());
				i--;
			}
		}
		
		// Impressió del menú:
		
		System.out.println("\nMenú:");
		
		for (Map.Entry<String, Double> parella : menu.entrySet()) {
			System.out.println(parella.getKey()+" "+parella.getValue()+" €");
		}
		
		// Realització de la comanda::
		
		List<String> comanda = new ArrayList<>();
		
		System.out.println("\nComanda:");

		int resposta = 1;
		do {
			System.out.println("Introdueix el nom del plat:");
			comanda.add(sc.nextLine().toUpperCase());

			System.out.println("Continuar demanant?\n1: Sí\t2: No");
			do {
				try {
					resposta = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println(e.getClass().getName()+": "+e.getMessage());
					resposta = 0;
				} finally {
					if (resposta != 1 && resposta != 2) {
						System.out.println("Resposta invàlida.");
					}
				}
			} while (resposta != 1 && resposta != 2);
		} while (resposta == 1);
		
		sc.close();
		
		// Impressió de la comanda:
		
		System.out.println("\n"+comanda);
	}
	
}
