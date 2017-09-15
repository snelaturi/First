package com.test.thread1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSequnce1 {
	int status = 1;

	public static void main(String[] args) {
		AtomicInteger sharedObj = new AtomicInteger(1);
		
		Thread t1 = new Thread(new ThreadA(sharedObj), "ThreadA");
		Thread t2 = new Thread(new ThreadA(sharedObj), "ThreadB");
		
		t1.start();
		t2.start();

	}

}

class ThreadA implements Runnable {
	AtomicInteger sharedObj;

	ThreadA(AtomicInteger sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		synchronized (sharedObj) {
			while(sharedObj.get() <=20) {
			if (sharedObj.get()%2 == 1) {
				try {
					sharedObj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "----" + sharedObj.getAndIncrement());
			sharedObj.notifyAll();
			}
		}
	}
}

class ThreadB implements Runnable {
	AtomicInteger sharedObj;

	ThreadB(AtomicInteger sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		synchronized (sharedObj) {
		   
			while (sharedObj.get() <=20) {
				if (sharedObj.get()%2 == 0) {
    				try {
    					sharedObj.wait();
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    			}
    			System.out.println(Thread.currentThread().getName() + "----" + sharedObj.getAndIncrement());
    			sharedObj.notifyAll();	
			}
		}
	}
}
