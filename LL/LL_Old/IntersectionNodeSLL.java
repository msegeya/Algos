/**
	Question: Find the Intersection node  of two linked list. Say you have two linked list list_1 and list_2 as below,

		1 -> 2 -> 3 -> 4 
					     \ 6 -> 7 -> 8
			      4 -> 5 /

		Find the intersection point.

	Reference: http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
			   http://stackoverflow.com/questions/493494/make-a-negative-number-positive-in-java

	Logic: 
		- First check whether there is any intersection point or not. If there is intersection point then continue below steps else exit.
		
		- To check whether there is any intersection or not do following,
			1. Get the last node of list_1 and say it as last_1.
			2. Get the last node of list_2 and say it as last_2.
			3. Compare last_1 and last_2. If same then there is an intersection point else there is not intersection.

		NOTE: I don't think so whether the above step is necessary or not. Since anyways using the below logic if there is an intersection then we will get the intersection node else we won't. So there is no point in using the above logic.	

		- How to find the intersection point?
			1. Get the length of list_1 say length_1.
			2. Get the length of list_2 say length_2.
			3. Do length_1 - length_2 and get the absolute value of it say DIF_LENGTH. Ignore whether it is negative or positive.
			5. Take two pointers, list1_ptr and list2_ptr.
			4. If length_1 > length_2 then travserse the bigger list list_1 of steps length DIF_LENGTH using list1_ptr else traverse list_2 of length DIF_LENGTH using list2_ptr.
			5. Now, move list1_ptr and list2_ptr one step at a time and compare them. The point at which they both are same is the intersection point.
*/

class IntersectionNodeSLL {
	private SLLNode list_1, list_2;

	public static void main(String[] args) {
		IntersectionNodeSLL insllObj = new IntersectionNodeSLL();
		insllObj.initialize();

		if(insllObj.isInterThere()) {
			System.out.println("Intersection Exists.");
			insllObj.getIntersectionNode();	
		} else {
			System.out.println("No Intersection available.");
		}
	}

	public void initialize() {
		int[] input_1 = {1, 2, 3, 4, 6, 7, 8};
		list_1 = SLL.createSLL(list_1, input_1);

		SLLNode nodeData_4 = list_1;
		while(6 != nodeData_4.data) {
			nodeData_4 = nodeData_4.next;
		}

		int[] input_2 = {4, 5};
		list_2 = SLL.createSLL(list_2, input_2);
		
		// Comment below code to check "no intersection" test.
		SLLNode lastNode_2 = SLL.getLastNode(list_2);
		lastNode_2.next = nodeData_4;
		SLL.print(list_2);
	}

	public boolean isInterThere() {
		SLLNode last1_ptr = SLL.getLastNode(list_1);
		SLLNode last2_ptr = SLL.getLastNode(list_2);
		if(last1_ptr != last2_ptr) {
			return false;
		} else {
			return true;
		}
	}

	public void getIntersectionNode() {
		SLLNode list1_ptr = list_1;
		SLLNode list2_ptr = list_2;

		int length_1 = SLL.getLength(list_1);
		int length_2 = SLL.getLength(list_2);
		// Math.abs will always return positive value.
		int DIF_LENGTH = Math.abs(length_1 - length_2);

		if(length_1 >= length_2) {
			list1_ptr = traverseList(DIF_LENGTH, list_1);
		} else {
			list2_ptr = traverseList(DIF_LENGTH, list_2);
		}

		// since one of the pointer moved one step it can be that the pointer 
		// that moved might be exactly at the intersection point now.
		if(list1_ptr != list2_ptr) {
			while(null != list1_ptr.next && null != list_2.next) {
				if(list1_ptr == list2_ptr) {
					break;
				} else {
					list1_ptr = list1_ptr.next;
					list2_ptr = list2_ptr.next;
				}
			}
		}

		System.out.println("Intersection Node is " + list1_ptr.data);
	}

	public SLLNode traverseList(int dif_len, SLLNode list) {
		SLLNode traversePtr = list;
		
		while(dif_len != 0) {
			traversePtr = traversePtr.next;
			dif_len--;
		}

		return traversePtr;
	}

}