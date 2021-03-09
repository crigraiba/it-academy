package com.jobs.domain;

public abstract class AbsStaffMember {

	protected int id;
	protected String name, address, phone;
	protected double totalPaid = 0;
	
	private static int COUNTER_MEMBERS = 1;
	
	// Mètode constructor:
	public AbsStaffMember(String name, String address, String phone) throws Exception {
		if (name.equals(""))
			throw new Exception("El camp name no pot estar buit.");
		if (address.equals(""))
			throw new Exception("El camp address no pot estar buit.");
		if (phone.equals(""))
			throw new Exception("El camp phone no pot estar buit.");
		
		this.name = name;
		this.address = address;
		this.phone = phone;
		id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}
	
	// Mètode setter:
	public abstract void pay();
	
	// Mètodes getters:
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	// Aquest mètode és sobrescrit per totes les subclasses excepte per la subclasse Volunteer
	public String getTotalPaid() {
		return "No té salari";
	}
	
}
