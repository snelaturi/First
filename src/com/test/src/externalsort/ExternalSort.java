package com.test.src.externalsort;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Scanner;

class ArrayContainer  implements  Comparable<ArrayContainer> {
	int[] arr;
	int index;
	public ArrayContainer(int[] arr, int index) {
		this.arr = arr;
		this.index = index;
	}
	@Override
	public int compareTo(ArrayContainer o) {
		return this.arr[this.index] - o.arr[o.index];
	}
}
public class ExternalSort{
	static List<Integer> sortFileData(int []fileData){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < fileData.length; i++){
			list.add(fileData[i]);
		}
		Collections.sort(list);
		System.out.println(list);
		return list;
	}
	public static int[] mergeSortedArray(int[][] arr) {
		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int total=0;
		for (int i = 0; i < arr.length; i++) {
			queue.add(new ArrayContainer(arr[i], 0));
			total = total + arr[i].length;
			
		}
		int m=0;
		int result[] = new int[total];
		while(!queue.isEmpty()){
			ArrayContainer ac = queue.poll();
			result[m++]=ac.arr[ac.index];
			//System.out.println(ac.arr[ac.index]);
			if(ac.index < ac.arr.length-1){
			//	System.out.println(" index " +ac.index + "  " +  (ac.arr.length-1)); 
				queue.add(new ArrayContainer(ac.arr, ac.index+1));
			}
		} 
		return result;
	}
	
	public static void main(String args []) throws FileNotFoundException{
		List<Integer> list = null;
		int arrToSort[][] = new int[10][10];
		for(int i = 0; i < 10; i++){
			String file = "./src/File" + i;
	        Scanner linReader = new Scanner(new File(file));

	        while (linReader.hasNext())
	        {
	            String line = linReader.nextLine();
	            int fileData[] = new int[10];
	    		String arr[] = line.split(" ");
	    		for(int j = 0; j<10; j++){
	    			fileData[j] = Integer.parseInt(arr[j]);
	    		}
	    		list = sortFileData(fileData);	
	    	//	System.out.println(list);
	    		ListIterator<Integer> itr=list.listIterator();  
	    		  
	    		for(int j = 0; j<10; j++){  
	    			arrToSort[i][j] = itr.next();
	    		} 	    		
	        }
    		
	        linReader.close();
		}
		
		int[] result = mergeSortedArray(arrToSort);
		System.out.println(Arrays.toString(result));
	}
}