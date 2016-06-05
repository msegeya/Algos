/**
	Source: http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
	Question: Vertical sum in a BT
	
	Example: 
								1
							  /   \
							 2     3
							/ \   / \
						   4   5 6   7	
	
	We need to check the Horizontal Distance(HD) from root to all nodes. Same HD distance are the nodes which are on same vertical line. => Add them to get the sum of vertical nodes.
	
	What is HD?	How to caluculate it?
		HD is the horizaontal distance which we calculate as below,
					root is 0
					root to right node is +1
					root to left node is -1
	
	So above tree HD values are,
		HD for edge,	
					1 -> 2 = -1; 2 -> 4 = -1; 3 -> 6 = -1
					1 -> 3 = +1; 2 -> 5 = +1; 3 -> 7 = +1

	Check HD path sums for each level from root to leafs. If the HD's are equal then they are on the same vertical line. So add those nodes data.

	Example:
			1 -> 2 -> 5 (0 + (+1) + (-1) = 0) and 1 -> 3 -> 6 (0 + (-1) + (+1) = 0) have same HD results that is 0.

	Logic: 
		- We will use a Map to store the sum of all nodes of same HD value.
		- Traverse the tree in inorder traversal and save the sum in the map as,
			if the HD key already present in the map then add the current node value to the existing one and update map.
			else update the map value with the new one.
		- DO this for all the nodes.	
*/

import java.util.*;

class VerticalSumBT {
	
	private CBT cbtObj;
	private BTNode root;

	public static void main(String[] args) {
		VerticalSumBT vsbtObj = new VerticalSumBT();
		vsbtObj.prepareCBT();
		
		vsbtObj.printVerticalSum();
	}

	void prepareCBT() {
		cbtObj = new CBT();

		int[] input = {1, 2, 3, 4, 5, 6, 7};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
		cbtObj.print(root);
	}

	void printVerticalSum() {
		// We will use a map to store the key as HD value and value as vertical sum.
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int rootHD = 0;
		getVerticalSumBT(root, rootHD, map);

		System.out.println("\nAll Vertical sums: ");
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("HD value: " + entry.getKey() + " Sum: " + entry.getValue());
		}
	}

	void getVerticalSumBT(BTNode root, 
								int hd,
									Map<Integer, Integer> map) {
		if(null == root) {
			return;
		}

		getVerticalSumBT(root.left, hd - 1, map);

		int prevSum = (map.get(hd) == null ? 0 : map.get(hd));
		map.put(hd, prevSum + root.data);

		getVerticalSumBT(root.right, hd + 1, map);
	}
}