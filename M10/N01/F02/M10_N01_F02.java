
// Expressions lambda i interfícies funcionals

public class M10_N01_F02 {
	
	public static void main(String[] args) {
		// Implementació de Pi.getPiValue():
		Pi imp = () -> 3.1415;
		
		// Invocació de Pi.getPiValue() fent servir aquesta implementació:
		System.out.print(imp.getPiValue());
	}
	
}

@FunctionalInterface //Interfície funcional:
interface Pi {
	
	// Únic mètode abstracte:
	abstract double getPiValue();
	
}
