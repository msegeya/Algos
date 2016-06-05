/**
	Question: Sort a single linked list in best way.

	Reference: http://javabypatel.blogspot.in/2015/12/merge-sort-linked-list.html

	Logic: 
		- Do Merge sort. See below comments.

*/

class SortSLL {
	public SLLNode head1;
	public SLLNode head2;

	public static void main(String[] args) {
		SortSLL ssllObj = new SortSLL();
		ssllObj.initialize();
		ssllObj.sort();
	}

	public void initialize() {
		int[] input1 = {10, 1, -2, 8, 9, 10, 1};
		head1 = SLL.createSLL(head1, input1);

		int[] input2 = {5, 4, 3, 2, 1};
		head2 = SLL.createSLL(head2, input2);
	}

	public void sort() {
		SLLNode sortedList1 = doMergeSort(head1);
		SLLNode sortedList2 = doMergeSort(head2);

		System.out.println("\n Sorted Linekd List is: ");
		SLL.print(sortedList1);

		System.out.println("\n Sorted Linekd List is: ");
		SLL.print(sortedList2);		
	}

	/*
		We will apply merge sort algorithm here.
		1. Get the mid-point. Break until the mid-point by making the mid-point of next as NULL. And save the second half.
		2. Break the list into two halfs say leftHalf and rightHalf.
		3. Apply doMergeSort for leftHalf and rightHalf until there is only one element in both the halfs.
		4. Recursively merge leftHalf and rightHalf at each level.
	*/
	public SLLNode doMergeSort(SLLNode first) {
		// If the list is empty of the list has only node then return first (which can also be empty.)
		if(null == first || null == first.next) {
			return first;
		}

		SLLNode middle = getMiddleNode(first);
		SLLNode middleNext = middle.next;
		middle.next = null;

		SLLNode leftHalf = doMergeSort(first);
		SLLNode rightHalf = doMergeSort(middleNext);

		SLLNode sortedList = doMergingOfSortedLists(leftHalf, rightHalf);
		return sortedList;
	}

	/*
		Algo for merging,
		1. If leftHalf is null then return rightHalf.
		2. If rightHalf is null then return leftHalf.
		3. Take a pointer say mergedList and start adding all sorted nodes to this list.
		4. Finally return this list.
	*/
	public SLLNode doMergingOfSortedLists(SLLNode leftHalf, SLLNode rightHalf) {
		if(null == leftHalf) {
			return rightHalf;
		}

		if(null == rightHalf) {
			return leftHalf;
		}

		SLLNode mergedList = null;
		if(leftHalf.data < rightHalf.data) {
			mergedList = leftHalf;
			mergedList.next = doMergingOfSortedLists(leftHalf.next, rightHalf);
		} else {
			mergedList = rightHalf;
			mergedList.next = doMergingOfSortedLists(leftHalf, rightHalf.next);
		}

		return mergedList;
	}

	public SLLNode getMiddleNode(SLLNode first) {
		SLLNode slowPtr = first, fastPtr = first;

		while(null != slowPtr.next && null != fastPtr.next && null != fastPtr.next.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		return slowPtr;
	}
}