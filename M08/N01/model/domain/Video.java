package model.domain;

import java.util.List;
import java.util.ArrayList;

public class Video {
	
	private String URL, title;
	private List<String> tagsList;
	
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
	
}
