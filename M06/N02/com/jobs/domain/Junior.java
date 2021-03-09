package com.jobs.domain;

public class Junior extends Employee {
	
	// M�tode constructor:
	public Junior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}

	// M�tode setter:
	@Override
	public void pay() throws Exception {
		totalPaid = paymentRate.pay(salaryPerMonth);
		
		// 900 < totalPaid < 1600
		if (totalPaid <= 900 || totalPaid >= 1600) { // Validaci� del salari m�nim i m�xim
			throw new Exception("totalPaid <= 900 || totalPaid >= 1600");
		}
	}
	
}
