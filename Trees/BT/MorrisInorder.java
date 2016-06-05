/**
	Question: Morris inorder traversal.

	Reference: http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
*/

class MorrisInorder {


	public void printInorder() {
		inorder(root)
	}

	public void inorder(BTNode current) {

		BTNode pre = null;

		while(current != null) {
			if(null == current.left) {
				System.out.println(current.data + " -> ");
				current = current.right;
			} else {
				pre = current.left;
				while(null != pre.right && pre.right != current) {
					pre = pre.right;
				}

				if(null == pre.right) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.println(current.data + " -> ");
					current = current.right;
				}
			}
		}
	}
}