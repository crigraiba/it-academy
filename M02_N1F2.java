
// Llista (List<Character>) i diferenciació entre vocals, consonants i números

import java.util.List;
import java.util.ArrayList;

public class M02_N1F2 {

	public static void main(String[] args) {
		char[] charArray = { 'C', 'R', 'I', 'S', 'T', 'I', 'N', 'A' };
		List<Character> charArrayList = new ArrayList<>();
		
		for (char element : charArray) {
			charArrayList.add(element);
			switch (element) {
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
					System.out.println(element+" VOCAL");
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					System.out.println("Els noms de persones no contenen números!");
					break;
				default:
					System.out.println(element+" CONSONANT");
			}
		}
	}

}
