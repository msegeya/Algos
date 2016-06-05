/**
	Question: Reverse Stack using recursion.

	Logic: (Use tail recursion)
		- First go until the last element in the stack is popped. 
		- Now push each element in to the stack in such a way that for every new element we need to pop the old elements and push the new element and then push back the old elements.
		- See the code for more details.
*/

import java.util.*;

class ReverseStack {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4};
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1); stack.push(2); stack.push(3); stack.push(4); 
		reverseStack(stack);
	}

	public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}

		int pop = stack.pop();
		reverseStack(stack);

		// finally print the stack in reverse.
		pushIntoStack(stack, pop);
	}

	public static void pushIntoStack(Stack<Integer> stack, int item) {
		if(stack.isEmpty()) {
			stack.push(item);
		} else {
			int pop = stack.pop();
			pushIntoStack(stack, item);
			
			stack.push(pop);
		}
	}
}