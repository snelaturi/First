package com.test.thread2;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<E> {
	private List queue = new LinkedList<>();
	private int limit;

	BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object obj) throws InterruptedException {
		if (queue.size() == limit) {
			wait();
		}
		if (queue.isEmpty()) {
			notifyAll();
		}

		queue.add(obj);
	}

	public synchronized Object dequeue() throws InterruptedException {
		if (queue.size() == 0) {
			wait();
		}
		if (queue.size() == limit) {
			notifyAll();
		}
		return queue.remove(0);
	}

	public static void main(String[] args) {

	}

}
