class SearchBT {

	private BTNode root;
	private CBT cbtObj;

	public static void main(String[] args) {
		SearchBT sObj = new SearchBT();
		sObj.prepareTree();

		sObj.searchUsingRecur(10);
		sObj.searchUsingRecur(3);
		sObj.searchUsingRecur(0);

		// Use BFS to perform the below operations.
		// sObj.searchUsingIter(10);
		// sObj.searchUsingIter(3);
	}

	void prepareTree() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void searchUsingRecur(int element) {

		int height = getHeightBT(root);
		System.out.println("\nHeight of tree: " + height);

		boolean status = false;
		int level = height - 1;
		for(; level >= 0; level--) {
			status = getLevelUsingRecur(root, element, level);
			if(status) {
				break;
			}
		}
		if(status) {
			System.out.println("\nRECURSION: Element " + element + " is at level = " + level);	
		} else {
			System.out.println("\nRECURSION: Element "+ element + " does not exist.");
		}
	}

	boolean getLevelUsingRecur(BTNode root, 
									int element, 
										int level) {

		if(null == root) {
			return false;
		}

		if(0 == level) {
			if(element == root.data) {
				return true;
			}
		}

		return ((getLevelUsingRecur(root.left, element, level - 1)) || 
								(getLevelUsingRecur(root.right, element, level - 1)) );
	}

	int getHeightBT(BTNode root) {
		if(null == root) {
			return 0;
		}

		return 1 + Math.max(getHeightBT(root.left), getHeightBT(root.right));
	}

}