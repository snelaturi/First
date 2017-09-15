package com.test.usecases.usecase1;

public interface HandleCalls {

	void setNextChain(HandleCalls nextChain);
	void handle(TelephoneCalls calls);
}
