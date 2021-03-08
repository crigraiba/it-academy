package model.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name, lastName, password;
	private LocalDate registrationDate;
	private List<Video> videosList;
	
	// Mètode constructor:
	public User() {
		this.videosList = new ArrayList<>();
	}
	
	// Mètodes setters:
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	// Mètodes getters:
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	
	public void addVideo(Video video) {
		videosList.add(video);
	}
	
	public String getVideosList() {
		StringBuilder sb = new StringBuilder();
		
		for (Video video : videosList) {
			sb.append("\n[URL = " + video.getURL() + ", Títol = " + video.getTitle() + ", Tags = " + video.getTagsList() + ", Data i hora de pujada = " + video.getUploadDateTime() + ", Estat de pujada = " + video.getUploadStatus(LocalDateTime.now()) + "]");
		}
		
		return sb.toString();
	}
	
}
