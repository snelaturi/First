package com.test.usecases.usecase5;

public class CustomCountDownLatchTest {

	public static void main(String[] args) {
		
		CustomCountDownLatch countdownlatch = new CustomCountDownLatch(3);
		
		Thread t1 = new Thread(new Task1(countdownlatch));
		Thread t2 = new Thread(new Task2(countdownlatch));
		Thread t3 = new Thread(new Task3(countdownlatch));
		
		try {
			countdownlatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.start();
		t2.start();
		t3.start();
		
		
		
	}
}

class Task1 implements Runnable {
	private CustomCountDownLatch countdownlatch;
	public Task1(CustomCountDownLatch countdownlatch) {
		this.countdownlatch=countdownlatch;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() +"task START");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() +"task END");
			countdownlatch.countDown();
			//countdownlatch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Task2 implements Runnable {
	private CustomCountDownLatch countdownlatch;
	public Task2(CustomCountDownLatch countdownlatch) {
		// TODO Auto-generated constructor stub
		this.countdownlatch=countdownlatch;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() +"task START");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() +"task END");
			countdownlatch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


class Task3 implements Runnable {
	private CustomCountDownLatch countdownlatch;
	public Task3(CustomCountDownLatch countdownlatch) {
		// TODO Auto-generated constructor stub
		this.countdownlatch=countdownlatch;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() +"task START");
			Thread.sleep(30000);
			System.out.println(Thread.currentThread().getName() +"task END");
			countdownlatch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

