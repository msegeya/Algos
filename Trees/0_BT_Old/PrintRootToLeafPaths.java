/**
	Source: http://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
	Question: Print all the paths from Root to Leaf.

	Logic: 
		- This is similar to level by level printing. But here instead of going level by level we go deep until we reach leaf node.
			For Printing level by level see PrintLevelByLevel.java
		- One additional variable we need is an "array" for saving each path.
		- Previously in PrintLevelByLevel.java we used to take return the value when we reach level 0.
		  But now we will use the level and save each node value when reach into an Array.
		- Finally when we reach a node which does not have left and right nodes then print the array.
*/

class PrintRootToLeafPaths {

	private CBT cbtObj;
	private BTNode root;

	public static void main(String[] args) {
		PrintRootToLeafPaths mmtObj = new PrintRootToLeafPaths();
		mmtObj.prepareCBT();

		mmtObj.printRootToLeafPaths();
	}

	void prepareCBT() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printRootToLeafPaths() {
		int[] path = new int[100];
		int level = 0;
		getRootToLeafPaths(root, path, level);
	}

	void getRootToLeafPaths(BTNode root, 
								int[] path,
									int level) {
		if(null == root) {
			return;
		}

		path[level] = root.data;

		if(null == root.left && null == root.right) {
			printPaths(path, level);
		}

		getRootToLeafPaths(root.left, path, level + 1);
		getRootToLeafPaths(root.right, path, level + 1);
	}

	void printPaths(int[] path, int maxLevel) {
		for(int i = 0; i <= maxLevel; i++) {
			System.out.print(path[i] + " -> ");
		}
		System.out.println();
	}
}