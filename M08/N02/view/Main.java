package view;

public class Main {

	public static void main(String[] args) {
		
		// Patró de disseny Model-Vista-Controlador (MVC)
		// Flux d'execució: Main -> UserView -> UserController -> UserService -> User, Video
		
		UserView.menu();
		
		/*
		 * Lògica de l'aplicació:
		 * - A UserView es demana a l'usuari que introdueixi totes les dades i se'n fan les validacions pertinents.
		 * - UserController connecta UserView amb UserService.
		 * - A UserService es creen instancies d'User i Video, les quals s'emmagatzemen en llistes. 
		 */
		
	}

}
