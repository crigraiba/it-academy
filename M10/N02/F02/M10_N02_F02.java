
public class M10_N02_F02 {

	public static void main(String[] args) {
		
		// Implementacions de Calculator.operation(float x, float y):
		Calculator addition = (x, y) -> x+y;
		Calculator subtraction = (x, y) -> x-y;
		Calculator multiplication = (x, y) -> x*y;
		Calculator division = (x, y) -> x/y;

		// Invocació de Calculator.operation(float x, float y) fent servir cadascuna d'aquestes implementacions:
		System.out.println("x = 15, y = 5");
		System.out.println("x+y = " + addition.operation(15, 5));
		System.out.println("x-y = " + subtraction.operation(15, 5));
		System.out.println("x*y = " + multiplication.operation(15, 5));
		System.out.println("x/y = " + division.operation(15, 5));
	}

}

@FunctionalInterface // Interfície funcional:
interface Calculator {
	
	// Únic mètode abstracte:
	float operation(float x, float y);
	
}