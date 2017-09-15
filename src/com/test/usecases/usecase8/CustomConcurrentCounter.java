package com.test.usecases.usecase8;

public class CustomConcurrentCounter {

	private volatile int count = 0;

	private Object lock = new Object();

	public void increment() {
		synchronized (lock) {
			count++;
		}
	}

	public void decrement() {
		synchronized (lock) {
			count--;
		}
	}

	public int getCount() {
		return count;
	}

}
