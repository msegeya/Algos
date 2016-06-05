/**
	Question: Split circular LL into two equal parts.

	Reference: http://www.geeksforgeeks.org/split-a-circular-linked-list-into-two-halves/

	Logic: 
		- Check it the LL is cycle or not. If yes, then follow below procedure.
		- Take two pointers slowPtr, fastPtr. 
		- Start from a point say it as head. Initialize both pointers to head.
		- Move slowPtr one step and fastPtr two steps. Traverse the list until fastPtr.next or fastPtr.next.next is not equal to head.
		- Split the List as two parts,
			- Part 1, from head to slowPtr
			- Part 2, from slowPtr.next to fastPtr.next if fastPtr.next.next is head else until fastPtr
		- Print both the lists.
*/

class SplitCircularLL {

	private SLLNode head_even, head_odd;

	public static void main(String[] args) {
		SplitCircularLL scllObj = new SplitCircularLL();
		scllObj.initialize();
		scllObj.splitLL();	
	}

	public void initialize() {
		head_even = SLL.createSLL();
		head_even = SLL.makeCycleLL(head_even);

		// odd length input
		int[] input_odd = {1, 2, 3, 4, 5};
		head_odd = SLL.createSLL(head_odd, input_odd);
		head_odd = SLL.makeCycleLL(head_odd);
	}

	public void splitLL() {
		if(SLL.isCycle(head_even)) {
			doSplit(head_even);
		} else {
			System.out.println("No Cycle. Cannot split the list.");
		}
		
		if(SLL.isCycle(head_odd)) {
			doSplit(head_odd);
		} else {
			System.out.println("No Cycle. Cannot split the list.");
		}
	}


	public void doSplit(SLLNode head) {
		SLLNode list_1 = null, list_2 = null;
		SLLNode slowPtr = head, fastPtr = head;

		while(head != slowPtr.next && 
					head != fastPtr.next && 
						head != fastPtr.next.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		// Save the start of second list.
		list_2 = slowPtr.next;
		// make slowPtr next as null such that it first list will be ended with a null.
		slowPtr.next = null;

		// start of first list.
		list_1 = head;

		// If the next node after fastPtr is head then remain as it is else move fastPtr to next node.
		// fastPtr will be the last node for second list.
		if(fastPtr.next.next == head) {
			fastPtr = fastPtr.next;
		}

		// make fastPtr next as null such that it second list will be ended with a null.
		fastPtr.next = null;
		
		SLL.print(list_1);
		SLL.print(list_2);
	}

}