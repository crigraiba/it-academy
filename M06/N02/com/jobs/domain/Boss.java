package com.jobs.domain;

public class Boss extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;
	
	// M�tode constructor:
	public Boss(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);
		
		if (salaryPerMonth < 0)
			throw new Exception("salaryPerMonth < 0");
		if (paymentRate == null)
			throw new Exception("paymentRate == null");
		
		this.salaryPerMonth = salaryPerMonth;
		this.paymentRate = paymentRate;
	}
	
	// M�tode setter:
	@Override
	public void pay() throws Exception {
		totalPaid = paymentRate.pay(salaryPerMonth);
		
		// totalPaid < 8000
		if (totalPaid <= 8000) { // Validaci� del salari m�nim
			throw new Exception("totalPaid <= 8000");
		}
	}
	
	// M�tode getter:
	@Override
	public String getTotalPaid() {
		return "Salari mensual = " + totalPaid + " �";
	}
}
