
// Expressions lambda i interf�cies funcionals

public class M10_N01_F03 {
	
	public static void main(String[] args) {
		// Implementaci� de Reverse.reverse():
		Reverse imp = str -> {
			String res = new String();
			
			for (int i = str.length() - 1; i >= 0; i--) {
				res += str.charAt(i);
			}
			
			return res;
		};
		
		// Invocaci� de Reverse.reverse() fent servir aquesta implementaci�:
		System.out.print(imp.reverse("Inrev�s"));
	}
	
}

@FunctionalInterface //Interf�cie funcional:
interface Reverse {
	
	// �nic m�tode abstracte:
	abstract String reverse(String str);
	
}
