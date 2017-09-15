package com.test.ds;

import java.util.LinkedList;
import java.util.Stack;

public class StacktoQueue {

	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<>();
		
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1); stack.push(2); stack.push(3);stack.push(4);
		
		Stack<Integer> stack1 = new Stack<>();
		
		while(!stack.isEmpty()){
			//System.out.println(stack.size());
			//stack1.push(stack.pop());
			System.out.println(stack1.push(stack.pop()));
		}
		
		System.out.println("==== Queue");
		
		while(!stack1.isEmpty()){
			//System.out.println(stack.size());
			//stack1.push(stack.pop());
			System.out.println(stack1.pop());
		}
		
		//System.out.println(stack.size());
		
		
	}
}


