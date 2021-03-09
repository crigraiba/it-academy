package com.jobs.domain;

public class Senior extends Employee {
	
	// Mètode constructor:
	public Senior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}
	
	// Mètode setter:
	@Override
	public void pay() throws Exception {
		totalPaid = paymentRate.pay(salaryPerMonth);

		// 2700 < totalPaid < 4000
		if (totalPaid <= 2700 || totalPaid >= 4000) { // Validació del salari mínim i màxim
			throw new Exception("totalPaid <= 2700 || totalPaid >= 4000");
		}
	}

}
