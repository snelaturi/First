package com.test.usecases.usecase1;

import java.util.Scanner;

public class CallCenterTest {

	HandleCalls frsherhandlingCalls;
	
	public CallCenterTest() {
		frsherhandlingCalls = new Fresher();
		HandleCalls leadHandlingCalls = new Lead();
		HandleCalls managerHandlingCalls = new Manager();
		
		frsherhandlingCalls.setNextChain(leadHandlingCalls);
		leadHandlingCalls.setNextChain(managerHandlingCalls);
	}
	
	public static void main(String[] args) {
		CallCenterTest designCallCentre = new CallCenterTest();
		while(true){
			System.out.println("Enter the lpriority of call");
			String input = new Scanner(System.in).nextLine();
			
			TelephoneCalls telephoneCalls=null;
			if(input.equalsIgnoreCase("L")){
				telephoneCalls = new TelephoneCalls(false, "L");
			}
			else if(input.equalsIgnoreCase("M")){
				telephoneCalls = new TelephoneCalls(false, "M");
			}
			else if(input.equalsIgnoreCase("H")){
				telephoneCalls = new TelephoneCalls(false, "H");
			}
			designCallCentre.frsherhandlingCalls.handle(telephoneCalls);
		}
	}
}
