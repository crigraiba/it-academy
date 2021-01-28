
// Excepció pròpia 2: Introducció de plats

public class M04_N3E2 extends Exception {

	private static final long serialVersionUID = 1L;

	public M04_N3E2(int min) {
		super("El nom és massa curt. Ha de contenir com a mínim "+min+" caràcters.");
	}

}
