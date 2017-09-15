package com.test.thread1;

public class ThreadsDemo1 {

	
	public static void main(String[] args) {

		Thread t1 = new Thread(new MyThread1(),"Thread1");
		
		t1.setUncaughtExceptionHandler(h);
		t1.setDaemon(true);
		t1.start();
		
		try {
			//t1.join();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(" state : "+t1.getState().name());
		System.out.println("main method end.");
		
		
	}
	static Thread.UncaughtExceptionHandler h =new Thread.UncaughtExceptionHandler(){

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("Thread name - " + Thread.currentThread().getName());
	        System.out.println("Uncaught exception: " + e);
			
		}
	};

}


class MyThread1 implements Runnable {

	@Override
	public void run() {
        
		for(int i =0; true; i++) {
			/*if(i==10) {
				throw new NullPointerException();
			}*/
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
