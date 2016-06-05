/**
	Question: Print Inorder traversal of a tree using Iterative.

	NOTE: This logic is by using Stack. Check for MorrisInorder.java for stack free approach.

	1. Using Stack (printInorderIter(..))
	2. Without using Stack.

*/

class InorderIter {
	public void printInorderIter(BTNode root) {
		Stack<BTNode> stack = new Stack<BTNode>();

		BTNode current = root;
		if(null == root) {
			return;
		}

		// push all left child's in to the stack.
		while(null != current) {
			stack.push(current);
			current = current.left;
		}

		while(!stack.isEmpty()) {
			BTNode popNode = stack.pop();
			System.out.println("BTNode is " + popNode.data);
			current = popNode;

			if(null != current.right) {
				current = current.right;

				while(null != current) {
					stack.push(current);
					current = current.left;
				}
			}
		}

	}
}