package com.test.thread1;

public class PrintEvenOddNumSequence {

	public static void main(String[] args) {

		ShareObject sharedObj = new ShareObject();
		Thread t1 = new Thread(new PrintThread(sharedObj, 10, false), "OddThread ");
		Thread t2 = new Thread(new PrintThread(sharedObj, 10, true), "EvenThread");
		t1.start();
		t2.start();
	}

}

class PrintThread implements Runnable {
	private int max;
	private ShareObject sharedObj;
	private boolean isEvenNumber;

	PrintThread(ShareObject sharedObj, int max, boolean isEvenNumber) {
		this.sharedObj = sharedObj;
		this.max = max;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
	public void run() {
		int number;
		if(isEvenNumber) {
			number = 2;
		}  else {
			number = 1;
		}
			
		while (number <= max) {
			if (isEvenNumber) {
				sharedObj.printEven(number);
			} else {
				sharedObj.printOdd(number);
			}
			number += 2;
		}
	}
}

class ShareObject {
	boolean isOdd = false;

	synchronized void printEven(int number) {
		while (isOdd == false) {
			try {
				wait();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "- Even:" + number);
		isOdd = false;
		notifyAll();
	}

	synchronized void printOdd(int number) {
		while (isOdd == true) {
			try {
				wait();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "- Odd :" + number);
		isOdd = true;
		notifyAll();
	}
}
