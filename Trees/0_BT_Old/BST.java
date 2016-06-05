class BST {

	private BTNode root;

	public static void main(String[] args) {
		BST bstObj = new BST();
		bstObj.prepareBST();
		bstObj.printBST();
	}

	void prepareBST() {
		int[] input = {20, 8, 22, 4, 12, 10, 14};
		for(int data : input) {
			root = insert(root, data);
		}
	}
	
	void printBST() {
		print(root);
	}

	BTNode insert(BTNode root, int data) {
		BTNode newNode = new BTNode(data);
		if(null == root) {
			root = newNode;
		} else {
			if(data < root.data) {
				root.left = insert(root.left, data);
			} else if(data > root.data) {
				root.right = insert(root.right, data);
			}
		}
		return root;
	}

	// print level by level
	void print(BTNode root) {
		int height = BTUtil.getHeight(root);
		System.out.println("Recursive Print call: ");
		for(int level = 1; level <= height; level++) {
			printLevelBST(root, level, level);
		}
		System.out.println();
	}

	void printLevelBST(BTNode root, int level, int currentLevel) {
		if(null == root) {
			return;
		} 

		if(1 == level) {
			System.out.println("Element " + root.data + " @ level " + currentLevel);
		}

		printLevelBST(root.left, level - 1, currentLevel);
		printLevelBST(root.right, level - 1, currentLevel);
	}
}