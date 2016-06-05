/**
	Question: Zig-Zag tree traversal.

	Logic: (Using Recursion) 
		- It's simple. Look at LevelByLevel.java for level by level.
		- Now we know how to traverse level by level. But the point is how to make sure you travel from right to left for even levels. Just reverse the traversal call.
		- If odd level, 
			left and then right.
		  If even level,
		    right then left.
*/

class ZigZagTraversal {
	
	public void zigzag(BTNode root) {
		int height = BTUtil.height(root);
		boolean direction = true;
		for(int i = 1; i < height; i++) {
			traverse(root, level, direction);
			direction = !direction;
		}
	} 

	public void traverse(BTNode root, int level, boolean direction) {
		if(null == root) {
			return;
		}

		if(level == 1) {
			System.out.println(root.data);
			return;
		} else {
			if(direction) {
				traverse(root.left, level - 1, direction);
				traverse(root.right, level - 1, direction);
			} else {
				traverse(root.right, level - 1, direction);
				traverse(root.left, level - 1, direction);
			}	
		}
	}
}