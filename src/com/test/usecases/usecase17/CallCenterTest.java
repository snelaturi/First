package com.test.usecases.usecase17;

public class CallCenterTest {

	public static void main(String[] args) {

		   Employee fresher = new Fresher(Employee.FRESHER_LEVEL);
		   Employee lead = new ProjectLead(Employee.PROJECT_LEAD_LEVEL);
		   Employee manager = new ProjectManager(Employee.PROJECT_MANAGER_LEVEL);
		   
		   fresher.setNextContactPoint(lead);
		   lead.setNextContactPoint(manager);
		   
		   String customerMsg = "Customer Message";
           
		   fresher.callReceivedCallCenter(customerMsg);


	}

}
