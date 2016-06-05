/**
	Question: Reverse K nodes in a LL.

	Reference: http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

	Logic: 
		- Explained in the code comments.
*/

class ReverseKNodes {
	private SLLNode head;

	public static void main(String[] args) {
		ReverseKNodes rvnObj = new ReverseKNodes();
		rvnObj.initialize();
		rvnObj.reverseKNodes();
	}

	public void initialize() {
		head = SLL.createSLL();
	}

	public void reverseKNodes() {
		int[] input = {4};
		for(int k : input) {
			System.out.println("\n\n If k = " + k);
			doKReverse(k);	
		}
	}

	/*
		1. Get the sub-list of LL, where start is kStart and end is kEnd of length K.
		2. Save the (k + 1)th node in the LL say current.
		3. End the k length sub-list by making kEnd.next = null.
		4. Reverse sub-list where start is kStart and end is kEnd.
		5. Join the end of the reversed list which will be kStart with start of the next reversed list. 
		   For that we need to save the end of the reversed LL which we call here as tempEnd.
		6. If the reversed sub-list is the first sub-list that is parsed then we need to save the head as newHead. 
		   We will print the output starting from newHead.

	*/
	public void doKReverse(int k) {
		// For saving subset of LL of length k
		SLLNode kStart = null, kEnd = null;

		// Current node to keep track of start of each subset
		SLLNode current = null;

		// Head of the final k reverse sub-list.
		SLLNode newHead = null;

		// Reverse head of subset.
		SLLNode kReverse_Start = null;

		// to keep track of end of each subset list.
		SLLNode kReverse_End = null;

		current = head;
		while(null != current) {
			kStart = current;
			kEnd = getKthNode(kStart, k);

			// Assign current to the next node at k distance from current node.
			if(null != kEnd.next) {
				current = kEnd.next;	
			} else {
				current = null;
			}
			
			kEnd.next = null;
			kReverse_Start = SLL.reverseSLL(kStart);

			if(null == newHead) {
				newHead = kReverse_Start;
				kReverse_End = kStart;
			} else {
				kReverse_End.next = kReverse_Start;
				kReverse_End = kStart;
			}
		}

		SLL.print(newHead);

	}

	public SLLNode getKthNode(SLLNode kCurrent, int k) {
		SLLNode kPrevNode = null;
		while(null != kCurrent && k > 1) {
			kPrevNode = kCurrent;
			kCurrent = kCurrent.next;
			k--;
		}

		// If the last node is null then return the previous node.
		if(null == kCurrent) {
			// System.out.println("\nEnded before K size. So returning last node " + kPrevNode.data);
			return kPrevNode;
		} else {
			return kCurrent;	
		}
	}

}