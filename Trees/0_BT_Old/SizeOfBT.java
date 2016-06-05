class SizeOfBT {

	private BTNode root;
	private CBT cbtObj;

	public static void main(String[] args) {
		SizeOfBT sObj = new SizeOfBT();
		sObj.prepareTree();
		sObj.printSizeUsingRecur();
		
		// Use BFS to count elements. Whenever an element is popped from tree then increment the count.
		// sObj.printSizeUsingIter();
	}

	void prepareTree() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printSizeUsingRecur() {
		int size = getSizeUsingRecur(root);
		System.out.println("Size of tree is: " + size);
	}

	int getSizeUsingRecur(BTNode root) {
		if(null == root) {
			return 0;
		}

		return 1 + getSizeUsingRecur(root.left) + getSizeUsingRecur(root.right);
	}
}