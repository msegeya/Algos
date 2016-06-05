/**
	Source: 
		http://stackoverflow.com/questions/1008513/how-to-merge-two-bsts-efficiently
		http://www.geeksforgeeks.org/merge-two-balanced-binary-search-trees/

	Question: Union of two BST's to a balanced BST. (aka Merge two Binary trees.)

	Logic: 
		- Flaten the two BST by traversing inorder.
		- Merge the above two sorted lists to a single sorted lists.
		- Now we got the sorted list, (Please see SLLtoBST.java for converting a sorted SLL to balanceed BST)
			- Get the middle of the sorted list and make it as root.
			- Recurse through left and right halfs of the root and do the same as above.
			- The resulting will be balanced BST.

	Example: 
				   100						80
			  	  /   \                   /    \
				 50   300                40    20
				/  \         
			   30  70             
*/

import java.util.*;

class UnionOf2BST {

	private BST bstObj;

	private BTNode root1;
	private BTNode root2;
	private BTNode root;

	private SLLNode head1;
	private SLLNode head2;

	public static void main(String[] args) {
		UnionOf2BST ubsObj = new UnionOf2BST();
		ubsObj.prepareSLL();

		ubsObj.makeBST();
	}

	void prepareSLL() {
		bstObj = new BST();
		int[] input = {100, 50, 300, 30, 70};
		for(int data : input) {
			root1 = bstObj.insert(root1, data);
		}
		bstObj.print(root1);

		int[] input2 = {80, 40, 20};
		for(int data : input2) {
			root2 = bstObj.insert(root2, data);
		}
		bstObj.print(root2);		
	}

	void makeBST() {
		List<SLLNode> list1 = getListUsingBST(root1);
		List<SLLNode> list2 = getListUsingBST(root2);

		List<SLLNode> resultList = mergeTwoSortedLists(list1, list2);
		printList(resultList);

		root = makeBSTUsingMergedList(root, resultList, 0, resultList.size() - 1);
		bstObj.print(root);
	}

	BTNode makeBSTUsingMergedList(BTNode root, 
										List<SLLNode> list, 
											int start, 
												int end) {
		if(start > end) {
			return null;
		}

		if(start == end) {
			BTNode node = new BTNode(list.get(start).data);
			return node;
		}

		int midpointIndex = getMidPoint(start, end);
		BTNode newNode = new BTNode(list.get(midpointIndex).data);

		newNode.left = makeBSTUsingMergedList(newNode.left, list, start, midpointIndex - 1);
		newNode.right = makeBSTUsingMergedList(newNode.right, list, midpointIndex + 1, end);

		return newNode;
	}

	/**
		Mid point calculation is little tricky.
		If,
			(start + end) is even ==> mid is (start + end)/2
			(start + end) is even ==> mid is (start + end)/2 + 1
	*/
	int getMidPoint(int start, 
						int end) {
		int mid = (start + end) / 2;

		if(start == 0) {
			mid = mid + 1;
		} else if((start + end) % 2 == 0) {
			mid = mid;
		} else if((start + end) % 2 == 1) {
			mid = mid + 1;
		}

		System.out.println("start = " + start + " end = " + end + " mid = " + mid);	
		return mid;
	}

	List<SLLNode> getListUsingBST(BTNode root) {
		List<SLLNode> list = new ArrayList<SLLNode>();
		convertBSTtoSLL(root, list);
		printList(list);
		return list;
	}

	void convertBSTtoSLL(BTNode root,
								List<SLLNode> list) {
		if(null == root) {
			return;
		} else {
			convertBSTtoSLL(root.left, list);
			list.add(new SLLNode(root.data));	
			convertBSTtoSLL(root.right, list);
		}
	}

	void printList(List<SLLNode> list) {
		if(null != list) {
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).data + " -> ");
			}
		}
		System.out.println();
	}

	List<SLLNode> mergeTwoSortedLists(List<SLLNode> list1, 
											List<SLLNode> list2) {
		List<SLLNode> resultList = new ArrayList<SLLNode>();
		
		int i = 0;
		int j = 0;
		int list1Length = list1.size();
		int list2Length = list2.size();

		while(i < list1Length && j < list2Length) {
			if(list1.get(i).data <= list2.get(j).data) {
				resultList.add(list1.get(i));
				i++;
			} else {
				resultList.add(list2.get(j));
				j++;
			}
		}

		if(i < list1Length) {
			while(i < list1Length) {
				resultList.add(list1.get(i));
				i++;
			}
		} else {
			while(j < list2Length) {
				resultList.add(list2.get(j));
				j++;
			}
		}
		return resultList;
	}

}