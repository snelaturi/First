package com.test.usecases.usecase4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {
	 
    private BlockingQueue<Runnable> taskQueue;
    private boolean poolShutDownInitiated = false;
    
    public ThreadPool(int nThreads){
        taskQueue = new LinkedBlockingQueue<Runnable>(nThreads);
 
        for(int i=1; i<=nThreads; i++){
           ThreadPoolsThread threadPoolsThread=new ThreadPoolsThread(taskQueue,this);
         threadPoolsThread.setName("Thread-"+i);
         System.out.println("Thread-"+i +" created in ThreadPool.");
         threadPoolsThread.start();   
        }
    }
   
    public synchronized void  execute(Runnable task) throws Exception{
        if(this.poolShutDownInitiated)
           throw new Exception("ThreadPool has been shutDown, no further tasks can be added");
 
        System.out.println("task has been added.");
        this.taskQueue.put(task);
    }
 
 
    public boolean isPoolShutDownInitiated() {
           return poolShutDownInitiated;
    }
 
 
    public synchronized void shutdown(){
       this.poolShutDownInitiated = true;
        System.out.println("ThreadPool SHUTDOWN initiated.");
    }
 
}

class ThreadPoolsThread extends Thread {
 
    private BlockingQueue<Runnable> taskQueue;
    private ThreadPool threadPool;
 
    public ThreadPoolsThread(BlockingQueue<Runnable> queue,
                  ThreadPool threadPool){
        taskQueue = queue;
        this.threadPool=threadPool;
       
    }
 
    public void run() {
           try {
                 
                  while (true) {    
                        System.out.println(Thread.currentThread().getName()
                                      +" is READY to execute task.");
                        Runnable runnable = taskQueue.take();
                        System.out.println(Thread.currentThread().getName()
                                      +" has taken task.");
                        runnable.run();                
                        
                        System.out.println(Thread.currentThread().getName()
                                      +" has EXECUTED task.");
                        
                        if(this.threadPool.isPoolShutDownInitiated()
                                      &&  this.taskQueue.size()==0){
                               this.interrupt();
                        }
                        
                  }
           } catch (InterruptedException e) {
                  System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
           }
    }
}

class Task implements Runnable{  
    @Override
    public void run() {
           try {
                  System.out.println(Thread.currentThread().getName()
                               +" is executing task.");
           } catch (Exception e) {
                  e.printStackTrace();
           }
    }
};
 

public class ThreadPoolTest{
    public static void main(String[] args) throws Exception {
           ThreadPool threadPool=new ThreadPool(2); 
           Runnable task=new Task();
           threadPool.execute(task);
           threadPool.execute(task);
           
           threadPool.shutdown();
    }
}