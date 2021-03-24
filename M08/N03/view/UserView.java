package view;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
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
			System.out.println("Tria una opci�:\n1. Afegir un v�deo\n2. Llistar tots els v�deos\n3. Reproduir un v�deo\n4. Sortir");
			
			choice = 0;
			do {
				try {
					choice = Integer.parseInt(input());
					if (choice < 1 || choice > 4)
						throw new NumberFormatException();
				} catch (NumberFormatException e) {
					System.err.println("Introdueix una opci� v�lida.");
				}
			} while (choice < 1 || choice > 4);
			
			System.out.print("\n"); // Separaci�
			
			if (choice == 1) {
				addVideo(user);
			} else if (choice == 2) {
				printVideos(user);
			} else if (choice == 3) {
				mediaPlayer(user);
			} else { // choice == 4
				finished = true;
			}
		} while (finished == false);
		
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
		
		System.out.print("\n"); // Separaci�
		
		return UserController.addUser(name, lastName, password, LocalDate.now());
	}
	
	// Opci� 1 del men�:
	private static void addVideo(User user) {
		String URL, title, tagsString;
		LocalTime duration;
		List<String> tagsList;
		
		System.out.print("URL = ");
		URL = input();
		System.out.print("T�tol = ");
		title = input();
		System.out.print("Durada = ");
		do {
			try {
				duration = LocalTime.parse(input());
			} catch (DateTimeParseException e) {
				System.err.println("El format de la durada ha de ser HH:MM:SS.");
				duration = null;
			}
		} while (duration == null);
		System.out.print("Tags (separats per comes) = ");
		do {
			try {
				tagsString = input();
				tagsList = splitTagsString(tagsString);
			} catch (RuntimeException e) {
				System.err.println("El v�deo ha de contenir com a m�nim 1 tag.");
				tagsList = null;
			}
		} while (tagsList == null);
		
		UserController.addVideo(user, URL, title, duration, tagsList, LocalDateTime.now());
		
		System.out.print("\n"); // Separaci�
	}
	
	// Opci� 2 del men�:
	private static void printVideos(User user) {
		UserController.printVideos(user, LocalDateTime.now());
		
		System.out.print("\n"); // Separaci�
	}
	
	// Opci� 3 del men�:
	private static void mediaPlayer(User user) {
		String title;
		
		System.out.print("T�tol = ");
		title = input();
		
		UserController.playVideo(user, title, LocalDateTime.now());
		
		System.out.print("\n"); // Separaci�
	}
	
	public static int buttons(String choices) {
		int choice;
		
		System.out.println(choices);
		
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
		
		return choice;
	}
	
	private static String input() {
		String input;
		
		do { // Validaci� de l'input:
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
		
		// Construcci� de tagsListt:
		for (String tag : tagsArray) {
			// tag == null || tag.isEmpty() || tag.isBlank()
			if (tag != null && !tag.isEmpty() && !tag.isBlank()) {
				tag = tag.trim();
				tagsList.add(tag);
			}
		}
		
		// Validaci� de tagsList:
		if (tagsList.size() == 0)
			throw new RuntimeException();
		
		return tagsList;
	}
	
}
