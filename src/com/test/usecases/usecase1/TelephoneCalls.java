package com.test.usecases.usecase1;

public class TelephoneCalls {
	public TelephoneCalls(Boolean callAttented, String callType) {
		this.callAttented = callAttented;
		this.callType = callType;
	}
	
	private Boolean callAttented;
	private String callType;
	
	
	public Boolean getCallAttented() {
		return callAttented;
	}
	public void setCallAttented(Boolean callAttented) {
		this.callAttented = callAttented;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	
	

}
