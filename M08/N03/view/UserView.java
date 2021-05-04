package view;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import model.domain.User;
import controller.UserController;

public class UserView {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		User user = addUser();
		
		int choice;
		do {
			System.out.println("Tria una opció:\n1. Afegir un vídeo\n2. Llistar tots els vídeos\n3. Reproduir un vídeo\n4. Sortir de l'aplicació");
			
			choice = 0;
			do {
				try {
					choice = Integer.parseInt(input());
					if (choice < 1 || choice > 4)
						throw new NumberFormatException();
				} catch (NumberFormatException e) {
					System.err.println("Introdueix una opció vàlida.");
				}
			} while (choice < 1 || choice > 4);
			
			System.out.println(); // Separació
			
			if (choice == 1) {
				addVideo(user);
			} else if (choice == 2) {
				printVideos(user);
			} else if (choice == 3) {
				mediaPlayer(user);
			}
		} while (choice != 4);
		
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
		
		System.out.println(); // Separació
		
		return UserController.addUser(name, lastName, password, LocalDate.now());
	}
	
	// Opció 1 del menú:
	private static void addVideo(User user) {
		String URL, title, tagsString;
		LocalTime duration;
		List<String> tagsList;
		
		System.out.print("URL = ");
		URL = input();
		System.out.print("Títol = ");
		title = input();
		System.out.print("Durada = ");
		do {
			try {
				duration = LocalTime.parse(input());
			} catch (DateTimeParseException e) {
				System.err.println("El format de la durada ha de ser HH:mm:ss.");
				duration = null;
			}
		} while (duration == null);
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
		
		UserController.addVideo(user, URL, title, duration, tagsList, LocalDateTime.now());
		
		System.out.println(); // Separació
	}
	
	// Opció 2 del menú:
	private static void printVideos(User user) {
		UserController.printVideos(user, LocalDateTime.now());
		
		System.out.println(); // Separació
	}
	
	// Opció 3 del menú:
	private static void mediaPlayer(User user) {
		String title;
		
		System.out.print("Títol = ");
		title = input();
		
		UserController.playVideo(user, title, LocalDateTime.now());
		
		System.out.println(); // Separació
	}
	
	public static int buttons(String choices) {
		int choice = 0;
		do {
			try {
				choice = Integer.valueOf(JOptionPane.showInputDialog(null, choices));
				if (choice != 1 && choice != 2)
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				System.err.println("Introdueix una opció vàlida.");
			}
		} while (choice != 1 && choice != 2);
		
		return choice;
	}
	
	// Introducció de l'input:
	private static String input() {
		String input;
		
		do { // Validació de l'input:
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
		
		// Construcció de tagsList:
		for (String tag : tagsArray) {
			// tag == null || tag.isEmpty() || tag.isBlank()
			if (tag != null && !tag.isEmpty() && !tag.isBlank()) {
				tag = tag.trim();
				tagsList.add(tag);
			}
		}
		
		// Validació de tagsList:
		if (tagsList.size() == 0)
			throw new Exception("El vídeo ha de contenir com a mínim 1 tag.");
		
		return tagsList;
	}
	
}
