package com.test.collections1;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashmapExample {

	public static void main(String[] args) {

		// Created HashMap and WeakHashMap objects

		Map hashmapObject = new HashMap();
		Map weakhashmapObject = new WeakHashMap();

		// Created HashMap and WeakHashMap keys

		String hashmapKey = new String("hashmapkey");
		String weakhashmapKey = new String("weakhashmapkey");

		// Created HashMap and WeakHashMap values

		String hashmapValue = "hashmapvalue";
		String weakhashmapValue = "weakhashmapvalue";

		// Putting key and value in HashMap and WeakHashMap Object

		hashmapObject.put(hashmapKey, hashmapValue);
		weakhashmapObject.put(weakhashmapKey, weakhashmapValue);

		// Print HashMap and WeakHashMap Object : Before Garbage Collection

		System.out.println("HashMap before Garbage Collected :" + hashmapObject);
		System.out.println("WeakHashMap before Garbage Collected :" + weakhashmapObject);

		// Set HashMap and WeakHashMap Object keys to null

		hashmapKey = null;
		weakhashmapKey = null;

		// Calling Garbage Collection
		System.gc();

		// Print HashMap and WeakHashMap Object : After Garbage Collection

		System.out.println("HashMap after Garbage Collected :" + hashmapObject);
		System.out.println("WeakHashMap after Garbage Collected :" + weakhashmapObject);

	}

	private static final WeakHashMap<String, WeakReference<String>> s_manualCache = new WeakHashMap<String, WeakReference<String>>(
			100000);

	private static String manualIntern(final String str) {
		final WeakReference<String> cached = s_manualCache.get(str);
		if (cached != null) {
			final String value = cached.get();
			if (value != null)
				return value;
		}
		s_manualCache.put(str, new WeakReference<String>(str));
		return str;
	}

}
