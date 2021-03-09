package com.jobs.domain;

public class Manager extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;
	
	private final double IRPF = 0.26;
	
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
		
		salariNetMensual = totalPaid*(1-IRPF);
		
		salariBrutAnual = totalPaid*12;
		salariNetAnual = salariNetMensual*12;
		
		// 3000 < totalPaid < 5000
		if (totalPaid <= 3000 || totalPaid >= 5000) { // Validaci� del salari m�nim i m�xim
			throw new Exception("totalPaid <= 3000 || totalPaid >= 5000");
		}
	}
	
	// M�tode getter:
	@Override
	public String getTotalPaid() {
		return "Salari brut mensual = " + totalPaid + " �, Salari net mensual = " + salariNetMensual + " �, Salari brut anual = " + salariBrutAnual + " �, Salari net anual = " + salariNetAnual + " �";
	}

}
