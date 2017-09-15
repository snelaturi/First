package com.test.thread2;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
	
	public static void main(String[] args) {
		
		  DeadlockDetector deadlockDetector = new DeadlockDetector(new DeadlockConsoleHandler(), 20, TimeUnit.SECONDS);
			deadlockDetector.start();
		
		SharedObject1 obj = new SharedObject1();
		Thread t1 = new Thread(new SharedThread1(obj));
		Thread t2 = new Thread(new SharedThread2(obj));
		
		t1.start();
		t2.start();

	}
	
	static class SharedThread1 implements Runnable {
		SharedObject1 sharedThread;
		
		SharedThread1(SharedObject1 sharedThread){
			this.sharedThread= sharedThread;
		}
		
		@Override
		public void run() {
			sharedThread.m1();
		}
	}
	
	static class SharedThread2 implements Runnable {
		SharedObject1 sharedThread;
		
		SharedThread2(SharedObject1 sharedThread){
			this.sharedThread= sharedThread;
		}
		
		@Override
		public void run() {
			sharedThread.m2();
		}
		
	}

}

class SharedObject1{
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	public void m1(){
		synchronized (lock1) {
			System.out.println("Acquiring lock on Lock1");
			synchronized (lock2) {
				System.out.println("Acquiring lock on Lock2");
			}
			
		}
	}
	public void m2(){
		synchronized (lock2) {
			System.out.println("Acquiring lock on Lock2");
			synchronized (lock1) {
				System.out.println("Acquiring lock on Lock1");
			}
			
		}
	}
}
