/**
	Source: http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/

	Question: Convert a sorted SLL to balanced BST.

	Logic: 
		- Refer InorderPreorderToTree.java too.
		- Get the mid point of sorted linked list and make it as root of the tree.
		- Now we have two lists which we place to left and right of the root.
		- Recursively find the mid-point of the two lists and constrcut the tree.
*/

import java.util.*;

public class SLLtoBST {

	private SLLNode head;
	private BTNode root;
	private BST bstObj;

	public static void main(String[] args) {
		SLLtoBST sllObj = new SLLtoBST();
		sllObj.prepareSLL();

		sllObj.makeBST();
	}

	void prepareSLL() {
		bstObj = new BST();
		int[] input = {10, 20, 30, 40, 50, 60, 70, 80};
		for(int data : input) {
			head = SLL.insert(head, data);
		}
		SLL.print(head);
	}

	void makeBST() {
		SLLNode last = head;
		while(null != last.next) {
			last = last.next;
		}
		root = makeBSTUsingSLL(head, last);

		System.out.println("\nSLL to balanced BST is: ");
		bstObj.print(root);
	}

	BTNode makeBSTUsingSLL(SLLNode first, 
									SLLNode last) {

		// If there is only one node or if their are only two nodes.
		if(first.data > last.data) {
			return null;
		}

		// If only one element exists.
		if(first == last || (null != first && null == last)) {
			BTNode node = new BTNode(first.data);
			return node;
		}

		// We will need a map since the last node for the left sub-tree will be the previous of mid.
		// But as this is SLL we can't go backwards. So we will save it while calculating the mid-point.
		Map<String, SLLNode> map = SLL.midNodeSLL(first, last);
		SLLNode midNode = map.get("mid");
		SLLNode tempLast = map.get("prev");
		BTNode newNode = new BTNode(midNode.data);

		newNode.left = makeBSTUsingSLL(first, tempLast);
		newNode.right = makeBSTUsingSLL(midNode.next, last);

		return newNode;
	}
}
