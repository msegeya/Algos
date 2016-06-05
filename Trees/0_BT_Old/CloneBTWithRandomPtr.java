/**
	Source: http://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
	Question: Clone a BT with random pointer.

	Logic-1: (Without any extra space.)	
		- Create a copy of each node same as the original node in the same original tree.
		- Update all the pointers of the cloned nodes.
		- Remove the cloned nodes from the original tree.

	Example: (Node , Random_pointer) pair,
				(1, 7); (2, 4); (3, 6); (4, 5) (5, 4) (6, 7) (7, 6)
					1 
				  /   \
				 2     3
				/ \   / \
			   4   5 6   7 	   	

		After step-1, first few nodes of a tree along with its clone nodes are. (c for clone in belwo figure.)
						1
					  /   \
					 1c    3
					/ \   /
				   /   \ / 		   
                  2     3c 
				 /
				2c
				 	
	Logic-2: (Using HashMap) -> (Did not understand how it works)
		- This question is same a Cloning a Single Linked List. But here we will use Map for temporary storage.
		- First we will construct a tree withour random pointers. (see below copyLeftRightNode method.)
		- Now, we will finally copy all the random nodes. (see below copyRandom method.)

*/

class CloneBTWithRandomPtr {

	private BTNodeRandom root;
	private BTNodeRandom cloneTree;

	public static void main(String[] args) {
		CloneBTWithRandomPtr cloneBT = new CloneBTWithRandomPtr();
		cloneBT.prepareBinRandomTree();

		cloneBT.printCloneBT();
	}

	void prepareBinRandomTree() {
		BTNodeRandom one = new BTNodeRandom(1);
		BTNodeRandom two = new BTNodeRandom(2);
		BTNodeRandom three = new BTNodeRandom(3);
		BTNodeRandom four = new BTNodeRandom(4);
		BTNodeRandom five = new BTNodeRandom(5);
		BTNodeRandom six = new BTNodeRandom(6);
		BTNodeRandom seven = new BTNodeRandom(7);

		one.left = two; one.right = three; one.random = seven;
		two.left = four; two.right = five; two.random = four;
		three.left = six; three.right = seven; three.random = six;
		four.left = null; four.right = null; four.random = five;
		five.left = null; five.right = null; five.random = four;
		six.left = null; six.right = null; six.random = seven;
		seven.left = null; seven.right = null; seven.random = six;

		root = one;
	}

	void printCloneBT() {
		cloneTree = copyLeftRightNodes(root);
		copyRandomPointer(root, cloneTree);
		restoreOriginalAndClonedNodes(root, cloneTree);

		print(cloneTree);
	}

	BTNodeRandom copyLeftRightNodes(BTNodeRandom root) {
		if(null == root) {
			return null;
		}

		// temporarly save the left node of the root.
		BTNodeRandom temp = root.left;
		// create a new node which is same as it's root.
		root.left = new BTNodeRandom(root.data);
		// now point the temp to the left node of the newly created node.
		root.left.left = temp;
		// if not null then do the same for temp node that is the left node of the original tree.
		if(null != temp) {
			temp.left = copyLeftRightNodes(temp);
		}

		// For right child, pass the right child of the root to the right of the duplicate node.
		root.left.right = copyLeftRightNodes(root.right);
		return root.left;
	}

	void copyRandomPointer(BTNodeRandom root, 
								BTNodeRandom clone) {
		if(null == root) {
			return;
		}

		// The clone random should point to the actual random's left node
		// because the next node is the cloned one.
		if(null != root.random) {
			clone.random = root.random.left;
		} else {
			clone.random = null;
		}

		// Now we have to move to left node of the cloned node which is root.left.left
		// with clone.left.left
		// Similarly root.right  with clone.right.
		if(null != root.left && null != clone.left) {
			copyRandomPointer(root.left.left, clone.left.left);
			copyRandomPointer(root.right, clone.right);
		}
	}

	// Now we need to restore the original nodes and cloned nodes.
	void restoreOriginalAndClonedNodes(BTNodeRandom root,
											BTNodeRandom clone) {
		if(null == root) {
			return;
		}

		if(null != clone.left) {
			BTNodeRandom tempClone = clone.left.left;
			root.left = root.left.left;
			clone.left = tempClone;
		} else {
			root.left = null;
		}

		restoreOriginalAndClonedNodes(root.left, clone.left);
		restoreOriginalAndClonedNodes(root.right, clone.right);
	}

	void print(BTNodeRandom cloned) {

		if(null == cloned) {
			return;
		}
		print(cloned.left);
		System.out.println("Key: " + cloned.data + " and Random: " + cloned.random.data);
		print(cloned.right);
	}	

/*
	// Assume BTNode contains random pointer also along with left and right.
	//  We will save all the orinal nodes with the mapped clone nodes in a map.
	void copyLeftRightNode(BTNode root, 
								Map<BTNode, BTNode> map) {
		if(null == root) {
			return;
		} 

		BTNode clone = new BTNode(root.data); // We won't clone entire node. Put left, right, random as NULL;
		
		// save the original node as value and root node as key.
		map.put(root, clone);

		clone.left = copyLeftRightNode(root.left, map);
		clone.right = copyLeftRightNode(root.right, map);
	}

	// Retrieve all the random pointers for the clone nodes by quering map using clone node as key
	void copyRandom(BTNode clone,
							Map<BTNode, BTNode> map) {
		if(null == clone) {
			return;
		}

		clone.random = map.get(clone).random; // call will return orinal node using which we can retieve the random pointer.
		copyRandom(clone.left, map);
		copyRandom(clone.right, map);
	}
*/

}

class BTNodeRandom {
	public int data;
	public BTNodeRandom left;
	public BTNodeRandom right;
	public BTNodeRandom random;

	BTNodeRandom(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.random = null;
	}

	BTNodeRandom(int data, 
				BTNodeRandom left,
					BTNodeRandom right, 
						BTNodeRandom random) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.random = random;
	}
}