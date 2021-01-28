
// Excepció pròpia 1: Revisió de tipus

public class M04_N3E1 extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public M04_N3E1() {
		super("El nom no pot estar buit o estar format per espais en blanc.");
	}

}
