// Excepci� pr�pia 2: Introducci� de plats

public class Exception2 extends Exception {

	private static final long serialVersionUID = 1L;

	public Exception2(int min) {
		super("El nom �s massa curt. Ha de contenir com a m�nim "+min+" car�cters.");
	}

}
