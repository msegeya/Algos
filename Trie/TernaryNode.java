class TernaryNode {
	Character data;
	TernaryNode left;
	TernaryNode right;
	TernaryNode middle;
	boolean isWordEnd;

	public TernaryNode(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.middle = null;
		this.isWordEnd = false;
	}

}