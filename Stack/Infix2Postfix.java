/**
	Question: Convert Infix to Postfix expression.
	
	Logic: 
		- Please go through code comments.
*/

import java.util.*;

class Infix2Postfix {

	public static void main(String[] args) {
		String input = "a+b*(c^d-e)^(f+g*h)-i"; // output: "abcd^e-fgh*+^*+i-"
		convert(input);
	}

	public static void convert(String input) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i< input.length(); i++) {
			char ch = input.charAt(i);

			// If left parenthesis then push in to the stack.
			if(ch == '(') {
				stack.push(ch);
			// If operand then add it to the output string.
			} else if(Character.isLetter(ch)) {
				builder.append(ch);
			// If right parenthesis then pop until left parenthesis is encountered.
			} else if(ch == ')') {
				// pop all the elements in the stack until stack is empty or we get '('
				while(!stack.isEmpty() && stack.peek() != '(') {
					char pop_ch = stack.pop();
					builder.append(pop_ch);
				}

				// If we did not encounter the closing bracket then the input is not correct so return.
				if(stack.isEmpty() || stack.peek() != '(') {
					System.out.println("Expression is not formatted correctly.");
					return;
				} else {
					stack.pop(); // If the input is correct then just pop.					
				}
			} else {
				// If the input is an operator the we need to check the precedence of the operator.
				// If the current operator is having precedence which is less than the previous operaors 
				// then pop the previous operators.
				if(!stack.isEmpty()) {
					while(!stack.isEmpty() && (precedence(ch) <= precedence(stack.peek()))) {
						builder.append(stack.pop());
					}
				}

				// finally push the current operator back to stack.
				stack.push(ch);
			}
		} // for loop

		// finally append all the operators that are left in the stack.
		while(!stack.isEmpty()) {
			builder.append(stack.pop());
		}

		System.out.println(input + " postfix string is " + builder.toString());
	}


	public static int precedence(char ch) {
		switch(ch) {
			case '+':
			case '-':
				return 1;

			case '*':
			case '/':
				return 2;

			case '^':
				return 3;
		}
		return -1;
	}
}