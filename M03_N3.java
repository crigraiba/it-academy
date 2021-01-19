
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
		
		// v1(num);
		v2_SenseRecursivitat(num);
	}
	
	static void v1(int num) {
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
	
	static void v2_SenseRecursivitat(int num) {
		int f1 = 1, f2 = 0, aux;
		for (int i = 0; i < num; i++) {
			if (i == 0) {
				System.out.println(f2);
			} else if (i == 1) {
				System.out.println(f1);
			} else {
				aux = f1;
				f1 += f2;
				f2 = aux;
				System.out.println(f1);
			}
		}
	}
}
