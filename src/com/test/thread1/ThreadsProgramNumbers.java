package com.test.thread1;

public class ThreadsProgramNumbers {

	public static void main(String[] args) {

		int max = 50;

		Thread t1 = new Thread(new MyThread2(max));
		Thread t2 = new Thread(new MyThread3(max));
		Thread t3 = new Thread(new Thread5(max));
		Thread t4 = new Thread(new Thread8(max));

		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
			t3.join();
			t4.start();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class MyThread2 implements Runnable {

	int max;

	MyThread2(int max) {
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i <= max; i++) {
			if (i % 2 == 0)
				System.out.print(i + " ");
		}
	}

}

class MyThread3 implements Runnable {

	int max;

	MyThread3(int max) {
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i <= max; i++) {
			if (i % 3 == 0)
				System.out.print(i + " ");
		}
	}
}

class Thread5 implements Runnable {

	int max;

	Thread5(int max) {
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i <= max; i++) {
			if (i % 5 == 0)
				System.out.print(i + " ");
		}
	}
}

class Thread8 implements Runnable {

	int max;

	Thread8(int max) {
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i <= max; i++) {
			if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0)
				System.out.print(i + " ");
		}
	}
}
