class AncestorsOfNode {
	public boolean printAncestors(BTNode root, int key) {
		if(null == root) { return false; }

		if(root.data == key) { return true; }

		if(printAncestors(root.left, key) || printAncestors(root.right)) {
			System.out.println(root.data);
			return true;
		}

		return false;
	}

	/*
		Do preorder until we find the node and insert all the nodes that have encountered in to the stack except the target node.
		Now, Pop each node and see whether this node has child as target of not.
		If No, then continue popping.
		If Yes, then make the popped node as child and now do the procedure again.
	*/
	Stack<BTNode> stack = new Stack<BTNode>();
	public void printAcestors_Iteratively(BTNode root, int key) {
		while(!stack.isEmpty()) {
			BTNode poppedNode = stack.pop();
			if(poppedNode.left.data == key || poppedNode.right.data == key) {
				System.out.println(poppedNode.data);

				// Update this key such that we can now consider this as a key and check for its ancestors.
				key = poppedNode.data;
			}
		}
	}

	public void doPreOrder(BTNode root, int key) {
		if(key == root.data) {
			return;
		}

		if(key != root.data) {
			stack.push(root);
		}

		doPreOrder(root.left);
		doPreOrder(root.right);
	}
}