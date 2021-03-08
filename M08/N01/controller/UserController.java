package controller;

import java.time.LocalDate;
import java.util.List;

import model.domain.User;
import model.service.UserService;

public class UserController {
	
	public static User addUser(String name, String lastName, String password, LocalDate registrationDate) {
		return UserService.addUser(name, lastName, password, registrationDate);
	}
	
	public static void addVideo(User user, String URL, String title, List<String> tagsList) {
		UserService.addVideo(user, URL, title, tagsList);
	}
	
	public static void printVideos(User user) {
		UserService.printVideos(user);
	}
	
}
