import java.util.*;

class MaxMinTree {

	private CBT cbtObj;
	private BTNode root;

	public static void main(String[] args) {
		MaxMinTree mmtObj = new MaxMinTree();
		mmtObj.prepareCBT();

		mmtObj.printMaxRecur();
		mmtObj.printMaxIter();

		mmtObj.printMinRecur();
		mmtObj.printMinIter();
	}

	void prepareCBT() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printMinIter() {
		int min = getMinMaxElementInTree(root, "min");
		System.out.println("\nMin Element Iteratively: " + min);
	}

	void printMaxIter() {
		int max = getMinMaxElementInTree(root, "max");
		System.out.println("\nMax Element Iteratively: " + max);	
	}

	int getMinMaxElementInTree(BTNode root,
									String flag) {
		int initMinMax = -1;
		if("min".equals(flag)) {
			initMinMax = Integer.MAX_VALUE;
		} else {
			initMinMax = Integer.MIN_VALUE;
		}

		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BTNode poppedNode = queue.remove();
			if("min".equals(flag)) {
				if(poppedNode.data < initMinMax) {
					initMinMax = poppedNode.data;
				}
			} else {
				if(poppedNode.data > initMinMax) {
					initMinMax = poppedNode.data;
				}
			}

			if(null != poppedNode.left) {
				queue.add(poppedNode.left);
			}

			if(null != poppedNode.right) {
				queue.add(poppedNode.right);
			}
		}

		return initMinMax;
	}

	void printMinRecur() {
		int min = getMinUsingRecur(root);
		System.out.println("\nMin Element using Recursion: " + min);
	}

	int getMinUsingRecur(BTNode root) {
		int min = root.data;
		
		if(null != root.left) {
			min = Math.min(min, getMinUsingRecur(root.left));
		}

		if(null != root.right) {
			min = Math.min(min, getMinUsingRecur(root.right));
		}

		return min;
	}

	void printMaxRecur() {
		int max = getMaxUsingRecur(root);
		System.out.println("\nMax Element using Recursion: " + max);
	}

	int getMaxUsingRecur(BTNode root) {
		int max = root.data;
		
		if(null != root.left) {
			max = Math.max(max, getMaxUsingRecur(root.left));
		}

		if(null != root.right) {
			max = Math.max(max, getMaxUsingRecur(root.right));
		}

		return max;	
	}

} 