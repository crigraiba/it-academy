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
	
	public int getDriverLicenseType() {
		return type;
	}
	
	public String getInfo() {
		String textType = null;
		
		if (type == 1) {
			textType = "MOTO";
		} else if (type == 2) {
			textType = "COTXE";
		} else if (type == 3) {
			textType = "CAMIÓ";
		}
		
		return "[ID = " + id + ", Tipus = " + textType + ", Nom complet = " + fullName + ", Data de caducitat = " + expirationDate + "]";
	}
	
}
