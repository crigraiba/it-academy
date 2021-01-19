
// arrayCiutats

import java.util.Scanner;
import java.util.Arrays;

public class M03_N1F2 {

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
	}

}
