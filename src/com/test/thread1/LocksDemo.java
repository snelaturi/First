package com.test.thread1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksDemo {

	public static void main(String[] args) {
		
		Lock  lock = new ReentrantLock(); 
		
		Thread t1 = new Thread(){
			public void run(){
				lock.lock();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.unlock();
			  System.out.println("am in runmethod..");
			  
			}
		};
		
		t1.start();
		
	}
}
