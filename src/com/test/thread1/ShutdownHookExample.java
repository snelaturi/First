package com.test.thread1;

public class ShutdownHookExample {

	public static void main(String[] args) {
		
		Runtime.getRuntime().addShutdownHook(new Thread(()->{
			System.out.println("am in run method..");
			try{Thread.sleep(10000);}catch (Exception e) {}
			
		}));
		System.out.println("before exit");
		System.exit(1);
		System.out.println("after exit");
		try{Thread.sleep(3000);}catch (Exception e) {}  
		System.out.println("final");
		
	}

}
