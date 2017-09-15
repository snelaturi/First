package com.test.thread1;

public class StopRunningThread {

	public static void main(String[] args) {
		Some some = new Some();
		Thread t1 = new Thread(new Thread6(some));
		Thread t2 = new Thread(new Thread7(some));

		t1.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		
	}

}


class Some {
	boolean stop = false;
	
	public void running(){
		System.out.println("started..");
		while(!stop){
			System.out.println("executing..");
		}
	}
	
	public void stop(){
		System.out.println("stop executed.. ");
		stop=true;
	}
}

class Thread6 implements Runnable {
    private Some some;
	Thread6(Some some) {
		this.some=some;
	}
	
	@Override
	public void run() {
		some.running();
		
	}
	
}

class Thread7 implements Runnable {
    private Some some;
	Thread7(Some some) {
		this.some=some;
	}
	
	@Override
	public void run() {
		some.stop();
		
	}
	
}