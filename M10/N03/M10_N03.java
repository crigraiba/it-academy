import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class M10_N03 {
	
	public static void main(String[] args) {
		List<Alumne> objList = new ArrayList<>();
		
		objList.add(new Alumne("Ariel", 60, "PHP", 1));
		objList.add(new Alumne("Blancanieves", 55, "PHP", 4));
		objList.add(new Alumne("Cenicienta", 50, "PHP", 7));
		objList.add(new Alumne("Pocahontas", 45, "Java", 2));
		objList.add(new Alumne("Mulan", 40, "Java", 5));
		objList.add(new Alumne("Aurora", 15, "Java", 8));
		objList.add(new Alumne("Bella", 30, "Python", 3));
		objList.add(new Alumne("Jasmín", 25, "Python", 6));
		objList.add(new Alumne("Tiana", 20, "Python", 9));
		objList.add(new Alumne("Rapunzel", 15, "Python", 10));
		
		printNomEdat(objList); // Nom i edat
		// filterNomByFirstChar(objList); // Nom començat per 'a'
		// filterQualified(objList); // Nota >= 5
		// filterQualifiedByCurs(objList); // Nota >= 5 i no cursant PHP
		// filterByCursEdat(objList); // Majors d'edat cursant Java
	}
	
	public static void printNomEdat(List<Alumne> objList) {
		objList
			.stream() // Stream<Alumne>
			.forEach(obj -> System.out.println(obj.getNom() + ", " + obj.getEdat() + " anys")); // void
	}
	
	public static void filterNomByFirstChar(List<Alumne> objList) {
		List<Alumne> objSubList = objList
			.stream() // Stream<Alumne>
			.filter(obj -> obj.getNom().toUpperCase().startsWith("A")) // Stream<Alumne>
			.collect(Collectors.toList()); // <List<Alumne>, Object> List<Alumne>
		
		objSubList
			.stream() // Stream<Alumne>
			.forEach(obj -> System.out.println(obj.getNom())); // void
	}
	
	public static void filterQualified(List<Alumne> objList) {
		objList
			.stream() // Stream<Alumne>
			.filter(obj -> obj.getNota() >= 5) // Stream<Alumne>
			.forEach(obj -> System.out.println(obj.getNom() + ", " + obj.getNota())); // void
	}
	
	public static void filterQualifiedByCurs(List<Alumne> objList) {
		objList
			.stream() // Stream<Alumne>
			.filter(obj -> obj.getNota() >= 5) // Stream<Alumne>
			.filter(obj -> !"PHP".equals(obj.getCurs())) // Stream<Alumne>
			.forEach(obj -> System.out.println(obj.getNom() + ", " + obj.getCurs() + ", " + obj.getNota())); // void
	}
	
	public static void filterByCursEdat(List<Alumne> objList) {
		objList
			.stream() // Stream<Alumne>
			.filter(obj -> "Java".equals(obj.getCurs())) // Stream<Alumne>
			.filter(obj -> obj.getEdat() >= 18) // Stream<Alumne>
			.forEach(obj -> System.out.println(obj.getNom() + ", " + obj.getEdat() + ", " + obj.getCurs())); // void
	}
	
}

class Alumne {
	
	private String nom, curs;
	private int edat;
	private double nota;
	
	public Alumne(String nom, int edat, String curs, double nota) {
		this.nom = nom;
		this.edat = edat;
		this.curs = curs;
		this.nota = nota;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getEdat() {
		return edat;
	}
	
	public String getCurs() {
		return curs;
	}
	
	public double getNota() {
		return nota;
	}
	
}
