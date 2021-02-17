
package M02; // [Piràmide invertida]

import java.util.Scanner;

public class M02_N2_2 {

	public static void main(String[] args) {
		System.out.print("Introdueix l'alçada: ");
		Scanner input = new Scanner(System.in);
		int height = input.nextInt();
		input.close();
		
		int total = 0;
		for (int step = height*2-1; step >= 1; step -= 2) {
			for (int whitespace = 0; whitespace != total; whitespace++) {
				System.out.print(" ");
			}
			total++;
			
			for (int num = 1; num <= step; num++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

}
