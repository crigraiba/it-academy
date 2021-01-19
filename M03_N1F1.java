
import java.util.Scanner;

public class M03_N1F1 {

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
		
		System.out.print(c1+"\n"+c2+"\n"+c3+"\n"+c4+"\n"+c5+"\n"+c6);
	}

}
