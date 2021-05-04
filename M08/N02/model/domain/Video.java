package model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;

public class Video {
	
	private String URL, title;
	private List<String> tagsList;
	private LocalDateTime uploadDateTime;
	private EUploadStatus uploadStatus;
	
	private enum EUploadStatus {
		UPLOADING, VERIFYING, PUBLIC
		// < 30 s, 30-60 s, > 60 s
	}
	
	// M�tode constructor:
	public Video() {
		this.tagsList = new ArrayList<>();
	}
	
	// M�todes setter:
	public void setURL(String URL) {
		this.URL = URL;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setTagsList(List<String> tagsList) {
		this.tagsList = tagsList;
	}
	
	public void setUploadDateTime(LocalDateTime uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}
	
	public void setUploadStatus(LocalDateTime currentDateTime) {
		long timePassed;
			
		// C�lcul del temps transcorregut entre uploadDateTime i currentDateTime:
		timePassed = uploadDateTime.until(currentDateTime, ChronoUnit.SECONDS);
		
		if (timePassed < 30) {
			this.uploadStatus = EUploadStatus.UPLOADING;
		} else if (timePassed >= 30 && timePassed <= 60) {
			this.uploadStatus = EUploadStatus.VERIFYING;
		} else { // timePassed > 60
			this.uploadStatus = EUploadStatus.PUBLIC;
		}
	}
	
	// M�todes getter:
	public String getURL() {
		return URL;
	}
	
	public String getTitle() {
		return title;
	}
	
	public List<String> getTagsList() {
		return tagsList;
	}
	
	public LocalDateTime getUploadDateTime() {
		return uploadDateTime;
	}
	
	public String getUploadStatus() {
		return uploadStatus.name();
	}
	
	// Altres m�todes:
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
		
		return "[URL = " + URL + ", T�tol = " + title + ", Tags = " + tagsList +
			", Data i hora de pujada = " + uploadDateTime.format(formatter) +
			", Estat de pujada = " + uploadStatus + "]";
	}
	
}
