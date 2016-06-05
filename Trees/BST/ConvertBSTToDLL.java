/**
	Question: Convert a BST to DLL.

	Reference:  http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
				http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/

	Logic: Do an inorder traversal and instead of printing a node we will link it to head of the lnked list.

	NOTE: We are not going to create new DLL nodes. We will just use left and right pointers of tree for prev and next of DLLNode.
*/

class ConvertBSTToDLL {
	
	private DLLNode head = null;
	private DLLNode prev = null;

	public void bstToDll(BSTNode root) {
		if(null == root) {
			return;
		}

		bstToDll(root.left);

		if(null == head) {
			head = root;
			// this is actually not required for head node. As it will be null anyways. But for understanding we have written here.
			head.left = prev; 
		} else {
			head.right = root;
			root.left = prev;
		}

		// we need to keep track of the last visited node.
		prev = root;

		bstToDll(root.right);
	}
}