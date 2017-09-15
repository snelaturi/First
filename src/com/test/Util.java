package com.test;

public class Util {

	public static void sleep(long mseconds) {
		try {
			Thread.currentThread().sleep(mseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
