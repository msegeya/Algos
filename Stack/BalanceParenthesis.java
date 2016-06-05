/**
	Question: Balance parenthesis.

	Logic: 
		- For each left parenthesis push it in to the stack.
		- For every right parenthesis pop the top of the stack and see if it is matching the left parenthesis.
		- In the end the stack should be empty then only return true else return false.
*/

import java.util.*;

class BalanceParenthesis {
	public static void main(String[] args) {
		String input = "{()}[]";
		boolean status = match(input);
		if(status) {
			System.out.println(input + " " + "Matched");
		} else {
			System.out.println(input + " " + "Not Matched");
		}
	}

	public static boolean match(String input) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < input.length(); i++) {

			char ch = input.charAt(i);

			if(ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			} else {
				if(isMatched(stack.pop(), ch)) {
					continue;
				} else {
					return false;
				}
			}
		}

		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}

	private static boolean isMatched(char ch1, char ch2) {
		if(ch1 == '(' && ch2 == ')') {
			return true;
		} else if(ch1 == '{' && ch2 == '}') {
			return true;
		} else if(ch1 == '[' && ch2 == ']') {
			return true;
		} else {
			return false;
		}
	}
}