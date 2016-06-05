/**
	Source:
		http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
		http://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/
		http://stackoverflow.com/questions/12052192/printing-ancestors-of-a-node-in-binary-tree

	Logic-1: Recursion
		- We will control the printing of the ancestors using boolean-if condition.
		- So when the target is reached we will return false so that all the previous if-conditions gets true for this path and prints the path.
		- See code for more details.

	Logic-2: Iterative
		- Difficult logic. We can use stack to perform the above task.
		- Traverse all the way to left most node of the tree. While traversing insert all the encountered elements into the stack.
		- When you reach the left most and if still the target element is not found then check if the left most node have any right children.
		  If right children does not exist then we can ignore it by popping of the stack.
		- If right children present then there is chance that it may exist so we need to push it into the stack and continue the procedure.
		- The moment we encounter the target node then just print all the elements in the stack. That gives us the path.
		- Else continue until the stack and the root are null.
*/

import java.util.*;

class PrintAllAncestors {

	private CBT cbtObj;
	private BTNode root;

	public static void main(String[] args) {
		PrintAllAncestors paObj = new PrintAllAncestors();
		paObj.prepareCBT();

		System.out.println("Enter the target node value: ");
		Scanner scan = new Scanner(System.in);
		int target = scan.nextInt();

		paObj.printAncesRecur(target);

		paObj.printAncesIter(target);	
	}

	void prepareCBT() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printAncesRecur(int target) {
		System.out.println("Using Recursion: ");
		boolean status = printAllAncesUsingRecur(root, target);
		if(!status) {
			System.out.println("Target element does not exist.");
		}
		System.out.println();
	}

	boolean printAllAncesUsingRecur(BTNode root, 
										int target) {
		if(null == root) {
			return false;
		}

		if(target == root.data) {
			return true;
		}

		// When the target is reached the above code returns true.
		// When the below condition is true we will return the true to previous calls such that all these calls also gets printed.
		if( (printAllAncesUsingRecur(root.left, target)) || 
				(printAllAncesUsingRecur(root.right, target)) ) {
			System.out.print(root.data + " -> ");
			return true;
		}

		return false;
	}

	void printAncesIter(int target) {
		System.out.println("Using Iterative: ");
		Stack<BTNode> stack = getAncesIter(root, target);

		if(null != stack && !stack.isEmpty()) {
			while(null != stack && !stack.isEmpty()) {
				System.out.print(stack.pop().data + " -> ");
			}			
		} else {
			System.out.println("Target element does not exist.");
		}
	}	

	Stack<BTNode> getAncesIter(BTNode root, 
									int target) {
		if(null == root) {
			return null;
		}

		Stack<BTNode> stack = new Stack<BTNode>();

		while(true) {
			// Traverse towards left and insert all nodes until we find the target.
			// We need to push elements because we will need to traverse right child also if the target is not in the left.
			while(null != root && root.data != target) {
				stack.push(root);
				root = root.left;
			}

			// If the element is found then we need to print the path which we came from that is "stack contents."
			if(null != root && root.data == target) {
				break;
			}

			// Now if we reach the left most node of the tree then what?
			// If the left most node has right children then we need to check that sub-tree also.
			// And if the right child does not exist then we don't need this => As it is leaf and not element in its path so we can pop it from the stack.
			if(!stack.isEmpty() && null == stack.peek().right) {
				root = stack.pop();

				// Remember we have already processed left of the tree (Note down this for below explanation.)
				// If the popped element is the right child of the top then we need to pop the top too.
				// Simple, we have already processed left children and the right children also. As the target does not exist in this path
				// so we can ignore until the root.
				while(!stack.isEmpty() && stack.peek().right == root) {
					root = stack.pop();
				}
			}

			// If the right children exist then we need to push it into the stack.
			// So set the root to right and continue the while loop.
			if(!stack.isEmpty()) {
				root = stack.peek().right;	
			} else {
				root = null;
			}

			if(stack.isEmpty() && null == root) {
				break;
			}
		} // end of infinite-while loop.

		return stack;
	}
}