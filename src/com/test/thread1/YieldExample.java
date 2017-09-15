package com.test.thread1;

public class YieldExample {

	public static void main(String[] args) {
 	    long start = System.currentTimeMillis();
		Thread t1 = new Thread(new MyThread4());
		//Thread t2 = new Thread(new MyThread4());
		t1.start();
		//t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		long time = (end-start)/1000;
		
		System.out.println("Nano secs : "+ (end-start));
		
		System.out.println("secs : " + time);
		//Thread t1 = new Thread(new MyThread1());
    
	}

}

class MyThread4 implements Runnable {

	@Override
	public void run() {
		
		for(int i =0 ; i <1000000; i++) {
			if(i%10000==0){
				Thread.yield();
			}
			System.out.println(i);
		}
		
	}
	
}

class MyThread5 implements Runnable {

	@Override
	public void run() {
		for(int i =0 ; i <1000000; i++) {
			System.out.println(i);
		}
		
	}
	
}
