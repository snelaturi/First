package com.test.thread1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.test.Util;

public class CallableExample {

	public static void main(String[] args) {
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		List<Future<Long>> resultList = new ArrayList<>();
		
		for(int i=1; i<=30 ; i++ ) {
			//Integer number = random.nextInt(i);
			FactorialNumber calculator  = new FactorialNumber(i);
            Future<Long> result = executor.submit(calculator);
            resultList.add(result);
		}
		
		for (Future<Long> future : resultList) {
			try {
				System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();

	}

}

class FactorialNumber implements Callable<Long> {
	private Integer number;

	FactorialNumber(Integer number) {
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		Util.sleep(1000);
		System.out.println("" + Thread.currentThread().getName());
		long result = 1;
		if (number == 0 || number == 1) {
			return result;
		} else {
			for (int i = 2; i <= number; i++) {
				result = result * i;
			}
		}
		System.out.println("Result for number - " + number + " -> " + result);
		return result;
	}

}
