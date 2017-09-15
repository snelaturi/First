package com.test.usecases.usecase1;

public class Lead implements HandleCalls{
private HandleCalls handleCalls;
	
	@Override
	public void setNextChain(HandleCalls nextChain) {
		this.handleCalls = nextChain;
	}

	@Override
	public void handle(TelephoneCalls calls) {
		if((!calls.getCallAttented()) && calls.getCallType().equalsIgnoreCase("M")){
			System.out.println("call attented by Lead");
		}
		else{
			handleCalls.handle(calls);
		}
	}

}
