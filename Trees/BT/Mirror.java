/**
	Question: Mirror of a tree.

	Logic: We should start swapping from the leafs. Go until the leafs and then start swapping leafs and move upwards.
*/
class Mirror {
	public void mirror(BTNode root) {
		if(null == root) {
			return;
		}

		mirror(root.left);
		mirror(root.right);

		BTNode temp = root.left;
		temp.left = root.right;
		temp.right = temp;
	}
}