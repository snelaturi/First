package com.sapient;

public class ImmutableClass {

	public static void main(String[] args) throws InterruptedException {

		Super obj = new Sub();
		// obj.clone();
		// double value = 6/2(1+2);
		// System.out.println(value);

	}

}

class Super {
	private int a = 10;
}

class Sub extends Super {
	public void m1() {
		System.out.println("Super");
	}
}
