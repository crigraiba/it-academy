// Barcelona -> anolecraB

import java.util.Scanner;
import java.util.Arrays;

public class M03_N01_F04 {

	public static void main(String[] args) {
		String c1, c2, c3, c4, c5, c6;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix el nom de 6 ciutats:");
		System.out.print("1 = ");
		c1 = sc.nextLine();
		System.out.print("2 = ");
		c2 = sc.nextLine();
		System.out.print("3 = ");
		c3 = sc.nextLine();
		System.out.print("4 = ");
		c4 = sc.nextLine();
		System.out.print("5 = ");
		c5 = sc.nextLine();
		System.out.print("6 = ");
		c6 = sc.nextLine();
		sc.close();
				
		String[] arrayCiutats = {c1, c2, c3, c4, c5, c6};
		
		Arrays.sort(arrayCiutats);
		
		System.out.println("\nOrdre alfabètic:");
		for (String ciutat : arrayCiutats) {
			System.out.println(ciutat);
		}
		
		String[] arrayCiutatsModificades = new String[arrayCiutats.length];
		
		System.out.println("\nSubstitució de 'a' per '4':");
		for (int i = 0; i < arrayCiutats.length; i++) {
			arrayCiutatsModificades[i] = arrayCiutats[i].replace('a', '4');
			System.out.println(arrayCiutatsModificades[i]);
		}
		
		char[] c1Array = new char[arrayCiutats[0].length()];
		char[] c2Array = new char[arrayCiutats[1].length()];
		char[] c3Array = new char[arrayCiutats[2].length()];
		char[] c4Array = new char[arrayCiutats[3].length()];
		char[] c5Array = new char[arrayCiutats[4].length()];
		char[] c6Array = new char[arrayCiutats[5].length()];
		
		for (int i = 0; i < arrayCiutats.length; i++) {
			for (int j = 0; j < arrayCiutats[i].length(); j++) {
				switch (i) {
					case 0:
						c1Array[j] = arrayCiutats[i].charAt(arrayCiutats[i].length()-1-j);
						break;
					case 1:
						c2Array[j] = arrayCiutats[i].charAt(arrayCiutats[i].length()-1-j);
						break;
					case 2:
						c3Array[j] = arrayCiutats[i].charAt(arrayCiutats[i].length()-1-j);
						break;
					case 3:
						c4Array[j] = arrayCiutats[i].charAt(arrayCiutats[i].length()-1-j);
						break;
					case 4:
						c5Array[j] = arrayCiutats[i].charAt(arrayCiutats[i].length()-1-j);
						break;
					case 5:
						c6Array[j] = arrayCiutats[i].charAt(arrayCiutats[i].length()-1-j);
				}
				
			}
		}
		
		System.out.println("\nInversió:");
		for (int i = 0; i < arrayCiutats.length; i++) {
			for (int j = 0; j < arrayCiutats[i].length(); j++) {
				switch (i) {
					case 0:
						System.out.print(c1Array[j]);
						break;
					case 1:
						System.out.print(c2Array[j]);
						break;
					case 2:
						System.out.print(c3Array[j]);
						break;
					case 3:
						System.out.print(c4Array[j]);
						break;
					case 4:
						System.out.print(c5Array[j]);
						break;
					case 5:
						System.out.print(c6Array[j]);
				}
			}
			System.out.println();
		}
	}

}
