import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class M10_N02_F01 {
	
	public static void main(String[] args) {
		String[] strArray = new String[] {"Lorem", "ipsum", "123456", "dolor", "sit", "am1et", "consectetur",
			"adipiscing", "elit", "sed", "do", "123", "e2iusmod", "tempo3r", "incididu4nt", "ut", "lab5ore"};
		
		List<String> strList = Arrays.asList(strArray);
		
		sortByLengthAsc(strList); // Longitud en ordre ascendent
		// sortByLengthDesc(strList); // Longitud en ordre descendent
		// sortByFirstChar(strList); // Ordre alfabètic
		// sortByContent(strList); // Prioritat si conté 'e'
		// mapLetterToDigit(strList); // 'a' -> '4'
		// filterNumeric(strList); // Només cadenes numèriques
	}
	
	private static void sortByLengthAsc(List<String> strList) {
		strList
			.stream() // Stream<String>
			.sorted(Comparator.comparing(String::length)) // Stream<String>
			// <String, Integer> Comparator<String>
			.forEach(System.out::println); // void
	}
	
	private static void sortByLengthDesc(List<String> strList) {
		strList
			.stream() // Stream<String>
			.sorted(Comparator.comparing(String::length).reversed()) // Stream<String>
			// <String, Integer> Comparator<String>, Comparator<String>
			.forEach(System.out::println); // void
	}
	
	private static void sortByFirstChar(List<String> strList) {
		strList
			.stream() // Stream<String>
			.sorted(Comparator.comparing(str -> str.toLowerCase().charAt(0))) // Stream<String>
			// <String, Character> Comparator<String>
			.forEach(System.out::println); // void
	}
	
	private static void sortByContent(List<String> strList) {
		strList
			.stream() // Stream<String>
			.sorted(Comparator.comparing((String str) -> str.toLowerCase().contains("e")).reversed()) // Stream<String>
			// <String, Boolean> Comparator<String>, Comparator<String>
			.forEach(System.out::println); // void
	}
	
	private static void mapLetterToDigit(List<String> strList) {
		strList
			.stream() // Stream<String>
			.map(str -> str.replace("a", "4")) // <String> Stream<String>
			.forEach(System.out::println); // void
	}
	
	private static void filterNumeric(List<String> strList) {
		strList
			.stream() // Stream<String>
			.filter(str -> str.matches("[0-9]+")) // Stream<String>
			.forEach(System.out::println); // void
	}
	
}
