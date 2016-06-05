class BoundaryTraversal {
	
	public void printBoundaries(BTNode root) {
		// print left boundaries.
		printLeftBoundary(root.left);

		// print leaves on left sub-tree.
		printLeaves(root.left);

		// print leaves on right sub tree.
		printLeaves(root.right);

		// finally print right leaves.
		printRightBoundary(root.right);
	}

	public void printLeftBoundary(BTNode root) {
		if(null != root) {
			// we should not print leaves since we will take care of it in another method.
			// that is the reason for checking whether there is left or right child.
			if(null != root.left) {
				System.out.println(root.data);
				printLeftBoundary(root.left);
			} else if(null != root.right) {
				System.out.println(root.data);
				printLeftBoundary(root.right);
			}
		}
	}

	public void printRightBoundary(BTNode root) {
		if(null != root) {
			// we should not print leaves since we will take care of it in another method.
			// that is the reason for checking whether there is left or right child.
			if(null != root.right) {
				printRightBoundary(root.right);
				System.out.println(root.data);
			} else if(null != root.left) {
				printRightBoundary(root.left);
				System.out.println(root.data);
			}
		}
	}

	public void printLeaves(BTNode root) {
		if(null == root) {
			return;
		}

		if(BTUtil.isLeaf(root)) {
			System.out.println(root.data);
			return;
		}

		printLeaves(root.left);
		printLeaves(root.right);
	}
}