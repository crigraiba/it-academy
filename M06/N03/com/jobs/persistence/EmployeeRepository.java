package com.jobs.persistence;

import java.util.List;

import com.jobs.domain.AbsStaffMember;

import java.util.ArrayList;

public class EmployeeRepository {

	private static List<AbsStaffMember> members = new ArrayList<>();
	
	public EmployeeRepository() {
	}
	
	public void addMember(AbsStaffMember member) throws Exception {
		if (member == null)
			throw new Exception("member == null");
		
		members.add(member);
	}
	
	public List<AbsStaffMember> getAllMembers() {
		return new ArrayList<>(members);
	}
	
}
