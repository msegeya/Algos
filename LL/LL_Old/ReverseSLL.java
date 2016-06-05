/**
	Question: Reverse a SLL

	Reference: Own. You can find it in Karumanchi and other sites also.
			   http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/

	Logic: First do Iterative then you will get a better idea about Recursive.
		Using Iterative:
			- Take three pointers first, prevNode, nextNode. Where prevNode will keep track of previous node and nextNode will 	  keep track of next nodes. 
			- Initially first = head, prevNode = null, nextNode = null.
			- first.next should point to null which is prevNode but before doing that we should keep track of original fist.next so we need to save it in nextNode => nextNode = first.next;
			- Do the above step until fisrt != null.

		Using Recursive:
			- Same as above but instead of doing it in a loop call the method recursively.
*/

class ReverseSLL {
	
	private SLLNode head;

	public static void main(String[] args) {
		ReverseSLL rsllObj = new ReverseSLL();
		rsllObj.initialize();
		rsllObj.doReverse();
	}

	public void initialize() {
		head = SLL.createSLL();
	}

	public void doReverse() {
		usingRecursion();
		// usingIterative();
	}

	public void usingIterative() {
		SLLNode first = head;

		SLLNode prevNode = null, nextNode = null;
		while(null != first) {
			nextNode = first.next;
			first.next = prevNode;
			prevNode = first;
			first = nextNode;
		}

		SLL.print(prevNode);
	}

	public void usingRecursion() {
		SLLNode prevNode = null, nextNode = null, first = head;
		doRecursively(first, prevNode);
	}

	public void doRecursively(SLLNode first, 
									SLLNode prevNode) {
		if(null == first) {
			SLL.print(prevNode);
			return;
		} 

		SLLNode nextNode = first.next;
		first.next = prevNode;
		prevNode = first;
		first = nextNode;

		doRecursively(first, prevNode);
	}

}