package com.test.usecases.usecase3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerTest2 {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
		
		Thread prodThread = new Thread(new ProducerThread(sharedQueue));
	     Thread consThread = new Thread(new ConsumerThread(sharedQueue));

	     //Starting producer and Consumer thread
	     prodThread.start();
	     consThread.start();

	}
}


class ProducerThread implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    public ProducerThread(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

class ConsumerThread implements Runnable{

    private final BlockingQueue<Integer> sharedQueue;

    public ConsumerThread(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
  
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
               // Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
  
}






