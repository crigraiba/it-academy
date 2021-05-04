package model.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name, lastName, password;
	private LocalDate registrationDate;
	private List<Video> videosList;
	
	// M�tode constructor:
	public User() {
		this.videosList = new ArrayList<>();
	}
	
	// M�todes setter:
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
	
	// M�todes getter:
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
	
	public List<Video> getVideosList() {
		return videosList;
	}
	
	// Altres m�todes:
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("V�deos:");
		
		for (Video video : videosList) {
			sb.append("\n\t" + video.toString());
		}
		
		return "Usuari:\nNom = " + name + "\nCognoms = " + lastName + "\nPassword = " + password +
			"\nData de registre = " + registrationDate.format(formatter) + "\n" + sb.toString();
	}

	public void addVideo(Video video) {
		videosList.add(video);
	}
	
}
