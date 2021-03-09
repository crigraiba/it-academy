package com.jobs.domain;

public class Senior extends Employee {
	
	private final double IRPF = 0.24;
	
	// M�tode constructor:
	public Senior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}
	
	// M�tode setter:
	@Override
	public void pay() throws Exception {
		totalPaid = paymentRate.pay(salaryPerMonth);
		
		salariNetMensual = totalPaid*(1-IRPF);
		
		salariBrutAnual = totalPaid*12;
		salariNetAnual = salariNetMensual*12;

		// 2700 < totalPaid < 4000
		if (totalPaid <= 2700 || totalPaid >= 4000) { // Validaci� del salari m�nim i m�xim
			throw new Exception("totalPaid <= 2700 || totalPaid >= 4000");
		}
	}

}
