/**
	Question: Segregate even and odd nodes in a linked list such that even data appear at the front and odd data appears after even data.
		
		Example:
				Input:  17 -> 15 -> 8 -> 12 -> 10 -> 5 -> 4 -> 1 -> 7 -> 6
	  			Output: 8 -> 12 -> 10 -> 4 -> 6 -> 17 -> 15 -> 5 -> 1 -> 7

	 		 Input:  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
			 Output: 2 -> 4 -> 6 -> 8 -> 1 -> 3 -> 5 -> 7

	Reference: http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/

	Logic:
		- Get the last node of the list say lastPtr.
		- Parse the list from head.
		- If the node data is odd then move this node to the end of the list and make it point to lastPtr.
		- If the node data is even then move to next node.
		- For the first even node save it as head. We will use it to print the elements.
*/

class SegregateEvenOddLL {
	private SLLNode head2;
	private SLLNode head1;

	public static void main(String[] args) {
		SegregateEvenOddLL seoObj = new SegregateEvenOddLL();
		seoObj.initialize();
		seoObj.segregate();
	}

	public void initialize() {
		int[] input1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		head1 = SLL.createSLL(head1, input1);

		int[] input = {17, 15, 8, 12, 10, 5, 4, 1, 7, 6};
		head2 = SLL.createSLL(head2, input);
	}

	public void segregate() {
		doSegregate(head1);
		doSegregate(head2);
	}	

	public void doSegregate(SLLNode head) {
		SLLNode lastNode = SLL.getLastNode(head);
		SLLNode first = head;

		// prevNode is used to find hte last even node such that we can link it with 
		// the next to next node if the next node is an odd node.
		SLLNode prevNode = null, nextNode = null;
		
		SLLNode tempLastNode = lastNode;
		SLLNode newHead = null;

		boolean doExit = false;
		while(null != first) {
			// if does not matter even if the lastNode is odd or even. Since we already positioned all odd nodes 
			// at the end before the last node. So if the lastNode is odd then it will be the head of the odd 
			// list else it will be the tail of the even list.
			if(first == lastNode) {
				doExit = true;
			}

			// odd case
			if(first.data % 2 == 1) {
				// System.out.println("Odd data : " + first.data);
				nextNode = first.next;
				tempLastNode.next = first;
				tempLastNode = first;
				tempLastNode.next = null;
				first = nextNode;
				if(null != prevNode) {
					prevNode.next = nextNode;
				}
			} else {
				// System.out.println("Even data : " + first.data);
				if(null == newHead) {
					newHead = first;
				}

				// to keep track of the previous even node such that we can link it to the next node.
				prevNode = first;

				first = first.next;
			}

			if(doExit) {
				break;
			}
		}

		SLL.print(newHead);
	}
}