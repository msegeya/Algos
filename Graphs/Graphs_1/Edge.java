class Edge {
	int src;
	int des;
	int wgt;

	public Edge(int src, int des, int wt) {
		this.src = src;
		this.des = des;
		this.wgt = wt;
	}

	// for unweighted graph. Keep all edge weights as 1.
	public Edge(int src, int des) {
		this.src = src;
		this.des = des;
		this.wgt = 1;
	}

	public Edge() {	}
}