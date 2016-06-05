/**
	Source: http://algorithms.tutorialhorizon.com/check-if-one-binary-is-mirror-tree-of-another-binary-tree/	
	Question: Check whether a tree is mirror to another tree or not.
	
	Please refer MirrorOfBT.java for "Creating a mirror for a BT."

	Logic: 
		- Get tree say T1.
		- Get tree and construct a mirror say T2.
		- Compare T1 with T2. The logic here is same as Checking whether two BT's are Identical or not ==> See IdenticalTreesOrNot.java
*/

class CheckMirrorOfTrees {
	
	private CBT cbtObj;

	private BTNode root1;
	private BTNode root2;

	public static void main(String[] args) {
		CheckMirrorOfTrees cmtObj = new CheckMirrorOfTrees();
		cmtObj.prepareCBT();
		cmtObj.checkMirror();
	}

	void prepareCBT() {
		cbtObj = new CBT();
		
		int[] input1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input1) {
			root1 = cbtObj.insert(root1, data);
		}
		cbtObj.print(root1);

		int[] input2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		for(int data : input2) {
			root2 = cbtObj.insert(root2, data);
		}
		cbtObj.print(root2);

		System.out.println("Do Mirroring of this tree.");
		MirrorOfBT mbtObj = new MirrorOfBT();
		root2 = mbtObj.getMirrorBT(root2);
		cbtObj.print(root2);
	}

	void checkMirror() {
		boolean status = checkMirrorBT(root1, root2);
		if(status) {
			System.out.println("Trees are mirror to each other.");	
		} else {
			System.out.println("Trees are NOT mirrors to each other.");
		}
	}

	boolean checkMirrorBT(BTNode root1, BTNode root2) {
		if(null == root1 && null == root2) {
			return true;
		}

		if(null != root1 && null != root2) {
			return ((root1.data == root2.data) &&
						(checkMirrorBT(root1.left, root2.right)) &&
							(checkMirrorBT(root1.right, root2.left)));			
		} else {
			return false;
		}
	}
}