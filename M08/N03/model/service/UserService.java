package model.service;

import java.time.LocalDate;
import java.time.LocalTime;
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
	public static void addVideo(User user, String URL, String title, LocalTime duration, List<String> tagsList, LocalDateTime uploadDateTime) {
		Video video = new Video();
		
		video.setURL(URL);
		video.setTitle(title);
		video.setDuration(duration);
		video.setTagsList(tagsList);
		video.setUploadDateTime(uploadDateTime);
		
		user.addVideo(video);
	}
	
	// Opció 2 del menú:
	public static void printVideos(User user, LocalDateTime currentDateTime) {
		for (Video video : user.getVideosList())
			video.setUploadStatus(currentDateTime);
		
		System.out.println(user.toString());
	}
	
	// Opció 3 del menú:
	public static Video retrieveVideo(User user, String title) throws Exception {
		for (Video video : user.getVideosList()) {
			if (title.equals(video.getTitle()))
				return video;
		}
		
		throw new Exception("Aquest vídeo no existeix.");
	}
	
}
