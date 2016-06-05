/**
	Question: 1. Print level by level using iterative (printEachLevelFromTop(..)) and recursive (printNodesAtEachLevel(..)). 
			  2. Print Nodes from bottom to top(printEachLevelFromBottom(..)).
			  3. Print nodes at given level(printNodesAtLevel(..)).
			  4. Print each level separatly using Iterative approach. (printLevelByLevelIterativel(..))

	Reference:  http://www.geeksforgeeks.org/level-order-tree-traversal/
				http://geeksquiz.com/print-level-order-traversal-line-line/
*/

class LevelByLevel {
	/* 
		We will use BFS to do the same.
		Push each encountered node in to the queue and print them while pushing in to the queue.
	*/
	public void printEachLevelFromTop(BTNode root) {
		Queue<BTNode> queue = new LinkedList<BTNode>();

		queue.add(root);

		while(!queue.isEmpty()) {
			BTNode popNode = queue.remove();
			System.out.println(popNode.data);
			if(null != popNode.left) {
				queue.add(popNode.left);	
			}

			if(null != popNode.right) {
				queue.add(popNode.right);	
			}
		}
	}

	// What if the question says from bottom.
	// Print leaf nodes first and then print all the remaining levels from bottom.
	public void printEachLevelFromBottom(BTNode root) {
		int height = BSTHeight.getHeight(root);

		for(int level = height; level > 0; level--) {
			printNodesAtLevel(root, level, level);
		}
	}

	// from root we are going down so level will be reduced to reach our target level.
	public void printNodesAtLevel(BTNode root, int level, int actualLevel) {
		if(null == root) {
			return;
		}

		if(level == 1) {
			System.out.println("At Level " + actualLevel + "\t" + root.data);
		}

		printNodesAtLevel(root.left, level - 1, actualLevel);
		printNodesAtLevel(root.right, level - 1, actualLevel);
	}

	public void printNodesAtEachLevel(BTNode root, int level) {
		int height = BSTHeight.getHeight(root);
		for(int level = 1; level <= height; level++) {
			printNodesAtLevel(root, level, level);
		}
	}

	/*
		To make sure we are in a different level we need to add null between each level.
		How do we identify a level .. we identify it when we encounter a null value.

		When do we insert a null?
		We need to add right after poping a null value from the queue.
	*/
	public void printLevelByLevelIterativel(BTNode root) {
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(root);
		queue.add(null);
		int level = 1;
		while(!queue.isEmpty()) {
			BTNode popNode = queue.remove();
			if(null == popNode) {
				level++;

				if(!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				System.out.println("Node at level " + level + " is " + popNode.data);	
			}

			if(null != popNode.left) {
				queue.add(popNode.left);
			}

			if(null != popNode.right) {
				queue.add(popNode.right);
			}
		}
	}

}