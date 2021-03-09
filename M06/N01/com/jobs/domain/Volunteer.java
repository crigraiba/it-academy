package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	// Mètode constructor:
	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
	}
	
	// Mètode setter:
	@Override
	public void pay() {
	}
	
}
