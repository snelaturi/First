package com.test.usecases.usecase17;

public class ProjectManager extends Employee{

	public ProjectManager(int employeeLevel){
	      this.employeeLevel = employeeLevel;
	   }

	   @Override
	   protected void callReceived(String message) {		
	      System.out.println("Call Received by Project Manager : " + message);
	   }

}
