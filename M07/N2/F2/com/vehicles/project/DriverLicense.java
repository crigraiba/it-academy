package com.vehicles.project;

import java.time.LocalDate;

public class DriverLicense {
	
	private String id;
	private int type;
	private String fullName;
	private LocalDate expirationDate;
	
	public DriverLicense(String id, int type, String fullName, LocalDate expirationDate) {
		this.id = id;
		this.type = type;
		this.fullName = fullName;
		this.expirationDate = expirationDate;
	}
	
}
