/**
	Question: Give an algorithm for finding duplicate parenthesis in a expression.

	Reference: https://www.careercup.com/question?id=5978736570662912

	Example: ((a + b) * ((c + d)))
			Here we have duplicate parenthesis around "c + d". 
			NOTE: The overall braces are valid.

	Logic:
		- Take a stack.
		- Push all the characters until you reach ')'.
		- When the current char is ')' and stack top is '(' then this is a "DUPLICATE PARENTHESIS". Why? See code comments.
		- Else pop until you get '('.

	NOTE: Removing the duplicate expression is easy. Take an array and keep track of the index that are pushed in to the stack. So when there is a duplicate we already know the current index (since we are suing for loop) ans also we know the stack index of that character.
	Finally convert the expression into string-builder and delete the elements present at that index.
*/

import java.util.Stack;

class DuplicateParenthesis {
	public static void main(String[] args) {
		// String expr = "((a+b)*((c+d)))"; // true. Has Duplicates.
		// String expr = "(a + b) * (c + d)"; // false. No Duplicates.
		String expr = "( (a + b) * (c + d) )"; // true. Has Duplicates.

		if(isDuplExp(expr)) {
			System.out.println("Has Duplicate Parenthesis.");
		} else {
			System.out.println("Does NOT have Duplicate Parenthesis.");
		}
	}

	public static boolean isDuplExp(String expr) {
		Stack<Character> stack = new Stack<Character>();

		for(int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);

			// If you have space(s) in the expression then ignore them. Don't push them into the stack.
			if(ch == ' ') {
				continue;
			} else if(ch != ')') {
				stack.push(ch);
			} else {
				char pop_ch = stack.pop();
				if(pop_ch == '(') {
					return true;
				} else {
					while(pop_ch != '(') {
						pop_ch = stack.pop();
					}
				}
			}
		}

		return false;
	}
}