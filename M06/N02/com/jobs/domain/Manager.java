package com.jobs.domain;

public class Manager extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;
	
	// M�tode constructor:
	public Manager(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
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
		
		// 3000 < totalPaid < 5000
		if (totalPaid <= 3000 || totalPaid >= 5000) { // Validaci� del salari m�nim i m�xim
			throw new Exception("totalPaid <= 3000 || totalPaid >= 5000");
		}
	}
	
	// M�tode getter:
	@Override
	public String getTotalPaid() {
		return "Salari mensual = " + totalPaid + " �";
	}

}
