package com.test.thread1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SearchNumber {

	public static void main(String[] args) {
		int[] myArray= new int[1000000];
		for(int i =0; i <1000000 ;i++) {
			myArray[i] = new Random().nextInt(1000000);
		}
		
		System.out.println(myArray.length);
		//System.out.println(myArray[67]);
		//System.out.println(myArray[678888]);

		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		Worker[] workers = new Worker[10];

        int range = myArray.length / 10;
        for (int index = 0; index < 10; index++) {
            int startAt = index * range;
            int endAt = startAt + range;
            workers[index] = new Worker(startAt, endAt, myArray,148);
        }

        try {
            List<Future<Integer>> results = executor.invokeAll(Arrays.asList(workers));
            for (Future<Integer> future : results) {
                System.out.println("search object : "+future.get());
            }
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

	}

}

class Worker implements Callable<Integer> {

    private int startAt;
    private int endAt;
    private int numbers[];
    private int searchVal;


    public Worker(int startAt, int endAt, int[] numbers, int searchVal) {
        this.startAt = startAt;
        this.endAt = endAt;
        this.numbers = numbers;
        this.searchVal=searchVal;
    }

    @Override
    public Integer call() throws Exception {
        int max = Integer.MIN_VALUE;
        for (int index = startAt; index < endAt; index++) {
           if(numbers[index] == searchVal) {
        	  System.out.println("find val index : "  + Thread.currentThread().getName() +" "+ index );
        	  return searchVal;
           }
        }
        return max;
    }

}


