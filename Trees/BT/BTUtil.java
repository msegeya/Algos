/**
	Question: Size of a BT, Height of a BT.
*/

class BTUtil {

	/*
		For iterative we can use BFS.
	*/
	public static int size(BTNode root) {
		if(null == root) {
			return 0;
		}

		int leftSize = size(root.left);
		int rightSize = size(root.right);

		return leftSize + rightSize + 1;
	}

	/*
		For iterative we can use BFS.
	*/
	public static int height(BTNode root) {
		if(null == root) {
			return 0;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}


	public static boolean isLeaf(BTNode root) {
		if(null != root && null == root.left && null == root.right) {
			return true;
		}

		return false;
	}
}