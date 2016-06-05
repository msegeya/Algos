/**
	Question: Print root to leaf paths.

	Logic: Save output at each level and then print when ever there is a new node.
*/

class PrintRootToLeafPath {

	/*
		BTNode root = rootNode;
		String output = "";
	*/
	public void rootToLeaf(BTNode root, String output) {
		if(null == root) {
			return;
		}

		output = output + root.data + " -> ";
		if(root.left == null && root.right == null) {
			System.out.println(output);
		}

		rootToLeaf(root.left, output);
		rootToLeaf(root.right, output);
	}

	/*
		BTNode root = rootNode;
		path = new int[1000];
		length = 0;
	*/
	public void rootToLeaf(BTNode root, int[] path, int length) {
		if(null == root) {
			return;
		}

		path[length] = root.data;
		length++;

		if(null == root.left && null == root.right) {
			print(path, length);
		}

		rootToLeaf(root.left, path, length);
		rootToLeaf(root.right, path, length);
	}

	public void print(int[] path, int length) {
		for(int i = 0; i < length; i++) {
			System.out.print(path[i] + " -> ");
		}
		System.out.println();
	}
}