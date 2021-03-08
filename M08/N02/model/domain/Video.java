package model.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;

public class Video {
	
	private String URL, title;
	private List<String> tagsList;
	private LocalDateTime uploadDateTime;
	
	// Mètode constructor:
	public Video() {
		this.tagsList = new ArrayList<>();
	}
	
	// Mètodes setters:
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
	
	// Mètodes getters:
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
	
	public String getUploadStatus(LocalDateTime currentDateTime) {
		long timePassed;
		
		// Càlcul del temps transcorregut entre uploadDateTime i currentDateTime:
		timePassed = uploadDateTime.until(currentDateTime, ChronoUnit.SECONDS);
		
		if (timePassed < 30) {
			return EUploadStatuses.UPLOADING.name();
		} else if (timePassed > 30 && timePassed < 60) {
			return EUploadStatuses.VERIFYING.name();
		} else { // timePassed > 60
			return EUploadStatuses.PUBLIC.name();
		}
	}
	
	private enum EUploadStatuses {
		UPLOADING,
		VERIFYING,
		PUBLIC
	}
	
}
