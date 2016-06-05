/**
	Source: 
	https://conceptsforyou.wordpress.com/2013/12/06/non-recursive-algorithm-to-find-the-pre-order-successor-of-a-given-node-in-a-bst/

	Question: Preorder successor of a node in a BST.
	We need to get the next node of the tree when we traverse the tree using preorder traversal.

	Logic: Iterative
		- Preorder is (Root-Left-Right)
		- Find find the node in the tree. If node does not exist then return null.
		- If the node exists,
			- If the node has left child then return left child as successor.
			- If the node has right child then return right child as successor.
			- If the node is leaf then we have to return the right child of the closest ancestor.	
*/

import java.util.*;
class PreorderSuccessorBST {

	private BST bstObj;
	private BTNode root;
	private int[] input = {20, 8, 22, 4, 12, 10, 14};

	public static void main(String[] args) {
		PreorderSuccessorBST pSucObj = new PreorderSuccessorBST();
		pSucObj.prepareBST();
		pSucObj.print();

		// System.out.println("Enter target element:");
		// Scanner scan = new Scanner(System.in);
		// int target = scan.nextInt();
		// pSucObj.printPreorderSuc(target);
		pSucObj.printPreorderSuc();
	}

	void prepareBST() {
		bstObj = new BST();
		for(int data : input) {
			root = bstObj.insert(root, data);
		}
	}

	void print() {
		bstObj.print(root);

		// also print preorder traversal of the tree.
		BTUtil.printPreorder(root);
	}

	//printPreorderSuc(int target)
	void printPreorderSuc() {

		for(int target : input) {
			BTNode node = getPreorderSuc(root, target);
			if(null != node) {
				System.out.println("PREORDER: Successor element for " + target + " is: " + node.data);
			} else {
				System.out.println("PREORDER: Successor does NOT exist for " + target);
			}			
		}
	}

	BTNode getPreorderSuc(BTNode root, 
								int target) {
		BTNode searchNode = null;
		Stack<BTNode> stack = new Stack<BTNode>();

		if(null == root) {
			return null;
		} else {
			while(null != root && root.data != target) {
				stack.push(root);
				if(target > root.data) {
					root = root.right;
				} else if(target < root.data) {
					root = root.left;
				}
			}

			// If their exists a left sub-tree then return left sub-tree.
			// If the left sub-tree is null and right sub-tree is NOT null then return right sub-tree.
			// If both the sub-tree's are null then move one step above and do the same preocess.
			if(null != root && root.data == target) {
				if(null != root.left) {
					searchNode = root.left;
				} else if(null != root.right) {
					searchNode = root.right;
				} else {
					BTNode visited = root;
					while(!stack.isEmpty()) {
						BTNode poppedNode = stack.pop();
						if(null != poppedNode.right && poppedNode.right == visited) {
							visited = poppedNode;
						} else {
							searchNode = poppedNode.right;
							break;
						}
					}
				}
			}
		}
		return searchNode;
	}
}