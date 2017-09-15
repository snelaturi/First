package com.test.thread1;

public class WaitSleep {

	public static void main(String[] args) {

		Thread t1 = new Thread(new WaitThread(),"Thread1");
		t1.start();
		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("nofying" + Thread.currentThread().getName());
		synchronized (t1) {
			t1.interrupted();
		}
		System.out.println("notified" + Thread.currentThread().getName());
		
	}
	
}

class WaitThread implements Runnable {

	@Override
	public void run() {
		System.out.println("run method.. START" + Thread.currentThread().getName());
		synchronized (this) {
			try {
				wait(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("run method... END");
		}
		
	}
	
}

