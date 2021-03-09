package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	// Mètode constructor:
	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
	}
	
	// Mètode setter:
	@Override
	public void pay() throws Exception {
		// totalPaid = 0
		if (totalPaid != 0) { // Validació del salari
			throw new Exception("totalPaid != 0");
		}
	}
	
}
