/**
	Source: http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	Question: Least common ancestor.

	Logic: (Both Recursive and Iterative logics are same)
		- If the targets are on either sides of the root then root will be the LCA.
		- If the targets are to the left of the root then go to left and do above step.
		- If the targets are to the right of the root then go to right and do step-1
		- Finally return root.
*/

import java.util.*;

class LeastCommonAncestorBST {

	private BST bstObj;
	private BTNode root;

	public static void main(String[] args) {
		LeastCommonAncestorBST lcaObj = new LeastCommonAncestorBST();
		lcaObj.prepareBST();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first element in the tree: ");
		int target1 = scan.nextInt();
		System.out.println("Enter second element in the tree: ");
		int target2 = scan.nextInt();

		// Recursively
		lcaObj.printLCARecur(target1, target2);

		// Iteratively
		lcaObj.printLCAIter(target1, target2);		
	}

	void prepareBST() {
		bstObj = new BST();
		int[] input = {20, 8, 22, 4, 12, 10, 14};
		for(int data : input) {
			root = bstObj.insert(root, data);
		}
		bstObj.print(root);
	}

	void printLCARecur(int target1, int target2) {
		System.out.println("Using RECURSIVE: ");
		BTNode node = getLCARecur(root, target1, target2);
		if(null != node) {
			System.out.println("LCA for " + target2 + " and " + target1 + " is " + node.data);
		} else {
			System.out.println("LCA does not exist.");
		}
	}

	BTNode getLCARecur(BTNode root, 
				int target1, 
					int target2) {
		if(null == root) {
			return null;
		}

		// If both the targets are on the left of the root
		if(target1 < root.data && target2 < root.data) {
			return getLCARecur(root.left, target1, target2);
		}

		// If both the targets are on the right of the root
		if(target1 > root.data && target2 > root.data) {
			return getLCARecur(root.right, target1, target2);
		}

		return root;
	}


	void printLCAIter(int target1, 
							int target2) {
		System.out.println("Using ITERATIVE: ");

		BTNode node = getLCAIter(root, target1, target2);
		if(null != node) {
			System.out.println("LCA for " + target2 + " and " + target1 + " is " + node.data);
		} else {
			System.out.println("LCA does not exist.");
		}
	}

	BTNode getLCAIter(BTNode root,
							int target1,
								int target2) {
		if(null == root) {
			return null;
		}

		while(null != root) {
			if(target1 < root.data && target2 < root.data) {
				root = root.left;
			} else if(target1 > root.data && target2 > root.data) {
				root = root.right;
			} else {
				break;	
			}
		}
		return root;
	}
}