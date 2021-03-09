package com.jobs.domain;

public class Mid extends Employee {
	
	private final double IRPF = 0.15;
	
	// Mètode constructor:
	public Mid(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}
	
	// Mètode setter:
	@Override
	public void pay() throws Exception {
		totalPaid = paymentRate.pay(salaryPerMonth);
		
		salariNetMensual = totalPaid*(1-IRPF);
		
		salariBrutAnual = totalPaid*12;
		salariNetAnual = salariNetMensual*12;
		
		// 1800 < totalPaid < 2500
		if (totalPaid <= 1800 || totalPaid >= 2500) { // Validació del salari mínim i màxim
			throw new Exception("totalPaid <= 1800 || totalPaid >= 2500");
		}
	}

}
