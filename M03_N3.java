
// SEQ‹»NCIA DE FIBONACCI
// Concepte de recursivitat

import java.util.Scanner;

public class M03_N3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.print("N = ");
			num = sc.nextInt();
		} while (num < 0);
		sc.close();
		
		for (int i = 0; i < num; i++) {
			System.out.println(Fibonacci(i));
		}
	}
	
	static int Fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			return Fibonacci(n-1) + Fibonacci(n-2);
		}
	}
}
