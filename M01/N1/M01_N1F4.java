package M01.N1;

public class M01_N1F4 {

	public static void main(String[] args) {		
		String nom = "Cristina", cognom1 = "Grau", cognom2 = "Ib��ez";
		int dia = 18, mes = 8, any = 1994;
		
		String nom_complet = nom+" "+cognom1+" "+cognom2;
		String data_de_naixement = dia+"/"+mes+"/"+any;
		
 		System.out.println("El meu nom �s "+nom_complet+".");
		System.out.println("Vaig n�ixer el "+data_de_naixement+".");
				
		boolean leapyear;		
		if (any % 100 != 0 && any % 4 == 0 || any % 100 == 0 && any % 400 == 0) {
			leapyear = true;
		} else {
			leapyear = false;
		}
		
		if (leapyear == true) {
			String cert = "El meu any de naixement �s de trasp�s.";
			System.out.print(cert);
		} else {
			String fals = "El meu any de naixement no �s de trasp�s.";
			System.out.print(fals);
		}
		
	}

}
