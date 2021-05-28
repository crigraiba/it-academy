import java.util.Scanner;

public class M03_N02 {

	public static void main(String[] args) {
		double[][] notesAlumnes = new double[5][3];
		double suma;
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Alumne "+(i+1)+":");
			for (int j = 0; j < 3; j++) {
				do {
					System.out.print("Nota "+(j+1)+" = ");
					notesAlumnes[i][j] = sc.nextDouble();
				} while (notesAlumnes[i][j] < 0 || notesAlumnes[i][j] > 10);
			}
			
			suma = 0;
			for (int j = 0; j < 3; j++) {
				suma += notesAlumnes[i][j];
			}
			if (suma/3 < 5) {
				System.out.println("Suspès\n");
			} else {
				System.out.println("Aprovat\n");
			}
		}
		sc.close();
	}

}
