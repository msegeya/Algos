
import java.util.*;
class HeightBT {
	private BTNode root;
	private CBT cbtObj;

	public static void main(String[] args) {
		HeightBT hObj = new HeightBT();
		hObj.prepareTree();
		hObj.printHeightRecursively();
		hObj.printHeightIter();
	}

	void prepareTree() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printHeightRecursively() {
		int height = getHeightOfBTRecur(root);
		System.out.println("Height of BT using Iterative is: " + height);
	}

	int getHeightOfBTRecur(BTNode root) {
		if(null == root) {
			return 0;
		}

		return 1 + Math.max(getHeightOfBTRecur(root.left), getHeightOfBTRecur(root.right));
	}

	void printHeightIter() {
		int height = getHeightOfBTIter(root);
		System.out.println("Height of BT using Recursion is: " + height);
	}

	int getHeightOfBTIter(BTNode root) {
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(root);
		queue.add(null);
		int level = 1;
		while(!queue.isEmpty()) {
			BTNode poppedNode = queue.remove();
			if(null == poppedNode) {
				if(!queue.isEmpty()) {
					queue.add(null);
					level++;
				}
			} else {
				// System.out.println("Element " + poppedNode.data + " is at level " + level);
				if(null != poppedNode.left) {
					queue.add(poppedNode.left);
				}

				if(null != poppedNode.right) {
					queue.add(poppedNode.right);
				}
			}
		}

		return level;
	}

}