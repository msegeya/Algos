class HalfNodesBT {

	/* Use the same logic below for Full nodes also Where both the left and right childs should not be null. */

	/*
		Using Recursion:

		int getHalfNodes(BTNode root, 
							int count) {
			if(null == root) {
				return 0;
			}

			if(null != root.left && null == root.right) {
				return 1
			}

			if(null == root.left && null != root.right) {
				return 1
			}			

			return count + getHalfNodes(root.left) + getHalfNodes(root.right);
	*/

	/*
		Using Iterative:
			For each popped node check left and right childs.
			If the nodes satisfies condition then increment count.
	*/	
}