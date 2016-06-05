class BTNode {
	public int data;
	public BTNode left;
	public BTNode right;

	BTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	BTNode(int data, 
				BTNode left,
					BTNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}