/**
	Source: http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
	Question: Print Zigzag tree both Iteratively as well as Recursively.

	Logic-1: Iteratively
		- We already know how to travel in a tree level by level. ==> PrintLevelByLevel
		- Consider level starting from 1. => If level is odd print from left to right else print from right to left.
		- As we know, we will insert a null after every level.
		- Now, take a stack and insert the left and right of a node if the level is odd. (Since, if the level is odd then we must insert the children of it into the stack because we need to print the next level elements as they are at even level.)
		- When ever you encounter a null we will increment level but before doing that we will check whether the level is even or odd.
		  If even then pop and print all the stack elements.
		- Please look at code comments for more details.

	Logic-2: Recursively
		- We know how to print level by level recursively.
		- We also know how to print level by level from right to left.
		- So now we use the same even/odd logic and while calling the recursive method we will pass a flag whether it has to be printed from left to right or from right to left.
*/

import java.util.*;

class ZigzagPringBT {

	private BTNode root;
	private CBT cbtObj;

	public static void main(String[] args) {
		ZigzagPringBT zbtObj = new ZigzagPringBT();
		zbtObj.prepareTree();

		// Iteratively
		zbtObj.printZigzagBTIter();

 		// Recursively
		zbtObj.printZigzagBTRecur();		
	}

	void prepareTree() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printZigzagBTIter() {
		System.out.println("ITERATIVE: ");
		
		printZigzagOfTreeIter(root);

		System.out.println();
		System.out.println();
	}

	void printZigzagOfTreeIter(BTNode root) {
		Stack<Integer> stack = new Stack<Integer>();
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(root);
		queue.add(null);
		int level = 1;

		while(!queue.isEmpty()) {
			BTNode poppedNode = queue.remove();
			if(null == poppedNode) {
				// even level. So we will print all the elements in the stack.
				if(level % 2 == 0) {
					while(!stack.isEmpty()) {
						System.out.println("Element " + stack.pop() + " is at level " + level);
					}
				}

				level++;
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			} else {

				// If level is odd then we need to print the elements here else we will print them using stack.
				if(level % 2 == 1) {
					System.out.println("Element " + poppedNode.data + " is at level " + level);	
				}
								
				if(null != poppedNode.left) {
					queue.add(poppedNode.left);

					// If level is odd then next level is even and we need next level elements for stack.	
					if(level % 2 == 1) {
						stack.push(poppedNode.left.data);
					}
				}

				if(null != poppedNode.right) {
					queue.add(poppedNode.right);

					// If level is odd then next level is even and we need nect level elements for stack.
					if(level % 2 == 1) {
						stack.push(poppedNode.right.data);
					}
				}
			}
		}
	}

	void printZigzagBTRecur() {
		System.out.println("RECURSION: ");

		int height = BTUtil.getHeight(root);	
		System.out.println("Height of a tree is: " + height);

		boolean evenOddFlag = false; // false is odd, true is even.
		for(int level = 1; level <= height; level++) {
			if(level % 2 == 1) {
				evenOddFlag = false;
			} else {
				evenOddFlag = true;
			}
			printZigzagOfTreeRecur(root, level, evenOddFlag, level);	
		}
	}

	void printZigzagOfTreeRecur(BTNode root, 
									int level,
										boolean evenOddFlag,
											int currentLevel) {
		if(null == root) {
			return;
		}

		if(1 == level) {
			System.out.println("Element " + root.data + " is at level " + currentLevel);
		}

		// if evenOddFlag is false then it is odd level so print from left to right.
		// if evenOddFlag is true then it is odd level so print from right to left.
		if(evenOddFlag == false) {
			printZigzagOfTreeRecur(root.left, level - 1, evenOddFlag, currentLevel);
			printZigzagOfTreeRecur(root.right, level - 1, evenOddFlag, currentLevel);
		} else {
			printZigzagOfTreeRecur(root.right, level - 1, evenOddFlag, currentLevel);
			printZigzagOfTreeRecur(root.left, level - 1, evenOddFlag, currentLevel);
		}
	}

}