package com.test.strings1;

import java.util.StringJoiner;

public class StringsExample {

	public static void main(String[] args) {

		//StringJoiner sj = new StringJoiner(",");
		StringJoiner sj = new StringJoiner(",","Prefix-","-Suffix");
		sj.add("abc");
		sj.add("xyz");
		sj.add("def");
		
		System.out.println(sj.toString());
		
		
		String s1 = new String("bcd");
		String s2 = new String("bcd");
		s1=s1.intern();
		String s3 = "bcd";
		System.out.println(s1 ==  s2);
		
		System.out.println(s1 ==  s3);
		
		
	}

}
