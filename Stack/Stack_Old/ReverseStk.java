/**
	Question: Reverse stack in-place using only push and pop operations.

	Reference: http://prismoskills.appspot.com/lessons/Programming_Puzzles/Reverse_a_stack_in_place.jsp
*/

import java.util.*;

class ReverseStk {
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5};
		Stack<Integer> stack = createStack(input);

		reverseStack(stack);
		printStack(stack, "After Reversing Stack");
	}

	static Stack<Integer> createStack(int[] input) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int item : input) {
			stack.push(item);
		}

		return stack;
	}

	/**
		Go until the last element and then start to insert from the last element using pushItemAtBottom method.
	*/
	static void reverseStack(Stack<Integer> stack) {

		int popItem = stack.pop();

		// recursively fo until there is one element.
		if(stack.size() != 1) {
			reverseStack(stack);
		}

		pushItemAtBottom(popItem, stack);
	}

	/**
		The element that is inserted first should be at the top for every element that is pushed in to the stack.
	*/
	static void pushItemAtBottom(int item, Stack<Integer> stack) {
		// get top
		int top = stack.pop();

		// if stack is empty then push the element.
		if(stack.size() == 0) {
			stack.push(item);
		} else {
			pushItemAtBottom(item, stack);
		}

		// finally push back the top again as the top most most element.
		stack.push(top);
	}

	static void printStack(Stack<Integer> stack, String msg) {
		System.out.println(msg);
		System.out.println();
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}