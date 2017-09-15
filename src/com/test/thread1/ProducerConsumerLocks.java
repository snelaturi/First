package com.test.thread1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLocks {

	public static void main(String[] args) {

		ProducerConsumer sharedObj = new ProducerConsumer();
		
		Thread prodThread = new Thread(new Producer(sharedObj), "Producer");
		Thread consThread = new Thread(new Consumer(sharedObj), "Consumer");

		prodThread.start();
		consThread.start();

	}

}

class Producer implements Runnable {

	private ProducerConsumer sharedObj;

	Producer(ProducerConsumer sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		try {
			sharedObj.put();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class Consumer implements Runnable {

	private ProducerConsumer sharedObj;

	Consumer(ProducerConsumer sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		try {
			sharedObj.get();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ProducerConsumer {
	private final Queue<Integer> queue = new LinkedList<Integer>();
	private final Lock aLock = new ReentrantLock();
	private final Condition producerLock = aLock.newCondition();
	private final Condition consumerLock = aLock.newCondition();

	public void put() throws InterruptedException {
		aLock.lock();
		try {
		for (int i = 1; i <=10; i++) {
			if(queue.size() >= 3) {
					System.out.println(Thread.currentThread().getName() + " : Queue is FULL, waiting");
					producerLock.await();
				}
				queue.add(i);
				System.out.println(Thread.currentThread().getName() + " : Produced " + i);
				consumerLock.signalAll();
			}
			} finally {
				aLock.unlock();
			}
	}

	public void get() throws InterruptedException {
		aLock.lock();
		try {
			while (true) {
				if (queue.isEmpty()) {
					System.out.println(Thread.currentThread().getName() + " : Queue is EMPTY, waiting");
					consumerLock.await();
				}
				System.out.println(Thread.currentThread().getName() + " : Consumed " + queue.poll());
				producerLock.signalAll();
			}
		} finally {
			aLock.unlock();
		}
	}

}


