/**
	Source: 
		http://www.geeksforgeeks.org/tree-isomorphism-problem/
		http://stackoverflow.com/questions/742605/what-does-it-mean-for-two-binary-trees-to-be-isomorphic
	
	Question: Check if two trees are Isomorphic or not.

	What does Isomorphic mean?
		Isomorphic mean same shape. Don't assume shape in this case as physical shape. 
		In mathematics two structures are isomorphic if their properties are preserved regardless of their expression.
	
	What are Isomorphic trees?
		By swapping left and right children of a number of nodes .. it means any number of nodes at any level can have their children swapped.
		In simple, at any level under every parent its children can be swapped. 
		For the children who are present under the same parent of both the trees are equal even though they are not in the same order then we can say that the tree is Isomorphic.
		So by Isomorphic definition, the property of the tree remains same.

	Logic: Recursive  
		- For each parent in both trees we have to check the immediate children.
		- Following conditions must hold good.	
			The left child in tree-1 may be left or right child of tree-2.
		 	The right child in tree-1 may be left or right child of tree-2.
		 	If any of the above node is null then the other tree node should also be null.
		- If the above condition passes then return true else return false.	
*/

import java.util.*;

class IsomorphicBT {
	
	private CBT cbtObj;
	
	private BTNode root1;
	private BTNode root2;

	public static void main(String[] args) {
		IsomorphicBT isoObj = new IsomorphicBT();
		
		isoObj.prepareCBT();

		isoObj.print();

		isoObj.printIsomorphic();
	}

	void prepareCBT() {
		cbtObj = new CBT();
		int[] input1 = {1, 2, 3, 4, 5, 6, 7, 8};

		int parent = -1;
		boolean leftRightFlag = false;

		for(int data : input1) {
			Map<String, String> map = getParentAndSideTree1(data);
			parent = Integer.parseInt(map.get("parent"));
			leftRightFlag = Boolean.valueOf(map.get("side"));
			root1 = cbtObj.insert(root1, data, parent, leftRightFlag);
		}

		int[] input2 = {1, 3, 2, 6, 4, 5, 8, 7};
		for(int data : input2) {
			Map<String, String> map = getParentAndSideTree2(data);
			parent = Integer.parseInt(map.get("parent"));
			leftRightFlag = Boolean.valueOf(map.get("side"));
			root2 = cbtObj.insert(root2, data, parent, leftRightFlag);
		}
	}

	void print() {
		cbtObj.print(root1);
		cbtObj.print(root2);
	}

	void printIsomorphic() {
		boolean status = checkIsomorphic(root1, root2);
		if(status) {
			System.out.println("Both trees are Isomorphic.");
		} else {
			System.out.println("Both trees are NOT Isomorphic.");
		}
	}

	boolean checkIsomorphic(BTNode root1, 
								BTNode root2) {
		// If both the nodes are null then return true.
		if(null == root1 && null == root2) {
			return true;
		}

		// If either of the nodes are null then return false.
		if(null == root1 || null == root2) {
			return false;
		} else {
			return (
					(checkIsomorphic(root1.left, root2.left) && checkIsomorphic(root1.right, root2.right)) || 
							(checkIsomorphic(root1.left, root2.right) && checkIsomorphic(root1.right, root2.left))
				);	
		}
	}

	Map<String, String> getParentAndSideTree1(int data) {
		Map<String, String> map = new HashMap<String, String>();
		
		if(data == 2) {
			map.put("parent", "1");
			map.put("side", "false");
		} else if(data == 3) {
			map.put("parent", "1");
			map.put("side", "true");
		} else if(data == 4) {
			map.put("parent", "2");
			map.put("side", "false");
		} else if(data == 5) {
			map.put("parent", "2");
			map.put("side", "true");
		} else if(data == 6) {
			map.put("parent", "3");
			map.put("side", "false");
		} else if(data == 7) {
			map.put("parent", "5");
			map.put("side", "false");
		} else if(data == 8) {
			map.put("parent", "5");
			map.put("side", "true");
		} else { // for root.
			map.put("parent", "0");
			map.put("side", "false");
		}

		return map;
	}

	Map<String, String> getParentAndSideTree2(int data) {
		Map<String, String> map = new HashMap<String, String>();
		
		if(data == 2) {
			map.put("parent", "1");
			map.put("side", "true");
		} else if(data == 3) {
			map.put("parent", "1");
			map.put("side", "false");
		} else if(data == 4) {
			map.put("parent", "2");
			map.put("side", "false");
		} else if(data == 5) {
			map.put("parent", "2");
			map.put("side", "true");
		} else if(data == 6) {
			map.put("parent", "3");
			map.put("side", "true");
		} else if(data == 7) {
			map.put("parent", "5");
			map.put("side", "true");
		} else if(data == 8) {
			map.put("parent", "5");
			map.put("side", "false");
		} else { // for root.
			map.put("parent", "0");
			map.put("side", "false");
		}

		return map;
	}
}
