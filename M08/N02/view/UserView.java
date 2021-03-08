package view;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import model.domain.User;
import controller.UserController;

public class UserView {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		User user = addUser();
		
		boolean finished;
		int choice;
		
		finished = false;
		do {
			System.out.println("Tria una opció:\n1. Afegir un vídeo\n2. Llistar tots els vídeos\n3. Sortir");
			
			choice = 0;
			do {
				try {
					choice = Integer.parseInt(input());
					if (choice < 1 || choice > 3)
						throw new NumberFormatException();
				} catch (NumberFormatException e) {
					System.err.println("Introdueix una opció vàlida.");
				}
				
				System.out.print("\n"); // Separació
			} while (choice < 1 || choice > 3);
			
			if (choice == 1) {
				addVideo(user);
			} else if (choice == 2) {
				printVideos(user);
			} else { // choice == 3
				finished = true;
			}
		} while (finished == false);
		
		sc.close();
		
		System.out.println("Aplicació finalitzada.");
		
	}
	
	private static User addUser() {
		String name, lastName, password;
		
		System.out.print("Nom = ");
		name = input();
		System.out.print("Cognoms = ");
		lastName = input();
		System.out.print("Password = ");
		password = input();
		
		System.out.print("\n"); // Separació
		
		return UserController.addUser(name, lastName, password, LocalDate.now());
	}
	
	// Opció 1 del menú:
	private static void addVideo(User user) {
		String URL, title, tagsString;
		List<String> tagsList;
		
		System.out.print("URL = ");
		URL = input();
		System.out.print("Títol = ");
		title = input();
		System.out.print("Tags (separats per comes) = ");
		do {
			try {
				tagsString = input();
				tagsList = splitTagsString(tagsString);
			} catch (RuntimeException e) {
				System.err.println("El vídeo ha de contenir com a mínim 1 tag.");
				tagsList = null;
			}
		} while (tagsList == null);
		
		UserController.addVideo(user, URL, title, tagsList, LocalDateTime.now());
		
		System.out.print("\n"); // Separació
	}
	
	// Opció 2 del menú:
	private static void printVideos(User user) {
		UserController.printVideos(user);
		
		System.out.print("\n"); // Separació
	}
	
	private static String input() {
		String input;
		
		do { // Validació de l'input:
			input = sc.nextLine();
			if (input == null || input.isEmpty() || input.isBlank())
				System.err.println("Aquest camp no pot estar buit.");
		} while (input == null || input.isEmpty() || input.isBlank());
		
		return input;
	}
	
	// Converteix tagsString en tagsArray i, posteriorment, en tagsList
	private static List<String> splitTagsString(String tagsString) throws RuntimeException {
		String[] tagsArray;
		List<String> tagsList = new ArrayList<>();
		
		tagsArray = tagsString.split(",");
		
		// Construcció de tagsListt:
		for (String tag : tagsArray) {
			// tag == null || tag.isEmpty() || tag.isBlank()
			if (tag != null && !tag.isEmpty() && !tag.isBlank()) {
				tag = tag.trim();
				tagsList.add(tag);
			}
		}
		
		// Validació de tagsList:
		if (tagsList.size() == 0)
			throw new RuntimeException();
		
		return tagsList;
	}
	
}
