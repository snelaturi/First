package com.test.usecases.usecase3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumerTest1 {

	public static void main(String[] args) {

		Queue<Integer> sharedObj = new LinkedList<>();
		int maxSize = 5;
		Thread prodThread = new Thread(new Producer(sharedObj, maxSize), "Producer");
		Thread consThread = new Thread(new Consumer(sharedObj, maxSize), "Consumer");
		prodThread.start();
		consThread.start();

	}

}

class Producer implements Runnable {
	Queue<Integer> sharedObj;
	int maxSize;

	Producer(Queue<Integer> sharedObj, int maxSize) {
		this.sharedObj = sharedObj;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		synchronized (sharedObj) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Produced: " + i);
				try {
					if(sharedObj.size() >= maxSize){
						System.out.println("Queue is FULL : pls wait");
						sharedObj.wait();
					}
					sharedObj.add(i);
					sharedObj.notify();
					
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

			}
		}
	}

}

class Consumer implements Runnable {
	Queue<Integer> sharedObj;
	int maxSize;

	Consumer(Queue<Integer> sharedObj, int maxSize) {
		this.sharedObj = sharedObj;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		synchronized (sharedObj) {
			while(true) {
				try {
					if(sharedObj.isEmpty()){
						System.out.println("Queue is EMPTY : pls wait");
						sharedObj.wait();
					}
					int val = sharedObj.poll();
					System.out.println("Consumed : "+ val);
					sharedObj.notify();
					
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

			}
		}
	}

}
