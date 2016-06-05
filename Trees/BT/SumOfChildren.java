/**
	Question: For every node update the value of it with sum of its children.

	Reference: http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/

	Logic: 
		- See in code comments.

*/

class SumOfChildren {
	public int sumTree(BTNode root) {
		if(null == root) { return 0; }
		// store the node value
		int old_value = root.data;

		// Now update the node value with left and right children.
		root.data = sumTree(root.left) + sumTree(root.right);

		// finally return the sum of both the old value and the updated value.
		return old_value + root.data;
	}
}