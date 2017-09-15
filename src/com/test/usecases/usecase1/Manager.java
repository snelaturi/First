package com.test.usecases.usecase1;

public class Manager implements HandleCalls{

private HandleCalls handleCalls;
	
	@Override
	public void setNextChain(HandleCalls nextChain) {
		this.handleCalls = nextChain;
	}

	@Override
	public void handle(TelephoneCalls calls) {
		if((!calls.getCallAttented()) && calls.getCallType().equalsIgnoreCase("H")){
			System.out.println("call attented by Manager");
		}
		else{
			handleCalls.handle(calls);
		}
	}
}
