class BSTUtil {
	
	public static boolean isLeaf(BST root) {
		if(null != root) {
			if(null == root.left && null == root.right) {
				return true;
			}
		}

		return false;
	}
}