package M01;

// Type Casting: double -> int, float, String

public class M01_N2 {

	public static void main(String[] args) {
		double numDouble = 0.1234;
		
		int numInt;
		float numFloat;
		String numString;
		
		numInt = (int)numDouble;
		numFloat = (float)numDouble;
		numString=Double.toString(numDouble);
		
		System.out.println(numInt);
		System.out.println(numFloat);
		System.out.println(numString);
	}

}
