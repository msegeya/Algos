/**
	Question: Count the number of leaves.

	Logic: No left and right childs then increment count.
*/

class LeafCount {

	public void leafCount(BTNode root) {
		if(null == root) {
			return 0;
		}

		if(null == root.left && null == root.right) {
			return 1;
		}

		return leafCount(root.left) + leafCount(root.right);
	}

}