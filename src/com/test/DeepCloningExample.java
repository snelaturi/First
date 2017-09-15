package com.test;

public class DeepCloningExample {

	public static void main(String[] args) {

		AAA a1 = new AAA();
		AAA a2 = null;
		try {
			a2 = (AAA) a1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println(a1.b==a2.b);
	}

}

class AAA implements Cloneable {
	
	int a;

	BBB b;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		AAA a1 = new AAA();
		a1.b= new BBB();
		return a1;
	}

}

class BBB {
	int b;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}