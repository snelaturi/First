package com.test.thread2;

public class CounterExample {

	public static void main(String[] args) {
     Thread t1 = new Thread(new Task(1),"Thread1");
     Thread t2 = new Thread(new Task(1),"Thread2");
     t1.start();
     t2.start();
     
	}
}

class Task implements Runnable {
	int val=1;

	Task(int val) {
		//this.val = val;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			this.val = increment();
		}
		System.out.println(Thread.currentThread().getName() + "       "+ this.val);
	}

	public int increment() {
		return this.val = this.val+1;
	}
}

class SharedObject {
	int val;

	SharedObject(int val) {
		this.val = val;
	}

	public synchronized int increment() {
		return val++;
	}
}