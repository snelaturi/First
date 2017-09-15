package com.test.usecases.usecase7;

import java.util.Scanner;

public class FibonacciNumber {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		int n = new Scanner(System.in).nextInt();
		fibonacciNumberSeries(n);

		for (int i = 1; i <= n; i++) {
			int val = fibonacciUsingRecursive(i);
			System.out.println(val + " ");
		}
	}

	private static void fibonacciNumberSeries(int n) {

		int first = 0;
		int second = 1;
		int num = 0;

		for (int i = 0; i < n; i++) {
			first = second;
			second = num;
			num = first + second;
			System.out.print(num + " ");

		}
	}

	private static int fibonacciUsingRecursive(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		return fibonacciUsingRecursive(n - 1) + fibonacciUsingRecursive(n - 2);

	}

}
