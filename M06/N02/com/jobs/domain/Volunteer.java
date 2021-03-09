package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	// M�tode constructor:
	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
	}
	
	// M�tode setter:
	@Override
	public void pay() throws Exception {
		// totalPaid = 0
		if (totalPaid != 0) { // Validaci� del salari
			throw new Exception("totalPaid != 0");
		}
	}
	
}
