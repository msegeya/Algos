/**
	Source: https://www.youtube.com/watch?v=5cPbNCrdotA (I have used my own logic here. This link is just for reference.)
	Question: Print inorder successor for a given element.

	Logic: 
		- Inorder successor (Left-Root-Right)
		- Traverse upto the given target element. 
		- If target element has right sub-tree then return the Minimum element node in the right sub-tree.
		- If the target does not have right sub-tree then the successor should be the element highest than the target element. 	 Since the element is present in the right child of some tree which will eventually be greater than its ancestors.
		  So we have to get pop the nodes from the stack until there is a node which is greater than the target element.

	NOTE: Also refer solution 2 from the below link, (It deos use any memeory.)
		http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/	  
*/

import java.util.*;
class InorderSuccessorBST {

	private BST bstObj;
	private BTNode root;
	private int[] input = {20, 8, 22, 4, 12, 10, 14};

	public static void main(String[] args) {
		InorderSuccessorBST inSucObj = new InorderSuccessorBST();
		inSucObj.prepareBST();
		inSucObj.print();

		// System.out.println("Enter target element:");
		// Scanner scan = new Scanner(System.in);
		// int target = scan.nextInt();
		// inSucObj.printInorderSuc(target);
		inSucObj.printInorderSuc();
	}

	void prepareBST() {
		bstObj = new BST();
		for(int data : input) {
			root = bstObj.insert(root, data);
		}
	}

	void print() {
		bstObj.print(root);

		// also print order traversal of the tree.
		BTUtil.printInorder(root);
	}

	void printInorderSuc() {
		for(int target : input) {
			BTNode node = getInorderSuc(root, target);
			if(null != node) {
				System.out.println("INORDER: Successor element for " + target + " is: " + node.data);
			} else {
				System.out.println("INORDER: Successor does NOT exist for " + target);
			}
		}
	}

	BTNode getInorderSuc(BTNode	root,
							int target) {
		BTNode searchNode = null;
		Stack<BTNode> stack = new Stack<BTNode>();

		if(null == root) {
			return null;
		} else {
			while(root != null && root.data != target) {
				stack.push(root);
				if(target < root.data) {
					root = root.left;
				} else if(target > root.data) {
					root = root.right;
				}
			}

			// If the right sub tree is present for the target node then return the minimum in right sub-tree.
			if(null != root && root.data == target) {
				if(null != root.right) {
					searchNode = getMinNode(root.right);
				} else {
					// Since we don't have the right sub-tree. 
					// The successor will be the the next highest element after the target.
					// To get that we need to travel all the way until the top fo the stack is more than the target element.
					while(!stack.isEmpty()) {
						 BTNode poppedNode = stack.pop();	
						 if(poppedNode.data > target) {
						 	searchNode = poppedNode;
						 	break;
						 }
					}	
				}	
			}
		}
		return searchNode;
	}

	// We will get the right subtree of a node here.
	// We need to return the smallest element in the right sub-tree.
	BTNode getMinNode(BTNode current){
		while(null != current.left) {
			current = current.left;
		}
		return current;
	}
}