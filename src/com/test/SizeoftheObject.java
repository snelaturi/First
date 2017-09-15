package com.test;

public class SizeoftheObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();*/
		
		long before = Runtime.getRuntime().freeMemory();
		System.out.println(before);
		System.gc();
		AA obj = new AA();
    	/*Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		Object obj4 = new Object();*/
		
		/*System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();s
		System.gc();
		System.gc();*/
		
		long after = Runtime.getRuntime().freeMemory();
		System.out.println(after);
		
		long result = after-before;
		System.out.println(result);
		byte d = (byte)result;
		System.out.println(d);
		
		
	}

}

class AA{
	
}
