package com.jobs.domain;

public class Junior extends Employee {
	
	private final double IRPF = 0.02;
	
	// Mètode constructor:
	public Junior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}

	// Mètode setter:
	@Override
	public void pay() throws Exception {
		totalPaid = paymentRate.pay(salaryPerMonth);
		
		salariNetMensual = totalPaid*(1-IRPF);
		
		salariBrutAnual = totalPaid*12;
		salariNetAnual = salariNetMensual*12;
		
		// 900 < totalPaid < 1600
		if (totalPaid <= 900 || totalPaid >= 1600) { // Validació del salari mínim i màxim
			throw new Exception("totalPaid <= 900 || totalPaid >= 1600");
		}
	}
	
}
