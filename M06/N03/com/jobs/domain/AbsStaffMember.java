package com.jobs.domain;

public abstract class AbsStaffMember {

	protected int id;
	protected String name, address, phone;
	protected double totalPaid = 0; // salariBrutMensual
	protected double salariNetMensual, salariBrutAnual, salariNetAnual;
	protected double bonus;
	
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
	
	// Mètodes setters:
	public abstract void pay() throws Exception;
	
	public void payBonus() {
		bonus = salariBrutAnual*0.1;
	}
	
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
	
	// Aquest mètode és sobrescrit per totes les subclasses
	public abstract String getTotalPaid();
	
	// Aquest mètode és sobrescrit per la subclasse Volunteer
	public String getBonus() {
		return "Bonus = " + bonus + " €";
	}
	
}
