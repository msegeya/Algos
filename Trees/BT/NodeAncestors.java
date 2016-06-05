/**
	Question: Given a tree and a node in the tree. Fin the ancestors of the given node.

	Logic - 1: (Using Recursion)
		- Simple if the ket mathes the current node data then return true.
		- If the key does not match then call left and right of the node.
		- If the node is null then return false.
		- Either of the left sub-tree or right sub-tree must match then print the node value.

	Logic - 2: (Using Stacks, Iterative approach.)
		- We will traverse using post order traversal.
		- Traverse all the way to left until you did not find the key and keep pushing the nodes into stack.
		- If key is found then pop all the elements in the stack and print them.
		- If not found then,
			- If the left most node has right sub-tree then simply make the root as right and continue doing above again.
			- If the left node has NO right node then pop the left from the stack and make the top as root if it is not root before.
*/

class NodeAncestors {
	public static boolean ancestors_recur(BTNode root, int key) {
		if(null == root) {
			return false;
		}

		// if matched then return true.
		if(key == root.data) {
			return true;
		}

		// If the key is present in any of the sub-tree then just print that node.
		if(ancestors_recur(root.left, key) || ancestors_recur(root.right, key)) {
			System.out.println(root.data);
			return true;
		}

		return false;
	}

	public static boolean ancestors_iterative(BTNode root, int key) {
		Stack<BTNode> stack = new Stack<BTNode>();

		while(true) {
			while(null != root && root.data != key) {
				stack.push(root);
				root = root.left;
			}

			if(null != root && root.data == key) {
				break; // break and print the elements that are in the stack
			}

			// If no right tree is present to the left most node
			if(stack.peek().right == null) {
				root = stack.pop();
				while(!stack.isEmpty() && stack.peek().right == root) {
					root = stack.pop();
				}
			} else {
				// if right is not null then make right as root and start again.
				root = stack.isEmpty() ? null : stack.peek().right;
			}
		}

		// finally print all the elements in the stack. All these are the ancestors.
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().data);
		}
	}
}