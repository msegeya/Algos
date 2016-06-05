/**
	Question: Delete a tree. You need to free all nodes in a tree.
*/

class DeleteTree {
	public void deleteTree(BTNode root) {
		if(null == root) {
			return;
		}

		deleteTree(root.left);
		deleteTree(root.right);

		// finally we are at the end of the tree.
		root = null;
	}
}