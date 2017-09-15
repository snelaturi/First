package com.test.thread1;

public class ThreadsJoin {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Print(10));
		Thread t2 = new Thread(new Print(10));
		Thread t3 = new Thread(new Print(10));
		       t1.start();
		       try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       t2.start();t3.start();
		
	}

}

class Print implements Runnable {
	int max;
	Print(int max){
	  this.max=max;
	}
	
	@Override
	public void run() {
		for(int i=1;i<= max; i++) {
			System.out.print(i + " ");
		}
	}
	
}
