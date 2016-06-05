class Box {
	public int height;
	public int width;
	public int depth;

	public Box(int height, 
					int width, 
						int depth) {
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	public Box() { }

	static void printBoxes(Box[] boxes) {
		System.out.println("Height x Width x Depth");
		for(Box box : boxes) {
			System.out.println(box.height + " x " + box.width + " x " + box.depth);
		}
		System.out.println();
	}
}