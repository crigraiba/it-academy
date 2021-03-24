package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;

import model.domain.User;
import model.domain.Video;
import model.service.UserService;
import view.UserView;

public class UserController {
	
	public static User addUser(String name, String lastName, String password, LocalDate registrationDate) {
		return UserService.addUser(name, lastName, password, registrationDate);
	}
	
	public static void addVideo(User user, String URL, String title, LocalTime duration, List<String> tagsList, LocalDateTime uploadDateTime) {
		UserService.addVideo(user, URL, title, duration, tagsList, uploadDateTime);
	}
	
	public static void printVideos(User user, LocalDateTime currentDateTime) {
		UserService.printVideos(user, currentDateTime);
	}
	
	public static void playVideo(User user, String title, LocalDateTime currentDateTime) {
		try { // Validació del vídeo:
			Video video = UserService.retrieveVideo(user, title);
			
			if (video == null)
				throw new Exception("Aquest vídeo no existeix.");
			
			video.play(currentDateTime);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static int requestAction(String choices) {
		return UserView.buttons(choices);
	}
	
}
