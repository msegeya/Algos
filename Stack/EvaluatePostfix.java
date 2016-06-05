/**
	Question: Evaluate Post fix expression.
	
	Logic: 
		- If the input is operand then push it in to the stack.
		- If the input is operator then do the arthimetic operation and push it into the stack.
*/

import java.util.*;

class EvaluatePostfix {
	public static void main(String[] args) {
		String input = "231*+9-"; // output: -4
		evaluate(input);
	}

	public static void evaluate(String input) {
		Stack<Integer> stack = new Stack<Integer>();

		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			// If the character is digit then push it to the stack.
			if(Character.isDigit(ch)) {
				stack.push((int) (ch - '0'));
			} else {
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch(ch) {
					case '+': stack.push(val2 + val1); break;
					case '-': stack.push(val2 - val1); break;
					case '*': stack.push(val2 * val1); break;
					case '/': stack.push(val2 / val1); break;
				}
			}
		}

		System.out.println("For expression " + input + " postfix result is " + stack.pop());
	}
}