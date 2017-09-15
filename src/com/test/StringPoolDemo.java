package com.test;

public class StringPoolDemo {

	public static void main(String[] args) {

		/*String s1="aBc";
		String s2="Abc";
		
		if(s1==s2) {
			System.out.println("s1==s2 :: TRUE" );
		}
		
		String s3 = new String("abc");
		s3 = s3.intern();
		
		if(s1==s3) {
			System.out.println("s1==s3 :: TRUE" );
		} else {
			System.out.println("s1==s3 :: FALSE" );
		}*/
		
		String s1 = new String("abc");
		String s2=s1.intern();
		String s3 = "abc";
		
		if(s1==s2) {
			System.out.println("Both are equla : ");
		}
		
		if(s2==s3) {
			System.out.println("Both are equla : ");
		}
		
		
		
		
	}

}
