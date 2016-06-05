/**
	Source: http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
	Question: Check if the given tree is BST or not.
	
	Logic: (WRONG logic)
		- For all the nodes do, 
			is left node less than root and is right node greater than root => return true.

		Try the below example,
						3
					  /   \
					 2     5
				   /  \
				  1    4
				  
		As per above logic each node satisfies the condition. But look at 4 which is right of 2 and in left sub-tree of 3.
		Is that right? NO. 4 has to be in the right sub-tree of 3 not to left of it.

	Logic: (Without using space.)
		- We have to make sure the following conditions are true,
			- All the children to the left of the root should have,
				Minimum value less than root's data
				Maximum value atmost root's data - 1.
			- All the children to the right of the root should have,	
				Minimum value starting from root's data + 1
				Maximum value is any value greater than Minimum value.

	Logic: (Inorder approach with Space O(1))			
		- Get inorder of the tree => if the inorder of the tree is sorted then BST else NOT.
		  How to check they are sorted or not. For every element check if the previous element is less than this.
		  If yes, then BST else "NOT BST"
*/

import java.util.*;

class CheckBST {
	
	private BST bstObj;
	private CBT cbtObj;

	private BTNode root1;
	private BTNode root2;

	public static void main(String[] args) {
		CheckBST chkbstObj = new CheckBST();
		chkbstObj.prepareBST();
		
		chkbstObj.checkBST();

		// chkbstObj.checkBSTUsingInorder();
	}

	void prepareBST() {
		bstObj = new BST();
		cbtObj = new CBT();	

		int[] input = {4, 2, 5, 1, 3};
		for(int data : input) {
			root1 = bstObj.insert(root1, data);
		}
		bstObj.print(root1);


		// We need a BT here not BST since we need to construct a faulted BST.
		int parent = -1;
		boolean leftRightFlag = false;

		int[] input2 = {3, 2, 5, 1, 4};
		for(int data : input2) {
			Map<String, String> map = getParentAndSideTree2(data);
			parent = Integer.parseInt(map.get("parent"));
			leftRightFlag = Boolean.valueOf(map.get("side"));
			root2 = cbtObj.insert(root2, data, parent, leftRightFlag);
		}

		cbtObj.print(root2);
	}

	void checkBST() {
		System.out.println("Positive case: ");
		printBSTStatus(root1);

		System.out.println("Negative case: ");
		printBSTStatus(root2);
	}

	void printBSTStatus(BTNode root) {
		if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("Given tree is BST.");
		} else {
			System.out.println("Given tree is NOT BST.");
		}
	}

	boolean isBST(BTNode root,
					int min,
						int max){
		if(null == root) {
			return true;
		}
		if(root.data < min || root.data > max) {
			return false;
		}
		return (isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max));
	}

	Map<String, String> getParentAndSideTree2(int data) {
		Map<String, String> map = new HashMap<String, String>();
		// true = right child
		// false = left child
		if(data == 2) {
			map.put("parent", "3");
			map.put("side", "false");
		} else if(data == 5) {
			map.put("parent", "3");
			map.put("side", "true");
		} else if(data == 1) {
			map.put("parent", "2");
			map.put("side", "false");
		} else if(data == 4) {
			map.put("parent", "2");
			map.put("side", "true");
		} else { // root case
			map.put("parent", "0"); // set some random values.
			map.put("side", "true");
		}

		return map;
	}

/*
	void checkBSTUsingInorder() {
		if(isBSTUsingInorder(root1)) {
			System.out.println("Given tree is BST.");
		} else {
			System.out.println("Given tree is NOT BST.");
		}
	}
*/
/*
	// We will use previous node to keep track of the previous element that is visited in the inorder.
	static BTNode previous = null;
	boolean isBSTUsingInorder(BTNode root) {

		if(null == root) {
			return true;
		} else {
			if(isBSTUsingInorder(root.left)) {
				return true;
			}

			// After the last call the root will be the left most leaf node and previous will be null.
			// Then come one step above, root will be parent and previous will be its left child.
			if(null != previous && root.data <= previous.data) {
				return false;
			}

			previous = root;

			return isBSTUsingInorder(root.right);
		}

		return true;
	}
*/
}