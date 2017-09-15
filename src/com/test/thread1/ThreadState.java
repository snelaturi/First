package com.test.thread1;

public class ThreadState {

	public static void main(String[] args) {
		
	 Thread t1 = new Thread(new Thread1(),"MyThread1");
	 System.out.println(t1.getState().name());
	 t1.start();
	 System.out.println(t1.getState().name());
	 t1.interrupt();
	 System.out.println(t1.getState().name());
	 System.out.println(" After notify call");
	}

}

class Thread1 implements Runnable {

	@Override
	public void run() {
		
		System.out.println("run method = Start");
		System.out.println(Thread.currentThread().getName());
		try {
			 //wait();
			 //wait(10000);
			 Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("run method = End");
		
	}
	
}
