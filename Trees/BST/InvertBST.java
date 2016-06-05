/**
	Question: Invert a BST. That is to convert swap all the left and right nodes of every root.
	This is the same question as "Mirror of a tree"

	Reference:  http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
				https://www.youtube.com/watch?v=ZL9f1pVrBuo
*/

class InvertTree {
	
	public void invert(BSTNode root) {
		if(null == root) {
			return;
		}

		invert(root.left);
		invert(root.right);

		BSTNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
}