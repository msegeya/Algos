class LeafsInBT {
	private BTNode root;
	private CBT cbtObj;

	public static void main(String[] args) {
		LeafsInBT leafObj = new LeafsInBT();
		leafObj.prepareTree();

		System.out.println("Using RECURSIVE: ");
		leafObj.printLevelRecur();
		
		/*
			Using Iterative: BFS
				For each popped element from Queue. 
				Check if it's left and right child are null. If so then save it in a list.
				Finally return list which will also give us the number of leaves.
		*/
	}

	void prepareTree() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printLevelRecur() {
		int leafs = getTotalLeafs(root, 0);
		System.out.println("Total leafs: " + leafs);
	}

	int getTotalLeafs(BTNode root, 
							int count) {
		if(null == root) {
			return 0;
		}

		if(null == root.left && null == root.right) {
			return 1;
		}

		return count + getTotalLeafs(root.left, count) + getTotalLeafs(root.right, count);
	}
}