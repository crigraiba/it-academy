package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import model.domain.User;
import model.service.UserService;

public class UserController {
	
	public static User addUser(String name, String lastName, String password, LocalDate registrationDate) {
		return UserService.addUser(name, lastName, password, registrationDate);
	}
	
	public static void addVideo(User user, String URL, String title, List<String> tagsList, LocalDateTime uploadDateTime) {
		UserService.addVideo(user, URL, title, tagsList, uploadDateTime);
	}
	
	public static void printVideos(User user, LocalDateTime currentDateTime) {
		UserService.printVideos(user, currentDateTime);
	}
	
}
