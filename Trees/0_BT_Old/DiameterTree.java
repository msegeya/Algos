/**
	Source: 
	http://stackoverflow.com/questions/11897088/diameter-of-binary-tree-better-design
	http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
	
	Question:
	Diameter of a tree is defined as "the number of nodes on the longest path between two leaves in a tree."

	Logic-1: O(n^2)
		- For every node,
			get height of left tree - LEFT
			get height of right tree - RIGHT
			get diameter of left tree - dLEFT
			get diameter of right tree - dRIGHT
		- Finally get the return logic is,
			return max(LEFT + RIGHT + 1, max(dLEFT, dRIGHT))

	Logic-2: O(n)
		In the abvoe logic we are calculating height for each node and we are also calculating height during diameter also.
		So instead of calculating the left and right height again we will remove them.

*/

class DiameterTree {
	private CBT cbtObj;
	private BTNode root;

	public static void main(String[] args) {
		DiameterTree dtObj = new DiameterTree();
		dtObj.prepareCBT();

		// dtObj.printDiameter();
		dtObj.printDiameterOpt();
	}

	void prepareCBT() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printDiameter() {
		int diameter = getDiameter(root);
		System.out.println("Logic-1: Diameter is: " + diameter);
	}

	int getDiameter(BTNode root) {
		if(null == root) {
			return 0;
		}
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		int ld = getDiameter(root.left);
		int rd = getDiameter(root.right);
		return Math.max(lh + rh + 1, Math.max(ld, rd));
	}


	int getHeight(BTNode root) {
		if(null == root) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	void printDiameterOpt() {
		int diameter = getDiameterOpt(root, new HeightWrapper());
		System.out.println("Logic-2: Diameter is: " + diameter);
	}

	/**
		Logic-2:
			We can optimise the above logic.
			Instead of calculating the height separatly we will calcualte it in the same recursion while calculating the diameter.
			We will call it optimised Diameter.
			
			Why do we need a wrapper class?
			Since at each level we will store the height of its children nodes such that we no need to calculate it again.

	*/
	int getDiameterOpt(BTNode root, 
							HeightWrapper wrapper) {
		if(null == root) {
			return 0;
		}

		// wrappers for height of left and right sub-tree
		HeightWrapper lWrapper = new HeightWrapper();
		HeightWrapper rWrapper = new HeightWrapper();

		// diameter of left and right sub tree.
		// At every level we get the diameter value of the left and right sub trees.
		int ld = getDiameterOpt(root.left, lWrapper);
		int rd = getDiameterOpt(root.right, rWrapper);

		// calculate height of current node.
		wrapper.height = Math.max(lWrapper.height, rWrapper.height) + 1;
		
		// diameter of root .. that is left_height + right_height + 1
		int rootDiameter = lWrapper.height + rWrapper.height + 1;

		return Math.max(rootDiameter, Math.max(ld, rd));
	}
}

class HeightWrapper {
	public int height;
}
