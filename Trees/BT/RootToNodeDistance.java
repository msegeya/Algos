class RootToNodeDistance {
	// pass level as 1
	public int rootToNodeDist(BTNode root, int key, int level) {
		if(null == root) { return 0; }

		if(root.data == key) {
			return level;
		}

		if(rootToNodeDist(root.left, key, level + 1) > 0) {
			return level;
		}

		if(rootToNodeDist(root.right, key, level + 1) > 0) {
			return level;
		}

		return 0;
	}
}