package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Manager;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {
	
	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController() {
	}
	
	public void createBoss(String name, String address, String phone, double salaryPerMonth) {
		try {
			Boss boss = new Boss(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
			
			repository.addMember(boss);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void createManager(String name, String address, String phone, double salaryPerMonth) {
		try {
			Manager manager = new Manager(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
			
			repository.addMember(manager);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Employee employee = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
			
			repository.addMember(employee);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void createVolunteer(String name, String address, String phone) {
		try {
			Volunteer volunteer = new Volunteer(name, address, phone);
			
			repository.addMember(volunteer);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void payAllEmployees() {
		for (AbsStaffMember member : repository.getAllMembers()) {
			member.pay();
		}
	}
	
	public String getAllEmployees() {
		StringBuilder sb = new StringBuilder();
		
		for (AbsStaffMember member : repository.getAllMembers() ) {
			sb.append("\nid = " + member.getId() + " [Nom = " + member.getName() + ", Adreça = " + member.getAddress() + ", Telèfon = " + member.getPhone() + ", " + member.getTotalPaid() + "]");
		}
		
		return sb.toString();
	}
	
}
