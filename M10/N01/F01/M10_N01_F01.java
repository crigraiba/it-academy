import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class M10_N01_F01 {

	// APIs Expressions Lambda i Streams
	
	public static void main(String[] args) {
		first(); // Filtratge: Noms començats per una A i de 3 lletres de longitud
		second(); // Mapatge: Prefix en funció de si els números són parells o imparells
		third(); // Filtratge: Paraules que contenen la lletra O
		fourth(); // Filtratge: Paraules de més de 5 lletres de longitud
		fifth(); // Impressió amb una expressió lambda
		sixth(); // Impressió amb un mètode de referència
	}
	
	private static void first() {
		List<String> list = Arrays.asList("Cristina", "Marta", "Ariadna", "Apu", "Gloria");
		
		List<String> results = list
			.stream() // Stream<String>
			.filter(str -> str.startsWith("A") && str.length() == 3) // Stream<String>
			.collect(Collectors.toList());
		
		System.out.println(results);
	}
	
	private static void second() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		List<String> results = list
			.stream() // Stream<Integer>
			// condition ? consequent : alternative (operador ternari)
			.map(x -> x % 2 == 0 ? 'e' + x.toString() : 'o' + x.toString()) // Stream<String>
			.collect(Collectors.toList());
		
		System.out.println(results);
	}
	
	private static void third() {
		List<String> list = Arrays.asList("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit");
		
		List<String> results = list
			.stream() // Stream<String>
			.filter(str -> str.toLowerCase().contains("o")) // Stream<String>
			.collect(Collectors.toList());
		
		System.out.println(results);
	}
	
	private static void fourth() {
		List<String> list = Arrays.asList("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit");
		
		List<String> results = list
			.stream() // Stream<String>
			.filter(str -> str.length() > 5) // Stream<String>
			.collect(Collectors.toList());
		
		System.out.println(results);
	}
	
	private static void fifth() {
		List<String> list = Arrays.asList("Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre");
		
		list
			.stream() // Stream<String>
			.forEach(str -> System.out.println(str));
	}
	
	private static void sixth() {
		List<String> list = Arrays.asList("Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre");
		
		list
			.stream() // Stream<String>
			.forEach(System.out::println);
	}

}
