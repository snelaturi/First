package com.test.thread1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.test.Util;

public class ProducerConsumerWithCountDownLatch {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		List<Integer> sharedQueue = new ArrayList<>();
		int max = 4;
		Thread t1 = new Thread(new Producer(sharedQueue, latch));
		Thread t2 = new Thread(new Consumer(sharedQueue, latch));
		t1.start();
		t2.start();

	}

	public static class Producer implements Runnable {
		private List<Integer> queue;
		private CountDownLatch latch;
		private int next = 0;

		public Producer(List<Integer> queue, CountDownLatch latch) {
			this.queue = queue;
			this.latch = latch;
		}

		@Override
		public void run() {
            while(true) {
			synchronized (queue) {
			queue.add(next);
			Util.sleep(1000);
			System.out.println("Produce : " + next +"        latch.getCount()" + latch.getCount());
			latch.countDown();
			}
			next++;
			}
            
		}
	}

	public static class Consumer implements Runnable {
		private List<Integer> queue;
		private CountDownLatch latch;

		public Consumer(List<Integer> queue, CountDownLatch latch) {
			this.queue = queue;
			this.latch = latch;
		}

		@Override
		public void run() {
			while (true) {
			
				Integer num = null;
				synchronized (queue) {
                    if(queue.size() > 0) {
                    	num = queue.remove(queue.size()-1);
                    	Util.sleep(1000);
                    	System.out.println("Consume : " + num);
                    }
				}
				if(num == null) {
					try {
						latch.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

}
