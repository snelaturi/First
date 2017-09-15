package com.test.thread2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.test.Util;

public class CustomThreadPool {
	private LinkedBlockingQueue<Runnable> taskQueue = null;
	private List<PoolThread> threads = new ArrayList<>();
	private boolean isStopped = false;

	public CustomThreadPool(int noOfThreads, int maxNoOfThreads) {
		this.taskQueue = new LinkedBlockingQueue<>(maxNoOfThreads);
		for (int i = 0; i < noOfThreads; i++) {
			threads.add(new PoolThread(taskQueue));
		}
		for (PoolThread poolThread : threads) {
			Thread t = new Thread(poolThread);
			t.start();
		}
	}

	public synchronized void execute(Runnable task) throws InterruptedException {
		if (this.isStopped)
			throw new IllegalStateException("ThreadPool is stopped");
             
		this.taskQueue.put(task);

	}

	public synchronized void stop() {
		this.isStopped = true;
		for (PoolThread thread : threads) {
			thread.doStop();
		}
	}

	public static void main(String[] args) {
		CustomThreadPool threadPool = new CustomThreadPool(2, 4);
		Runnable r = new Task();
		try {
			threadPool.execute(r);
			threadPool.execute(r);
			threadPool.execute(r);
			threadPool.execute(r);
			threadPool.execute(r);
			threadPool.execute(r);
			threadPool.execute(r);
			Util.sleep(5000);
			threadPool.stop();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("Task : " + Thread.currentThread().getName());

		}

	}

}

class PoolThread implements Runnable {

	private LinkedBlockingQueue<Runnable> taskQueue = null;
	private boolean isStopped = false;

	PoolThread(LinkedBlockingQueue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		while (!isStopped) {
			try {
				Runnable r = taskQueue.take();
				System.out.println(Thread.currentThread().getName() + " has taken task.");
				r.run();
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " has EXECUTED task.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void doStop() {
		this.isStopped = true;
		//Thread.currentThread().interrupt();
	}

	public synchronized boolean isStopped() {
		return isStopped;
	}

}
