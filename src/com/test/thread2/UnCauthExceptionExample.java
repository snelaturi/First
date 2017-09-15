package com.test.thread2;

import com.test.Util;

public class UnCauthExceptionExample {

	public static void main(String[] args) {
		
		Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread th, Throwable ex) {
                System.out.println("Uncaught exception: " + ex);
            }
        };
		
		Thread t1 = new Thread(new Worker());
		Thread t2 = new Thread(new Worker());
		t1.setUncaughtExceptionHandler(h);
		//t2.setUncaughtExceptionHandler(h);
		t1.start();
		t2.start();
        System.out.println("main thread " + Thread.currentThread());
        
        
	}

	static class Worker implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread());
			Util.sleep(5000);
			throw new NullPointerException();

		}

	}

}
