/**
	Question: In a cycled linked list find the start node.

	Reference: Karunmanchi,
			   Proof explanation @ https://www.youtube.com/watch?v=FkBm3NeWqak
			   SO: http://stackoverflow.com/questions/35171164/cycle-detection-algorithm-is-there-a-condition-for-tortoise-and-hare-to-enter-i

	Logic:
		- Take two pointers, slowPtr and fastPtr. slowPtr moves one step and fastPtr moves two steps at a time.
		- Since the question already says that the LL has a cycle we won't check whether there is a cycle or not.
		- But what we need here is we should find out what is the starting point of the cycle. In below example it is node 3.
		- Place slowPtr and fastPtr at node 1. Now move slowPtr and fastPtr at 1 and 2 steps pace respectively. 
		- They both will meet at a point. Then take the fastPtr and place it at the start node that is 1. Then move slowPtr and fastPtr one step at at time. The point at which these two meet is the starting point of the cycle.

	Example: 
		10 -> 20 -> 30 -> 40 -> 50 -> 60 -> 70 -> 80 
						  |				   		   |	
						  |________________________|

	NOTE: Why does this logic work? How does making fastPtr move to start and placing slowPtr at the same position works?	
		Let,
			C -> Distance from starting point of the list (node 1) to start of the loop (node 4).
			L -> Length of the loop. (40 -> 50 -> 60 -> 70 -> 80 -> 40)
			K -> Distance from coincidence point to starting point of the loop. (Suppose say fastPtr and slowPtr meet at node 		 60 then K is the distance from node 60 to start of the cycle that is node 40.)
			T -> number of times slowPtr(Tortoise) rotated before coinciding with fastPtr.
			H -> number of times fastPtr(Hare) rotated before coinciding with slowPtr.

		Let, s be the time takes for Tortoise before coincidence.
			 s = C + L * T + K  .... (1)
		Similarly for Hare the equation remains the same except it is two times faster than tortoise.
			 2s = C + L * H + K .... (2)

		Solving (1) and (2) equations,
			2(C + L * T + K) = C + L * H + K
		 => (C + K)	= L(H - 2T) .... (3) ==> (C + K) IS DISTANCE FROM START OF THE LOOP TO THE COINCIDENCE POINT.

		And from equation (3),
		 => L = (C + K)/(H - 2T) .... (4)
		
	Finally, (C + K) is the distance from start of the loop to the coincidence point. 
			 Take 2 Tortoise's and place one at start of the linked list and the other at (C + K) distance. 
			 If we consider, (H - 2T) = 1 then 
			 		==>	(C + K) = L
			 		==> C = L - K

 			 If we say (H - 2T) = 2 then
 			 		==> (C + K) = 2L 
 			 		==> C = 2L - K (But 2L is equivalent to L as it a circle.)
		
		Since both Tortoise and Hare move at the same pace they will meet at the starting point of the circle.

*/

class SLLCycleStartNode {

	private SLLNode head;

	public static void main(String[] args) {
		SLLCycleStartNode scsnObj = new SLLCycleStartNode();
		scsnObj.initialize();
		scsnObj.makeCycle();
		scsnObj.printCycleHead();
	}

	public void initialize() {
		head = SLL.createSLL();
	}

	public void makeCycle() {
		// let the cycle start node be 40.
		SLLNode cycleHead = head;
		while(40 != cycleHead.data) {
			cycleHead = cycleHead.next;
		}

		SLLNode lastNode = head;
		while(null != lastNode.next) {
			lastNode = lastNode.next;
		}

		lastNode.next = cycleHead;

		System.out.println("\nPrinting SLL with cycle.");
		SLLNode startNode = head;
		while(startNode != cycleHead) {
			System.out.print(startNode.data + " -> ");
			startNode = startNode.next;
		}

		while(startNode != lastNode) {
			System.out.print(startNode.data + " -> ");
			startNode = startNode.next;
		}
		System.out.print(startNode.data + " -> ");
		System.out.print(startNode.next.data + " ");
	}

	public void printCycleHead() {
		SLLNode slowPtr = head, fastPtr = head;
		while(null != slowPtr.next && null != fastPtr.next.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if(slowPtr == fastPtr) {
				break;
			}
		}

		fastPtr = head;
		while(slowPtr != fastPtr) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}

		System.out.println();
		System.out.println("Cycle head is: " + slowPtr.data);

	}

}