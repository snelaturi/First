package com.test.collections1;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomFixedThreadPool {

	public static void main(String[] args) {
		
		

	}

}

class ThreadPool1 {
	  LinkedBlockingQueue<Runnable> taskQueue;
	  int size;
	  boolean shutdown;
	  ThreadPool1(int size){
		  this.size=size;
		  taskQueue = new LinkedBlockingQueue<>(size);
		  for(int i =1; i<=size; i++ ) {
			 Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					while(!shutdown) {
				       try {
						Runnable r = taskQueue.take();
				         r.run();
					   } catch (InterruptedException e) {
						e.printStackTrace();
					}    		
					}
				}
			});
			 t.run();
		  }
	  }
	  
}
