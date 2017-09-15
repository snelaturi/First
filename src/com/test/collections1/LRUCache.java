package com.test.collections1;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, String>{
    int capacity;
	public LRUCache(int capacity, float loadFactor){
	      super(capacity, loadFactor, true);
	      this.capacity = capacity;
	   }
	    
	   /**
	    * removeEldestEntry() should be overridden by the user, otherwise it will not 
	    * remove the oldest object from the Map.
	    */
	   @Override
	   protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest){
	      return size() > this.capacity;
	   }
	public static void main(String[] args) {
		System.out.println("available processors : "+ Runtime.getRuntime().availableProcessors());
		LRUCache lruCache = new LRUCache(4,0.75f);
		lruCache.put(1, "Object1");
	      lruCache.put(2, "Object2");
	      lruCache.put(3, "Object3");
	      lruCache.get(1);
	      lruCache.put(4, "Object4");
	      System.out.println(lruCache);
	      lruCache.put(5, "Object5");
	      lruCache.get(3);
	      lruCache.put(6, "Object6");
	      System.out.println(lruCache);
	      lruCache.get(4);
	      lruCache.put(7, "Object7");
	      lruCache.put(8, "Object8");
	      System.out.println(lruCache);

	}

}
