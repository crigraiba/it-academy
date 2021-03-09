package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected double ajutGovernamental;
	
	// Mètode constructor:
	public Volunteer(String name, String address, String phone, double ajutGovernamental) throws Exception {
		super(name, address, phone);
		
		this.ajutGovernamental = ajutGovernamental;
	}
	
	// Mètode setter:
	@Override
	public void pay() throws Exception {
		// totalPaid = 0
		if (totalPaid != 0) { // Validació del salari
			throw new Exception("totalPaid != 0");
		}
		
		// 0 <= ajutGovernamental <= 300
		if (ajutGovernamental < 0 || ajutGovernamental > 300) {
			throw new Exception("ajutGovernamental < 0 || ajutGovernamental > 300");
		}
	}
	
	// Mètodes getters:
	@Override
	public String getTotalPaid() {
		if (ajutGovernamental == 0) {
			return "No té salari, No rep ajut governamental";
		} else {
			return "No té salari, Ajut governamental = " + ajutGovernamental + " €";
		}
	}
	
	@Override
	public String getBonus() {
		return "No rep bonus";
	}
	
}
