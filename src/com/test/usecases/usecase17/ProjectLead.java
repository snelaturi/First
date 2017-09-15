package com.test.usecases.usecase17;

public class ProjectLead extends Employee{

	ProjectLead(int employeeLevel) {
		this.employeeLevel=employeeLevel;
	}
	
	@Override
	protected void callReceived(String message) {
		System.out.println("Call Received by Project Lead : " + message);
		
	}

}
