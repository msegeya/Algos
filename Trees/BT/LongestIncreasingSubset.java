class LongestIncreasingSubset {

	/*NOTE: For this we need to introdce one more attribute to our calss "lis" */

	public int LIS(BTNode root) {
		if(null == root) {
			return 0;
		}

		if(0 != root.lis) {
			return root.lis;
		}

		if(BTUtil.isLeaf(root)) {
			root.lis = 1;
			return root.lis;
		}

		// excluding the current node.
		int lis_excl = LIS(root.left) + LIS(root.right);

		// including the current node.
		int lis_incl = 1;
		if(null != root.left) {
			root.lis += LIS(root.left.left) + LIS(root.right.right);
		}

		if(null != root.right) {
			root.lis += LIS(root.right.left) + LIS(root.right.left);
		}

		// Get the minimum of the two.
		root.lis = Math.min(lis_incl, lis_excl);

		return root.lis;
	}
}