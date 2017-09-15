package com.test.usecases.usecase1;

public class Fresher implements HandleCalls{

private HandleCalls handleCalls;
	
	@Override
	public void setNextChain(HandleCalls nextChain) {
		this.handleCalls = nextChain;
	}

	@Override
	public void handle(TelephoneCalls calls) {
		if((!calls.getCallAttented()) && calls.getCallType().equalsIgnoreCase("L")){
			System.out.println("call attented by Fresher");
		}
		else{
			handleCalls.handle(calls);
		}
	}
}
