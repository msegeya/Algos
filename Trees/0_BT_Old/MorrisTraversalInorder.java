/**
	Source: 
		http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
		http://geeksquiz.com/threaded-binary-tree/
	Question: INORDER traversal of a tree without recursion and without usign Stack.
	
	This comes under Threaded Binary Tree concept.

	Logic: (Using Single Threaded Binary tree)
		- A binary tree is made threaded by making all right child pointers that would normally be NULL point to the inorder successor of the node (if it exists).
		- The logic goes like this,
			- Start from root.
 			- For each level in the left sub-tree goto its right most child (which has null as right child) and make right pointer point to the successor.
 			- See code comments for more detailed explanation.
*/

class MorrisTraversalInorder {

	private BST bstObj;
	private BTNode root;

	public static void main(String[] args) {
		MorrisTraversalInorder mtObj = new MorrisTraversalInorder();
		mtObj.prepareBST();

		mtObj.printMorrisTra();
	}

	void prepareBST() {
		bstObj = new BST();
		int[] input = {20, 8, 22, 4, 12, 10, 14};
		for(int data : input) {
			root = bstObj.insert(root, data);
		}
		bstObj.print(root);
	}

	void printMorrisTra() {
		System.out.println("");
		doPrintUsingMorris(root);
	}

	void doPrintUsingMorris(BTNode root) {
		if(null == root) {
			return;
		} else {
			BTNode current = root;
			BTNode previous = null;

			while(null != current) {
				// If there is no left child then root data should be printed first. 
				// And then goto right child and start the procedure again.
				if(null == current.left) {
					System.out.print(current.data + " ");
					current = current.right;
				} else {
					// If the left of root is not null then we need print left elements first. So move in that direction.
					// But for each root below the main-root, we have to make the right most child in the right sub-tree 
					// must point to its successor.
					// We are doing this beacuse we need to print the right children before we print the ancestor. 
					previous = current.left;
					while(null != previous.right && previous.right != current) {
						previous = previous.right;
					}

					// After getting to the last node in the right and if it is null then map the right child to the current.
					// Now make the current move to one level down.
					// else if the previous.right is current then ?
					// we need to revert it back to original value that is null and then print it.
					if(null == previous.right) {
						previous.right = current;
						current = current.left; 
					} else {
						previous.right = null;
						System.out.print(current.data + " ");
						current = current.right;
					}
				}
			}
		}
	}
}