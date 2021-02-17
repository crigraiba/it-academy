package M01.N1;

public class M01_N1F3 {

	public static void main(String[] args) {
		
		for (int i = 1948; i <= 1994; i += 4) {
			System.out.println(i);
		}
		
/* Any de traspàs = múltiple de 4.
   Excepció: Si és múltiple de 100, també ho ha de ser de 400.
   Condició:
   - és múltiple de 4 i no ho és de 100.
   - és múltiple de 100 i de 400.
 */
		
		int birthyear = 1994;		
		boolean leapyear;		
		if (birthyear % 100 != 0 && birthyear % 4 == 0 || birthyear % 100 == 0 && birthyear % 400 == 0) {
			leapyear = true;
		} else {
			leapyear = false;
		}
		
		if (leapyear == true) {
			String cert = "El meu any de naixement és de traspàs.";
			System.out.print(cert);
		} else {
			String fals = "El meu any de naixement no és de traspàs.";
			System.out.print(fals);
		}
		
	}

}
