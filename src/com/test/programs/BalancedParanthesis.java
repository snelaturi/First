package com.test.programs;

import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {

		String value = "{[[[({}{()}())]}";
		//String value ="([((([(([]))])))))])";
	
		Stack<Character> stack = new Stack<>();

		char[] values = value.toCharArray();
		for (char c : values) {
			if (c == '[' || c == '(' || c == '{') {
				stack.push(c);
			}
			else if ((stack.peek() == '(' && c == ')') || (stack.peek() == '[' && c == ']') || (stack.peek() == '{' && c == '}')) {

				stack.pop();
			}

		}
		if (stack.isEmpty()) {
			System.out.println("String having balanced paranthesis..");
		} else {
			System.out.println("Not balanced...");
		}

	}

}
