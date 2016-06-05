class DisjointNode {
	int data;
	int rank;
	DisjointNode parent;

	public DisjointNode() {}

	public DisjointNode(int src) {
		this.data = src;
		this.rank = 0;
		this.parent= this;
	}

}