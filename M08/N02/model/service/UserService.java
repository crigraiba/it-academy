package model.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import model.domain.User;
import model.domain.Video;

public class UserService {

	private static List<User> users = new ArrayList<>();
	
	public static User addUser(String name, String lastName, String password, LocalDate registrationDate) {
		User user = new User();
		
		user.setName(name);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setRegistrationDate(registrationDate);
		
		users.add(user);
		
		return user;
	}
	
	// Opció 1 del menú:
	public static void addVideo(User user, String URL, String title, List<String> tagsList, LocalDateTime uploadDateTime) {
		Video video = new Video();
		
		video.setURL(URL);
		video.setTitle(title);
		video.setTagsList(tagsList);
		video.setUploadDateTime(uploadDateTime);
		
		user.addVideo(video);
	}
	
	// Opció 2 del menú:
	public static void printVideos(User user, LocalDateTime currentDateTime) {
		System.out.println("Usuari:\n[Nom = " + user.getName() + ", Cognoms = " + user.getLastName() + ", Password = " + user.getPassword() + ", Data de registre = " + user.getRegistrationDate() + "]"
						+ "\nLlista de vídeos:" + user.getVideosList(currentDateTime));
	}
	
}
