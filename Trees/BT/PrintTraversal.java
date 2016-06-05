/**
	Question: Print Inorder, Preorder, Postorder traversal of a tree using recursion.
*/

class PrintTraversal {

	/*
		InOrder - Left Root Right
	*/
	public void inOrder(BTNode root) {
		if(null == root) {
			return;
		}

		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	/*
		preOrder = Root Left Right
	*/
	public void preOrder(BTNode root) {
		if(null == root) {
			return;
		}

		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	/*
		postOrder = Left Right Root
	*/
	public void postOrder(BTNode root) {
		if(null == root) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
}