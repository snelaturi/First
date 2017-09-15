package com.test.usecases.usecase15;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortingHashMap {

	public static void main(String[] args) {
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("one", "value55");
		map.put("two", "value2");
		map.put("three", "xyz");
		map.put("four", "value3");
		map.put("five", "value5");
		map.put("six", "abc");
		map.put("seven", "value7");
		map.put("eight", "value8");
		
		System.out.println(" values ::  Before sorting  ");
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() +"   " + entry.getValue());
		}
		
		// sorting based on keys 
		List<String> keys = new LinkedList<String>(map.keySet());
		Collections.sort(keys);
		
		Map<String, String> sortedMapKey = new LinkedHashMap<String, String>();
		for (String key : keys) {
			sortedMapKey.put(key, map.get(key));
		}	
		
		System.out.println(" Sorting based on keys   ");
		Set<Entry<String, String>> sortedSet = sortedMapKey.entrySet();
		for (Entry<String, String> entry : sortedSet) {
			System.out.println(entry.getKey() +"   " + entry.getValue());
		}
		
		
		
		// sorting based on values 
		List<Map.Entry<String, String>> entries = new LinkedList<Map.Entry<String, String>>(map.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		Map<String, String> sortedMapValue = new LinkedHashMap<String, String>();
		for (Entry<String, String> entry : entries) {
			sortedMapValue.put(entry.getKey(), entry.getValue());
		}
		
		System.out.println(" Sorting based on Values   ");
		Set<Entry<String, String>> sortedSet1 = sortedMapValue.entrySet();
		for (Entry<String, String> entry : sortedSet1) {
			System.out.println(entry.getKey() +"   " + entry.getValue());
		}
	}
	
	
}


