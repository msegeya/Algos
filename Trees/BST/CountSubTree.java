/**
	Question: Count subtrees that lie in the given range.

	Reference: http://www.geeksforgeeks.org/count-bst-subtrees-that-lie-in-given-range/
*/

class CountSubTree {
	int count = 0;
	public boolean countSubTree(BSTNode root, int low, int high) {

		// If no node then no subtree.
		if(null == root) {
			return true;
		}

		// Evry leaf is a sub-tree so return 1.
		if(BSTUtil.isLeaf(root) && inRange(data)) {
			return true;
		}

		boolean left = countSubTree(root.left);
		boolean right = countSubTree(root.right);

		if(left && right && inRange(data, low, high)) {
			count++;
			return true;
		}

		return false;
	}

	public boolean inRange(int data, int low, int high) {
		if(data >= low && data <= high) {
			return true;
		}

		return false;
	}
}