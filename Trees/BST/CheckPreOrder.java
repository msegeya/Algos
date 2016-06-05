/**
	Question: Given preorder array check whether the given array is a BST or not.

	Reference: http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/

	Logic: Simple line to remember. If a is present to the right of the root but is smaller than root then it is not a BST.
		1) Create an empty stack.
	 	2) Initialize root as INT_MIN.
		3) Do following for every element pre[i]
		     a) If pre[i] is smaller than current root, return false.
		     b) Keep removing elements from stack while pre[i] is greater
		        then stack top. Make the last removed item as new root (to
		        be compared next).
		        At this point, pre[i] is greater than the removed root
		        (That is why if we see a smaller element in step a), we 
		        return false)
		     c) push pre[i] to stack (All elements in stack are in decreasing
		        order)  
*/

import java.util.*;

class CheckPreOrder {

	public boolean isPreOrder(int[] pre) {
		Stack<Integer> stack = new Stack<Integer>();
		int root = Integer.MIN_VALUE;

		for(int data : pre) {
			// Ex: {40, 30, 35, 20, 80, 100}			
			// As per BST, for a root its right has to be greater and left has to be lesser that it.
			// If less is on the right then we will return false.
			// In the array above, 20 must come to the left of 30 which means 20 must come right after 30 but not after the right node of 30.
			if(data < root) {
				return false;
			}

			// Since as per the preorder logic (Root-Left-Right). 
			// If a smaller value is encountered compared to the top of the stack then to will be the root the current element might be the right of the root.
			// So we will make the top of the stack as root and pop it.
			while(!stack.isEmpty() && stack.peek() < data) {
				root = stack.pop();
			}

			// Push the current element into the queue.
			stack.push(data);
		}

		return true;
	}
}