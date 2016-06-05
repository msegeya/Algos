
import java.util.*;
class PrintLevelByLevel {

	private BTNode root;
	private CBT cbtObj;

	public static void main(String[] args) {
		PrintLevelByLevel pllObj = new PrintLevelByLevel();
		pllObj.prepareTree();

		System.out.println("Using ITERATIVE: ");
		pllObj.printLevelIteratively();
		
		System.out.println("\nUsing RECURSION: ");
		pllObj.printLevelRecursively();
	}

	void prepareTree() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printLevelIteratively() {
		printLevelByLevelIter(root);
	}

	void printLevelByLevelIter(BTNode root) {
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(root);
		queue.add(null);
		int level = 0;
		while(!queue.isEmpty()) {
			BTNode poppedNode = queue.remove();
			if(null == poppedNode) {
				level++;
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				System.out.println("Element " + poppedNode.data + " is at level " + level);
				if(null != poppedNode.left) {
					queue.add(poppedNode.left);
				}

				if(null != poppedNode.right) {
					queue.add(poppedNode.right);
				}
			}
		}
	}

	void printLevelRecursively() {
		int height = 3;
		for(int level = 0; level <= height; level++) {
			System.out.println("Elements at level " + level);
			printLevelByLevelRecur(root, level);
		}
	}

	void printLevelByLevelRecur(BTNode root, 
										int level) {
		if(null == root) {
			return;
		}

		if(0 == level) {
			System.out.println(root.data);
		}

		printLevelByLevelRecur(root.left, level - 1);
		printLevelByLevelRecur(root.right, level - 1);
	}
}