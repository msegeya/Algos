class IdenticalTreesOrNot {

	private CBT cbtObj;
	
	private BTNode root1;
	private BTNode root2;

	public static void main(String[] args) {
		IdenticalTreesOrNot itObj = new IdenticalTreesOrNot();
		itObj.prepareCBT();
		itObj.printCheck();	
	}

	void prepareCBT() {
		cbtObj = new CBT();
		
		int[] input1 = {1, 2, 3, 4, 5, 6, 7};
		for(int data : input1) {
			root1 = cbtObj.insert(root1, data);
		}

		int[] input2 = {1, 2, 3, 4, 5, 6};
		for(int data : input2) {
			root2 = cbtObj.insert(root2, data);
		}
	}

	void printCheck() {
		boolean status = doCheck(root1, root2);
		if(status) {
			System.out.println("Two trees are identical.");
		} else {
			System.out.println("Two trees are NOT identical.");
		}
	}

	boolean doCheck(BTNode root1,
						BTNode root2) {
		if(null == root1 && null == root2) {
			return true;
		}

		if(null != root1 && null != root2) {

			return ((root1.data == root2.data) &&
						doCheck(root1.left, root2.left) && 
							doCheck(root1.right, root2.right));
		} else {
			return false;
		}
	}

}