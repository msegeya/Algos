/**
	Question: Get minimum from a stack in O(1).

	Reference: Karumanchi.

	Logic: 
		- For each element insertion make sure the minumum element is at the top of the stack.
*/

import java.util.*;

class StackMinimum {

	Stack<Integer> stack = new Stack<Integer>();
	int minSoFar = -999;

	public static void main(String[] args) {
		StackMinimum smObj = new StackMinimum();
		
		smObj.prepareStackAndPrintMin();
	}

	void prepareStackAndPrintMin() {
		int[] input = {2, 6, 4, 1, 5};
		for(int item : input) {
			printMinAndPush(item);
		}
	}

	void printMinAndPush(int item) {
		if(stack.isEmpty()) {
			stack.push(item);
			System.out.println("Minimum is: " + item);
			minSoFar = item;
		} else {
			if(minSoFar > item) {
				System.out.println("Minimum is: " + item);
				minSoFar = item;
			} else {
				System.out.println("Minimum is: " + minSoFar);
			}
			stack.push(item);
		}
	}
}