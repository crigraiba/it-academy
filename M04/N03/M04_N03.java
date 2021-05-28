// Control d'excepcions: Creaci� d'excepcions pr�pies

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class M04_N03 {

	public static void main(String[] args) {
		// Introducci� de plats i preus al men�:
		
		String[] plat = new String[5];
		double[] preu = new double[5];
		Map<String, Double> menu = new HashMap<>();		
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < plat.length; i++) {
			try {
				System.out.print("Plat "+(i+1)+" = ");
				plat[i] = sc.nextLine().toUpperCase();
				if (plat[i].isEmpty() || plat[i].isBlank()) {
					throw new Exception1();
					// Si el nom del plat �s un String buit o format per espais en blanc, es llan�a una excepci�.
				} else if (plat[i].length() < 2) {
					throw new Exception2(2);
					// Si la longitud del nom del plat �s inferior a 2, es llan�a una excepci�.
				}
				System.out.print("Preu "+(i+1)+" = ");
				preu[i] = Double.parseDouble(sc.nextLine()); // preu[i] = sc.nextDouble(); sc.nextLine();
				menu.put(plat[i], preu[i]);
			} catch (Exception1 | Exception2 e) {
				System.err.println(e.getMessage());
				i--;
			} catch (NumberFormatException e) {
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				i--;
			}
		}
		
		// Impressi� del men�:
		
		System.out.println("\nMen�:");
		
		for (Map.Entry<String, Double> parella : menu.entrySet()) {
			System.out.println(parella.getKey()+" "+parella.getValue()+" �");
		}
		
		// Realitzaci� i revisi� de la comanda:
		// C�lcul del preu total:
		
		String nom_plat;
		List<String> comanda = new ArrayList<>();

		double total = 0;
		
		System.out.println("\nComanda:");
		
		int resposta = 1;
		do {
			System.out.println("Introdueix el nom del plat:");
			nom_plat = sc.nextLine().toUpperCase();
			
			try {
				if (!menu.containsKey(nom_plat)) {
					throw new Exception3();
					// Si menu (HashMap) no cont� nom_plat (key), es llan�a una excepci�.
				} else {
					comanda.add(nom_plat);
					total += menu.get(nom_plat);
				}
				
				System.out.println("Continuar demanant?\n1: S�\t2: No");
				do {
					try {
						resposta = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException e) {
						System.err.println(e.getClass().getName()+": "+e.getMessage());
					} finally {
						if (resposta != 1 && resposta != 2) {
							System.out.println("Resposta inv�lida.");
						}
					}
				} while (resposta != 1 && resposta != 2);
				
			} catch (Exception3 e) {
				System.err.println(e.getMessage());
			}
		} while (resposta == 1);
		
		sc.close();
		
		// Impressi� de la comanda:
		// Impressi� del preu total:
		
		System.out.println("\n"+comanda);
		System.out.println("\nTotal = "+total+" �");
		
		// Impressi� de la forma de pagament:
		
		int b5 = 5, b10 = 10, b20 = 20, b50 = 50, b100 = 100, b200 = 200, b500 = 500;
		
		if (total > 0) {
			System.out.println("\nForma de pagament:");
			
			System.out.println("Has de pagar amb els seg�ents bitllets:");	
		}
		
		if (total >= b5) {		
			while (total >= b5) {
				if (total >= b500) {
					System.out.println(b500+" �");
					total -= b500;
					continue;
				} else if (total >= b200) {
					System.out.println(b200+" �");
					total -= b200;
					continue;
				} else if (total >= b100) {
					System.out.println(b100+" �");
					total -= b100;
					continue;
				} else if (total >= b50) {
					System.out.println(b50+" �");
					total -= b50;
					continue;
				} else if (total >= b20) {
					System.out.println(b20+" �");
					total -= b20;
					continue;
				} else if (total >= b10) {
					System.out.println(b10+" �");
					total -= b10;
					continue;
				} else if (total >= b5) {
					System.out.println(b5+" �");
					total -= b5;
				}
			}
		}
		
		if (total > 0) {
			System.out.println(b5+" �");
		}
	}

}
