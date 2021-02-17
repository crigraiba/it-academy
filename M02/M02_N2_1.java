
package M02; // [Escala de números]

import java.util.Scanner;

public class M02_N2_1 {

	public static void main(String[] args) {
		System.out.print("Introdueix l'alçada: ");
		Scanner input = new Scanner(System.in);
		int height = input.nextInt();
		input.close();
		
		for (int step = 1; step <= height; step++) {
			for (int num = 1; num <= step; num++) {
				System.out.print(num);
			}
			System.out.print("\n");
		} // num < step	System.out.println(step);
	}

}
