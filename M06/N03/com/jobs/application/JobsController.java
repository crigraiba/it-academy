package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Manager;
import com.jobs.domain.Senior;
import com.jobs.domain.Mid;
import com.jobs.domain.Junior;
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
	
	public void createSeniorEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Senior senior = new Senior(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateSeniorEmployee());
			
			repository.addMember(senior);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void createMidEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Mid mid = new Mid(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateMidEmployee());
			
			repository.addMember(mid);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void createJuniorEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Junior junior = new Junior(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateJuniorEmployee());
			
			repository.addMember(junior);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void createVolunteer(String name, String address, String phone, double ajutGovernamental) {
		try {
			Volunteer volunteer = new Volunteer(name, address, phone, ajutGovernamental);
			
			repository.addMember(volunteer);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void payAllEmployees() {
		for (AbsStaffMember member : repository.getAllMembers()) {
			try {
				member.pay();
			} catch (Exception e) {
				System.err.println("id = " + member.getId() + ": " + e.getMessage());
			}
		}
	}
	
	public void payBonus() {
		for (AbsStaffMember member : repository.getAllMembers()) {
			member.payBonus();
		}
	}
	
	public String getAllEmployees() {
		StringBuilder sb = new StringBuilder();
		
		for (AbsStaffMember member : repository.getAllMembers() ) {
			sb.append("\nid = " + member.getId() + " [Nom = " + member.getName() + ", Adreça = " + member.getAddress() + ", Telèfon = " + member.getPhone() + ", " + member.getTotalPaid() + ", " + member.getBonus() + "]");
		}
		
		return sb.toString();
	}
	
}
