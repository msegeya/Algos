/**
	Question: Morris Preorder traversal.

	Reference: http://www.geeksforgeeks.org/morris-traversal-for-preorder/

	Logic: (Same a MorrisInorder logic with a minor change)

*/

class MorrisPreorder {
	public void preOrder(BTNode root) {

		// We don't use current like the way we used in inorder. We use root for every operation here.
		// Current is used just to map the node to root where ever necessary.
		while(null != root) {
			if(root.left == null) {
				System.out.println(root.data);
				root = root.right;
			} else {
				BTNode current = root left;
				while(null != current.right && root != current.right) {
					current = current.right;
				}

				if(current.right == root) {
					current.right = null;
					
					root = root.right;
				} else {
					System.out.println(root.data);
					current.right = root;
					root = root.left;
				}
			}
		}
	}
}