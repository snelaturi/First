package com.test.usecases.usecase16;

import java.util.Arrays;
import java.util.TreeSet;

public class LargestElement {

	public static void main(String[] args) {

		int[] input = new int[] { 5, 8, 79, 54, 21, 85, 4, 2, 87, 487 };
				
		printFirstAndSecondLargestElement(input);
		printNthLargestElement(input);
	}

	private static void printFirstAndSecondLargestElement(int[] input) {

		int first = input[0];
		int second = input[0];
		for (int i = 1; i < input.length; i++) {
			if (first < input[i]) {
				second = first;
				first = input[i];
			} else if (first < second) {
				second = input[i];
			}
		}
		System.out.println("First largest value : " + first);
		System.out.println("Second largest value : " + second);

	}

	private static void printNthLargestElement(int[] input) {
		Arrays.asList(input);
		TreeSet<Integer> tset = new TreeSet<>();
  
	}
}
