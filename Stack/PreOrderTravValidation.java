/**
	Question: Validate Preorder.

	Logic: (A bit tricky logic but implementation is simple.)
		- Initialize the root to MIN_VALUE.
		- Two conditions,
			1) If the current value in array is less than then root then return false. Since if it is less than its root then it has to come first than the root.
			2) If current element is on the right of the stack then remove all the elements that are less than the current element from the stack and make the last removed one as the root.
		- Finally push the current element into the stack.

*/
import java.util.*;

class PreOrderTravValidation {
	public static void main(String[] args) {
		int[][] pre = {
							{2, 4, 3},
							{2, 4, 1},
							{40, 30, 35, 80, 100}
					  };					
		for(int i = 0; i < pre.length; i++) {
			validatePreorder(pre[i]);	
		}
		
	}

	public static void validatePreorder(int[] pre) {
		Stack<Integer> stack = new Stack<Integer>();

		int root = Integer.MIN_VALUE;
		boolean status = true;

		for(int i = 0; i < pre.length; i++) {
			// If we find an element which is small but present on the right side of the root then return false;
			// Since if it is small than root then it has to come first before root.
			if(pre[i] < root) {
				status = false;
			} else {
				// If the current element is on the right of the root then we can delete all the elements less than this.
				while(!stack.isEmpty() && pre[i] > stack.peek()) {
					root = stack.pop();
				}

				stack.push(pre[i]);
			}
		}

		if(status) {
			System.out.println("Valid Preorder.");	
		} else {
			System.out.println("Not a Valid Preorder.");
		}
		
	}
}