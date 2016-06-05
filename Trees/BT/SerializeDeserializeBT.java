class SerializeDeserializeBT {
	private static int MARKER = -1;
	private FileOutputStream fileOut;
    private ObjectOutputStream out;

    private FileInputStream fileIn;
    private ObjectInputStream in;

	public void prepareFile(BTNode root) {
		fileOut = new FileOutputStream("BT.ser");
		out = new ObjectOutputStream(fileOut);

		fileIn = new FileInputStream("BT.ser");
		in = new ObjectInputStream(fileIn);		
	}

	public void serialize(BTNode root) {
		if(null == root) {
			out.writeObject(null);
			return;
		}

		out.writeObject(root);
		serialize(root.left);
		serialize(root.right);
	}

	BTNode nextItem;
	public void deSerialize(BTNode root) {
		try {
			nextItem = (BTNode) in.readObject();
		} catch(EOFException eofe) {
			return;
		}
		
		root = nextItem;
		deSerialize(root.left);
		deSerialize(root.right);
	}
}