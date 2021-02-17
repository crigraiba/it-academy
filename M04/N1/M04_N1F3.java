
package M04.N1; // Control d'excepcions

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class M04_N1F3 {

	public static void main(String[] args) {
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
		
		// Realització de la comanda:
		
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
		
		// Revisió de la comanda:
		// Càlcul del preu total:
		
		double total = 0;
		
		for (String i : comanda) {
			if (menu.containsKey(i)) {
				total += menu.get(i);
			} else {
				System.out.println("El plat '"+i+"' no existeix.");
			}
		}
		
		System.out.println("\nTotal = "+total+" €");
		
		// Impressió de la forma de pagament:

		int b5 = 5, b10 = 10, b20 = 20, b50 = 50, b100 = 100, b200 = 200, b500 = 500;
		
		if (total > 0) {
			System.out.println("\nForma de pagament:");
			
			System.out.println("Has de pagar amb els següents bitllets:");	
		}
		
		if (total >= b5) {	
			while (total >= b5) {
				if (total >= b500) {
					System.out.println(b500+" €");
					total -= b500;
					continue;
				} else if (total >= b200) {
					System.out.println(b200+" €");
					total -= b200;
					continue;
				} else if (total >= b100) {
					System.out.println(b100+" €");
					total -= b100;
					continue;
				} else if (total >= b50) {
					System.out.println(b50+" €");
					total -= b50;
					continue;
				} else if (total >= b20) {
					System.out.println(b20+" €");
					total -= b20;
					continue;
				} else if (total >= b10) {
					System.out.println(b10+" €");
					total -= b10;
					continue;
				} else if (total >= b5) {
					System.out.println(b5+" €");
					total -= b5;
				}
			}
		}
		
		if (total > 0) {
			System.out.println(b5+" €");
		}
	}

}
