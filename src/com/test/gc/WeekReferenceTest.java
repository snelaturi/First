package com.test.gc;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

public class WeekReferenceTest {

	public static void main(String[] args) {
		
	 A a1 = new A();
	
	 WeakReference<A> weak = new WeakReference<A>(a1);
	 a1=null;
	 B b1 = new B();
	 
	 WeakReference<B> weak1 = new WeakReference<B>(b1);
	 b1=null;
	 
	 WeakHashMap map = new WeakHashMap();
	 map.put(a1, "object A");
	 
	 HashMap map1 = new HashMap<>();
	 
	 map1.put(b1,"Object B");

	 System.out.println(map.size());
	 
	 for(int i =0; i<1000 ;i++) {
		 Runtime.getRuntime().gc();
	 }
	 
	 System.out.println(map.size());
	 
	 Iterator itr = map.keySet().iterator();
	 
	 
	 //while(itr.hasNext()) {
		 System.out.println(map.get(a1));
		 System.out.println(map1.get(b1));
	// }
	 
	 
	}

}

class A {
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("A");
		//super.finalize();
	}
}

class B{
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("B");
		//super.finalize();
	}
}
