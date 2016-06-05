/**
	Question: Given LL. Check whether there is a palindrome or not?

	Reference: http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/

	Logic: 
		- Get the Mid point of the Linked list. Keep a note of this mid-point node.
		- Break the list until mid-point and say leftList
		- Reverse the Linked list after the mid point and say rightList.
		- Now start comparing leftList and rightList. 
		- If both are same then palindrome else not.
		- Now reverse the again and join it to mid-point next.

*/

class PalindromeLL {
	private SLLNode headEven, headOdd, headNotPalin;

	public static void main(String[] args) {
		PalindromeLL pllObj = new PalindromeLL();
		pllObj.initialize();
		pllObj.checkPalindrome();
	}

	public void initialize() {
		int[] input_even = {1, 2, 3, 3, 2, 1};
		int[] input_odd = {1, 2, 3, 4, 3, 2, 1};
		int[] input_not_palin = {1, 2, 3, 4, };

		headEven = SLL.createSLL(headEven, input_even);
		headOdd = SLL.createSLL(headOdd, input_odd);
		headNotPalin = SLL.createSLL(headNotPalin, input_not_palin);
	}

	public void checkPalindrome() {
		SLLNode[] input = {headEven, headOdd, headNotPalin};

		for(SLLNode head : input) {
			isPalin(head);
		}
	}

	public void isPalin(SLLNode head) {
		int length = SLL.getLength(head);
		SLLNode midPointNode = SLL.getMidPointLL(head);
		SLLNode reverseStart = null;
		boolean isEven = false;

		if(length % 2 == 0) {
			isEven = true;
			System.out.println("\nGiven LL is of Even length.");
		} else {
			isEven = false;
			System.out.println("\nGiven LL is of Odd length.");
		}

		if(isEven) {
			reverseStart = midPointNode;
		} else {
			// If odd then we need to reverse the list from next node onwards.
			reverseStart = midPointNode.next;
		}

		// make null before the mid-point of the list.
		SLLNode endListPtr = head;
		while(endListPtr.next != midPointNode) {
			endListPtr = endListPtr.next;
		}
		endListPtr.next = null;
		System.out.println("\nEnd node of the leftHalf list is " + endListPtr.data);

		reverseStart = SLL.reverseSLL(reverseStart);

		boolean isPalindrome = true;
		SLLNode current = head, reverseHead = reverseStart;
		while(null != current && 
				current.next != midPointNode && 
					null != reverseHead) {
			if(current.data != reverseHead.data) {
				isPalindrome = false;
				break;
			}
			current = current.next;
			reverseHead = reverseHead.next;
		}

		if(isPalindrome) {
			System.out.println("LL is a Palindrome.");
		} else {
			System.out.println("LL is NOT a Palindrome.");
		}

		// NOTE: Don't just run away. We have to join back the reversed list and print it to check the original list again.
		reverseStart = SLL.reverseSLL(reverseStart);

		if(!isEven) {
			System.out.println("\n ODD list and mid-point is " + midPointNode.data);
			midPointNode.next = reverseStart;
			endListPtr.next = midPointNode;			
		} else {
			endListPtr.next = reverseStart;	
		}
		
		SLL.print(head);
	}

}