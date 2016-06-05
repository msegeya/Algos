/**
	Question: Given a tree print the path from root to leaf such that the path should have the maximum sum.

*/

class LeafToRootMaxPath {

	BTNode head = null; // this should be pointing to the root node.


	public void leafToRootPath() {
		BTNode root = head;
		String output = "";
		int cur_sum = 0;
		int max_sum = Integer.MIN_VALUE;
		int max_output = "";

		leafToRoot(root, head, cur_sum, output)

		//finally reverse the max_output to print the path from leaf to tree.
	}

	public void leafToRoot(BTNode root, BTNode head, int cur_sum, String output) {
		if(null == root) {
			return;
		}

		cur_sum += root.data;
		output += root.data + " ";

		if(null == root.left && null == root.right) {
			if(max_sum < cur_su) {
				max_sum = cur_sum;
				max_output = output;
			}
		} else {
			leafToRoot(root.left, head, cur_sum, output);
			leafToRoot(root.right, head, cur_sum, output);
		}
	}
}