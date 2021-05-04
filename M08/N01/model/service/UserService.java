package model.service;

import java.time.LocalDate;
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
	
	// Opci� 1 del men�:
	public static void addVideo(User user, String URL, String title, List<String> tagsList) {
		Video video = new Video();
		
		video.setURL(URL);
		video.setTitle(title);
		video.setTagsList(tagsList);
		
		user.addVideo(video);
	}
	
	// Opci� 2 del men�:
	public static void printVideos(User user) {
		System.out.println(user.toString());
	}
	
}
