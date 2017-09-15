package com.test.collections1;

public class HashCodeExample {

	public static void main(String[] args) {

		String key = "defgh";
		// java7
		int hashCode = key.hashCode();
		System.out.println("HashCode : " + hashCode);

		int hash = hash7(hashCode);
		System.out.println("hash : " + hash);
		
		System.out.println(" Binary formatj : "+Integer.toBinaryString(hash));

		int index = indexFor7(hash, 16);

		System.out.println("index : " + index);

		// java8

	}

	static int hash7(int h) {
		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		System.out.println("h inside : " + h);
		
		System.out.println("h inside : h >>> 7 -  " + (h >>> 7));
		System.out.println("h inside : h >>> 4 -  " + (h >>> 4));
		
		//System.out.println("h inside : h >>> 4 -  " + (h^ (h >>> 7) ^ (h >>> 4)));
		
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	static int indexFor7(int h, int length) {
		return h & (length - 1);
	}

}
