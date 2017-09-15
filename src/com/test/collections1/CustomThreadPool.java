package com.test.collections1;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

	public static void main(String[] args) throws Exception {

		ThreadPool threadPool=new ThreadPool(2); //create 2 threads in ThreadPool 
        Runnable task=new Thread();
        threadPool.execute(task);
        threadPool.execute(task);
        
        threadPool.shutdown();
		
	}

}

class ThreadPoolsThread extends Thread {

	private LinkedBlockingQueue<Runnable> taskQueue;
	private ThreadPool threadPool;

	ThreadPoolsThread(LinkedBlockingQueue<Runnable> taskQueue, ThreadPool threadPool) {
		this.taskQueue = taskQueue;
		this.threadPool = threadPool;
	}

	@Override
	public void run() {
		try {

			while (true) {
				System.out.println(Thread.currentThread().getName() + " is READY to execute task.");
				// ThreadPool's thread will take() task from sharedQueue only if
				// tasks are available else
				// waits for tasks to become available.
				Runnable runnable = taskQueue.take();
				System.out.println(Thread.currentThread().getName() + " has taken task.");
				// Now, execute task with current thread.
				runnable.run();

				System.out.println(Thread.currentThread().getName() + " has EXECUTED task.");

				/*
				 * 1) Check whether pool shutDown has been initiated or not, if
				 * pool shutDown has been initiated and 2) taskQueue does not
				 * contain any unExecuted task (i.e. taskQueue's size is 0 )
				 * than interrupt() the thread.
				 */
				if (this.threadPool.isPoolShutDownInitiated() && this.taskQueue.size() == 0) {
					this.interrupt();
					/*
					 * Interrupting basically sends a message to the thread
					 * indicating it has been interrupted but it doesn't cause a
					 * thread to stop immediately,
					 * 
					 * if sleep is called, thread immediately throws
					 * InterruptedException
					 */
					Thread.sleep(1);
				}
			}

		} catch (Exception e) {
		}
	}

}

class ThreadPool {
	private LinkedBlockingQueue<Runnable> taskQueue;

	// Once pool shutDown will be initiated, poolShutDownInitiated will become
	// true.

	private boolean poolShutDownInitiated = false;

	/*
	 * Constructor of ThreadPool nThreads= is a number of threads that exist in
	 * ThreadPool. nThreads number of threads are created and started. *
	 */
	public ThreadPool(int nThreads) {
		taskQueue = new LinkedBlockingQueue<Runnable>(nThreads);

		// Create and start nThreads number of threads.
		for (int i = 1; i <= nThreads; i++) {
			ThreadPoolsThread threadPoolsThread = new ThreadPoolsThread(taskQueue, this);
			threadPoolsThread.setName("Thread-" + i);
			System.out.println("Thread-" + i + " created in ThreadPool.");
			threadPoolsThread.start(); // start thread
		}

	}

	/**
	 * Execute the task, task must be of Runnable type.
	 */
	public synchronized void execute(Runnable task) throws Exception {
		if (this.poolShutDownInitiated)
			throw new Exception("ThreadPool has been shutDown, no further tasks can be added");

		/*
		 * Add task in sharedQueue, and notify all waiting threads that task is
		 * available.
		 */
		System.out.println("task has been added.");
		this.taskQueue.put(task);
	}

	public boolean isPoolShutDownInitiated() {
		return poolShutDownInitiated;
	}

	/**
	 * Initiates shutdown of ThreadPool, previously submitted tasks are
	 * executed, but no new tasks will be accepted.
	 */
	public synchronized void shutdown() {
		this.poolShutDownInitiated = true;
		System.out.println("ThreadPool SHUTDOWN initiated.");
	}
}
