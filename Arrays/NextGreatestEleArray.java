/**
	Question: Next Greatest Element in a array.

	Reference: http://www.geeksforgeeks.org/next-greater-element/

	Logic: 
		- 
*/

import java.util.Stack;
import java.util.Iterator;

class NextGreatestEleArray {
	public static void main(String[] args) {
		int[] array = {11, 13, 21, 3};
		Stack<Integer> stack = new Stack<Integer>();

		for(int i = 0; i < array.length; i++) {
			int element = array[i];

			if(!stack.isEmpty()) {
				int peek = stack.peek();

				while(peek < element) {
					System.out.println("Next Greatest Element for " + peek + " is " + element);

					// delete the element if the current element is the greatest element for this one.
					stack.pop();

					// get the next element in the stack if the stack is not empty.
					if(!stack.isEmpty()) {
						peek = stack.peek();
					} else {
						break;
					}
				}
			}

			// System.out.println("Pushing element = " + element);
			// Always push the current element in to the stack.
			stack.push(element);
		}

		// Iterate through all the remaining elements and assign next-greater-element as -1.
		Iterator<Integer> iter = stack.iterator();
		while(iter.hasNext()) {
			System.out.println("Next Greatest Element for " + iter.next() + " is " + -1);
		}
	}
}