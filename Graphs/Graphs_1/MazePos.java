class MazePos {
	int r;
	int c;
	boolean visited;
	char data;

	// Only used in BFS. To print the path from source to destination.
	MazePos parent;

	public MazePos(int r, int c, char ch) {
		this.r = r;
		this.c = c;
		this.visited = false;
		this.data = ch;
		this.parent = null;
	}
}