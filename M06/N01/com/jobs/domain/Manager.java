package com.jobs.domain;

public class Manager extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;
	
	// Mètode constructor:
	public Manager(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
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
	public void pay() {
		totalPaid = paymentRate.pay(salaryPerMonth);
	}
	
	// Mètode getter:
	@Override
	public String getTotalPaid() {
		return "Salari mensual = " + totalPaid + " €";
	}

}
