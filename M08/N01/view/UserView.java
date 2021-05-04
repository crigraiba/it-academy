package view;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import model.domain.User;
import controller.UserController;

public class UserView {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		User user = addUser();
		
		int choice;
		do {
			System.out.println("Tria una opci�:\n1. Afegir un v�deo\n2. Llistar tots els v�deos\n3. Sortir de l'aplicaci�");
			
			choice = 0;
			do {
				try {
					choice = Integer.parseInt(input());
					if (choice < 1 || choice > 3)
						throw new NumberFormatException();
				} catch (NumberFormatException e) {
					System.err.println("Introdueix una opci� v�lida.");
				}
			} while (choice < 1 || choice > 3);

			System.out.println(); // Separaci�
			
			if (choice == 1) {
				addVideo(user);
			} else if (choice == 2) {
				printVideos(user);
			}
		} while (choice != 3);
		
		sc.close();
		
		System.out.println("Aplicaci� finalitzada.");
	}
	
	private static User addUser() {
		String name, lastName, password;
		
		System.out.print("Nom = ");
		name = input();
		System.out.print("Cognoms = ");
		lastName = input();
		System.out.print("Password = ");
		password = input();
		
		System.out.println(); // Separaci�
		
		return UserController.addUser(name, lastName, password, LocalDate.now());
	}
	
	// Opci� 1 del men�:
	private static void addVideo(User user) {
		String URL, title, tagsString;
		List<String> tagsList;
		
		System.out.print("URL = ");
		URL = input();
		System.out.print("T�tol = ");
		title = input();
		System.out.print("Tags (separats per comes) = ");
		do {
			try {
				tagsString = input();
				tagsList = splitTagsString(tagsString);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				tagsList = null;
			}
		} while (tagsList == null);
		
		UserController.addVideo(user, URL, title, tagsList);
		
		System.out.println(); // Separaci�
	}
	
	// Opci� 2 del men�:
	private static void printVideos(User user) {
		UserController.printVideos(user);
		
		System.out.println(); // Separaci�
	}
	
	private static String input() {
		String input;
		
		do { // Validaci� de l'input:
			input = sc.nextLine();
			try {
				if (input == null || input.isEmpty() || input.isBlank())
					throw new Exception("Aquest camp no pot estar buit.");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (input == null || input.isEmpty() || input.isBlank());
		
		return input;
	}
	
	// Converteix tagsString en tagsArray i, posteriorment, en tagsList
	private static List<String> splitTagsString(String tagsString) throws Exception {
		String[] tagsArray;
		List<String> tagsList = new ArrayList<>();
		
		tagsArray = tagsString.split(",");
		
		// Construcci� de tagsList:
		for (String tag : tagsArray) {
			// tag == null || tag.isEmpty() || tag.isBlank()
			if (tag != null && !tag.isEmpty() && !tag.isBlank()) {
				tag = tag.trim();
				tagsList.add(tag);
			}
		}
		
		// Validaci� de tagsList:
		if (tagsList.size() == 0)
			throw new Exception("El v�deo ha de contenir com a m�nim 1 tag.");
		
		return tagsList;
	}
	
}
