
// Expressions lambda i interf�cies funcionals

public class M10_N01_F02 {
	
	public static void main(String[] args) {
		// Implementaci� de Pi.getPiValue():
		Pi imp = () -> 3.1415;
		
		// Invocaci� de Pi.getPiValue() fent servir aquesta implementaci�:
		System.out.print(imp.getPiValue());
	}
	
}

@FunctionalInterface //Interf�cie funcional:
interface Pi {
	
	// �nic m�tode abstracte:
	abstract double getPiValue();
	
}
