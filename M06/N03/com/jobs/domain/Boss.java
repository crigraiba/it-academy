package com.jobs.domain;

public class Boss extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;
	
	private final double IRPF = 0.32;
	
	// Mètode constructor:
	public Boss(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);
		
		if (salaryPerMonth < 0)
			throw new Exception("salaryPerMonth < 0");
		if (paymentRate == null)
			throw new Exception("paymentRate == null");
		
		this.salaryPerMonth = salaryPerMonth;
		this.paymentRate = paymentRate;
	}
	
	// Mètode setter:
	@Override
	public void pay() throws Exception {
		totalPaid = paymentRate.pay(salaryPerMonth);
		
		salariNetMensual = totalPaid*(1-IRPF);
		
		salariBrutAnual = totalPaid*12;
		salariNetAnual = salariNetMensual*12;
		
		// totalPaid < 8000
		if (totalPaid <= 8000) { // Validació del salari mínim
			throw new Exception("totalPaid <= 8000");
		}
	}
	
	// Mètode getter:
	@Override
	public String getTotalPaid() {
		return "Salari brut mensual = " + totalPaid + " €, Salari net mensual = " + salariNetMensual + " €, Salari brut anual = " + salariBrutAnual + " €, Salari net anual = " + salariNetAnual + " €";
	}
}
