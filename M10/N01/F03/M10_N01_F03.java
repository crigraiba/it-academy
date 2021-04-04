
// Expressions lambda i interfícies funcionals

public class M10_N01_F03 {
	
	public static void main(String[] args) {
		// Implementació de Reverse.reverse():
		Reverse imp = str -> {
			String res = new String();
			
			for (int i = str.length() - 1; i >= 0; i--) {
				res += str.charAt(i);
			}
			
			return res;
		};
		
		// Invocació de Reverse.reverse() fent servir aquesta implementació:
		System.out.print(imp.reverse("Inrevés"));
	}
	
}

@FunctionalInterface //Interfície funcional:
interface Reverse {
	
	// Únic mètode abstracte:
	abstract String reverse(String str);
	
}
