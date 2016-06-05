/**
	Question: Sort the stack by only using Recursion.

	Logic: Same as Reversing stack refer ReverseStack.java
*/

import java.util.*;

class SortStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(30); stack.push(-5); stack.push(18); stack.push(14); stack.push(-3); 
		sortStack(stack);

		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + "\t");
		}
	}

	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		} else {
			int pop = stack.pop();
			sortStack(stack);

			performSorting(stack, pop);
		}
	}

	public static void performSorting(Stack<Integer> stack, int data) {
		// If stack is empty then just push the data into the stack.
		if(stack.isEmpty()) {
			stack.push(data);
		} else if(data > stack.peek()) { // if the new data is greater than stack top then just push data into the stack.
			stack.push(data);
		} else {
			int temp = stack.pop();
			performSorting(stack, data);

			stack.push(temp);
		}
	}
}