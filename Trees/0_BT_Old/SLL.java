
import java.util.*;
class SLL {
	static SLLNode insert(SLLNode head, 
						int data) {
		SLLNode newNode = new SLLNode(data);

		if(head == null) {
			head = newNode;
		} else {
			SLLNode current = head;
			while(null != current.next) {
				current = current.next;
			}
			current.next = newNode;
		}

		return head;
	}

	static void print(SLLNode head) {
		System.out.println("Elements in the SLL are: ");
		SLLNode current = head;
		while(null != current) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println();
	}

	/**
		Logic for calculating the mid-value of array.
			- If the SLL length is odd, then "slow" pointer will be the mid point.
			- If the SLL length is even, then if fast.next is last then return slow.next as mid point.
	*/
	static Map<String, SLLNode> midNodeSLL(SLLNode first, 
									SLLNode last) {
		
		Map<String, SLLNode> map = new HashMap<String, SLLNode>();
		SLLNode fast = first;
		SLLNode slow = first;
		SLLNode prev = null;
		
		// If there is only one node
		if(null != first && null == last) {
			prev = first;
			slow = first;
		} else if(first.next == last) { // If only two nodes are there.
			prev = first;
			slow = last;
		} else {
			while(fast != last && fast.next != last) {
				prev = slow;
				fast = fast.next.next;
				slow = slow.next;
			}
			
			if(fast.next == last) {
				prev = slow;
				slow = slow.next;
			}
		}
		map.put("prev", prev);
		map.put("mid", slow);
		
		System.out.println("Mid point from " + first.data + " to " + last.data + " is " + slow.data);

		return map;
	}
}
