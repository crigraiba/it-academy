package view;

public class Main {

	public static void main(String[] args) {
		
		// Patr� de disseny Model-Vista-Controlador (MVC)
		// Flux d'execuci�: Main -> UserView -> UserController -> UserService -> User, Video
		
		UserView.menu();
		
		/*
		 * L�gica de l'aplicaci�:
		 * - A UserView es demana a l'usuari que introdueixi totes les dades i se'n fan les validacions pertinents.
		 * - UserController connecta UserView amb UserService.
		 * - A UserService es creen instancies d'User i Video, les quals s'emmagatzemen en llistes. 
		 */
		
	}

}
