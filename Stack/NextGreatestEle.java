/**
	Question: Next greatest element. 

	Reference: http://www.crazyforcode.com/greater-element-array/

	Logic: 
		- For every element on the top of the stack check whether there is any other on the right which is greater than this element or not. Print the one that is close to the current element.
		- Push the first element into the stack. 
		- Now for every next element check the top of the stack,
			- If the top is less than the current element then print current as next greatest. And continue for next top of stack.
			- Finally if it is less then push it in to the stack.
*/

import java.util.*;

class NextGreatestEle {
	public static void main(String[] args) {
		int[] array = {11, 3, 13, 21, 3};
		// int[] array = {11, 13, 21, 25};
		nextGreatest(array);
	}

	// NOTE: For last elements there are no elements present on the right so there will be no next greatest element.
	public static void nextGreatest(int[] array) {
		Stack<Integer> stack = new Stack<Integer>();

		for(int i = 0; i < array.length; i++) {

			int current = array[i];

			if(!stack.isEmpty()) {
				int prev = stack.pop(); // get the top of the stack.

				while(current > prev) {
					System.out.println(prev + " -> " + current);
					
					if(stack.isEmpty()) {
						break;
					}

					prev = stack.pop();
				}

				// if the current element is less than the stack top element then push it back.
				if(current < prev) {
					stack.push(prev);
				}
			} 

			// push the element in to stack such that we can find the next greatest element for this one.
			stack.push(current);
		}

		// If there are elements that are not having any greatest elements.
		// then print -1 for them.
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + " -> " +  " -1 ");
		}
	}
}