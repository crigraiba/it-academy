package com.jobs.domain;

public abstract class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;
	
	// M�tode constructor:
	public Employee(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
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
	public abstract void pay() throws Exception;
	
	// M�tode getter:
	@Override
	public String getTotalPaid() {
		return "Salari brut mensual = " + totalPaid + " �, Salari net mensual = " + salariNetMensual + " �, Salari brut anual = " + salariBrutAnual + " �, Salari net anual = " + salariNetAnual + " �";
	}
	
}
