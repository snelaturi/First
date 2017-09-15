package com.test;

import java.util.concurrent.TimeUnit;

import com.test.thread2.DeadlockConsoleHandler;
import com.test.thread2.DeadlockDetector;

public class DeadLockDemo {

	public static void main(String[] args) {

		

		
		SharedObject sharedObj = new SharedObject();

		Thread t1 = new Thread(new Thread1(sharedObj), "Thread1");
		Thread t2 = new Thread(new Thread2(sharedObj), "Thread2");

		t1.start();
		t2.start();

		
		
	}

}

class SharedObject {
	public void m1() {
		synchronized (String.class) {
			System.out.println("Acquiring locking on String object");
			synchronized (Integer.class) {
				System.out.println("Acquiring locking on Integer object");
			}
		}
	}

	public synchronized void m2() {
		synchronized (Integer.class) {
			System.out.println("Acquiring locking on Integer object");
			synchronized (String.class) {
				System.out.println("Acquiring locking on String object");
			}
		}
	}
}

class Thread1 implements Runnable {
	private SharedObject sharedObj;

	Thread1(SharedObject sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		sharedObj.m1();
	}

}

class Thread2 implements Runnable {
	private SharedObject sharedObj;

	Thread2(SharedObject sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		sharedObj.m2();
	}

}