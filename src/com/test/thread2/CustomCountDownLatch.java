package com.test.thread2;

public class CustomCountDownLatch {
	
	private int count;
	private final Object lock = new Object();
	CustomCountDownLatch(int count){
		this.count=count;
	}
	
	public void await() throws InterruptedException{
		synchronized (lock) {
			while(count > 0) {
				lock.wait();
			}
		}
	}
	
	public void countDown(){
		
		synchronized (lock) {
			count--;
			if(count == 0) {
				lock.notifyAll();
			}
			
		}
	}
	
	public int getCount(){
		return count;
	}

}
