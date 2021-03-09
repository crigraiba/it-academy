package com.jobs.domain;

public class Junior extends Employee {
	
	// Mètode constructor:
	public Junior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}

	// Mètode setter:
	@Override
	public void pay() throws Exception {
		totalPaid = paymentRate.pay(salaryPerMonth);
		
		// 900 < totalPaid < 1600
		if (totalPaid <= 900 || totalPaid >= 1600) { // Validació del salari mínim i màxim
			throw new Exception("totalPaid <= 900 || totalPaid >= 1600");
		}
	}
	
}
