class SLL {

	public static void main(String[] args) {
		createSLL();
	}

	static SLLNode createSLL() {
		SLLNode head = null;
		int[] input = {10, 20, 30, 40, 50, 60, 70, 80};
		for(int data : input) {
			head = insert(head, data);
		}
		print(head);

		return head;
	}

	static SLLNode createSLL(SLLNode head, int[] input) {
		for(int item : input) {
			SLLNode newNode = new SLLNode(item);
			if(head == null) {
				head = newNode;
			} else {
				SLLNode current = head;
				while(null != current.next) {
					current = current.next;
				}
				current.next = newNode;		
			}
		}

		print(head);

		return head;
	}

	static SLLNode insert(SLLNode head, int data) {
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

	static SLLNode getLastNode(SLLNode head) {
		SLLNode lastNode = head;

		if(null == lastNode) {
			System.out.println("Linked List is empty.");
			return null;
		}

		while(null != lastNode.next) {
			lastNode = lastNode.next;
		}

		System.out.println("\nLinked List LAST node is " + lastNode.data);
		return lastNode;
	}

	static void print(SLLNode head) {
		if(null == head) {
			System.out.println("SLL is empty.");
			return;
		}
		
		System.out.println("\nElements in the SLL are: ");
		SLLNode current = head;
		while(null != current) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
	}

	static void print(SLLNode head, String msg) {
		System.out.println();
		if(null == head) {
			System.out.println("SLL is empty.");
			return;
		}
		
		System.out.println(msg);
		SLLNode current = head;
		while(null != current) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
	}

	static void printCycle(SLLNode head) {
		if(null == head) {
			System.out.println("SLL is Empty.");
			return;
		}

		System.out.println("\nElements in cycled linked list are: ");

		SLLNode current = head.next;
		System.out.print(head.data + " -> ");

		while(null != current && current != head) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
	}

	static int getLength(SLLNode head) {
		SLLNode current = head;
		int count = 0;

		while(null != current) {
			count++;
			current = current.next;
		}

		return count;
	}

	static SLLNode makeCycleLL(SLLNode head) {
		System.out.println();
		if(null == head) {
			System.out.println("No List. Cycle not possible.");
			return null;			
		}

		SLLNode current = head;
		while(null != current.next) {
			current = current.next;
		}
		current.next = head;

		System.out.println("Cycle created. With Head Node as " + head.data + " and last Node as " + current.data);

		return head;
	}

	static boolean isCycle(SLLNode head) {
		if(null == head) {
			return false;
		}	

		SLLNode slowPtr = head, fastPtr = head;
		boolean isCycle = false;
		while(null != slowPtr.next && 
					null != fastPtr.next && 
						null != fastPtr.next.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if(slowPtr == fastPtr) {
				isCycle = true;
				break;
			}
		}

		System.out.println();
		if(isCycle) {
			System.out.println("LL has a cycle.");
		} else {
			System.out.println("LL has NO cycle.");
		}

		return isCycle;
	}

	static SLLNode reverseSLL(SLLNode head) {
		SLLNode current = head, prevNode = null, nextNode = null;

		while(null != current) {
			nextNode = current.next;
			current.next = prevNode;
			prevNode = current;
			current = nextNode;
		}

		String msg = "Reverse of a LL is: ";
		print(prevNode, msg);

		return prevNode;
	}

	static SLLNode getMidPointLL(SLLNode head) {
		SLLNode slowPtr = head, fastPtr = head;
		SLLNode midPointNode = null;

		while(null != slowPtr.next && 
					null != fastPtr.next &&
						null != fastPtr.next.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		if(null == fastPtr.next) {
			midPointNode = slowPtr;
		} else {
			midPointNode = slowPtr.next;
		}

		System.out.println("\nMid Point of given node is: " + midPointNode.data);
		return midPointNode;
	}

	static void printDataAndRandom(SLLNode list, String msg) {
		SLLNode current = list;

		System.out.println();
		System.out.println(msg);
		while(null != current) {
			System.out.print("Data is " + current.data);
			System.out.print("  Random Ptr is " + (current.random == null ? null : current.random.data));
			System.out.println();
			current = current.next;
		}
	}
}