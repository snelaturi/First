package com.test.thread1;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	static int sharedVal;

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		Thread increment = new Thread(new Thread22(semaphore),"Increment");
		Thread decrement = new Thread(new Thread23(semaphore),"Decrement");
		increment.start();
		decrement.start();

	}

}

class Thread22 implements Runnable {
	Semaphore semaphore;

	Thread22(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is waiting for permit");
		try {
			semaphore.acquire();
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " > " + ++SemaphoreExample.sharedVal);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has released permit");
		semaphore.release();

	}
}

class Thread23 implements Runnable {
	Semaphore semaphore;

	Thread23(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is waiting for permit");
		try {
			semaphore.acquire();
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " > " + --SemaphoreExample.sharedVal);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " has released permit");
		semaphore.release();
	}

}