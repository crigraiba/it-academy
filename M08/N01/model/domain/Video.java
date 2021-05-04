package model.domain;

import java.util.List;
import java.util.ArrayList;

public class Video {
	
	private String URL, title;
	private List<String> tagsList;
	
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
	
	// Altres m�todes:
	@Override
	public String toString() {
		return "[URL = " + URL + ", T�tol = " + title + ", Tags = " + tagsList + "]";
	}
	
}
