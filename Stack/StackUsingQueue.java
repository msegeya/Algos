/**
	Question: Implement a Stack using Queues.

	Reference: http://stackoverflow.com/questions/688276/implement-stack-using-two-queues

	Logic:
		- Take two queues,
			For PUSH, just push to queue-1
			For POP,
				1) If there is more than one element in queue-1 then dequeue all the elements in queue-1 to queue-2.
				2) 

*/

class StackUsingQueue {
	
	public Stack<Integer> stack = new Stack<Integer>();
	public Queue<Integer> queue_1 = new LinkedList<Integer>();
	public Queue<Integer> queue_2 = new LinkedList<Integer>();

	// Before you call this method make sure you fill the stack.
	public void stackPopUsingQueue() {
		if(stack != null && !stack.isEmpty()) {
			int poppedEle = stack.pop();
			System.out.println("Stack Popped Element is: " + poppedEle);
		}

		while(queue_1 != null && queue_1.size() > 1) {
			queue_2.add(queue_1.remove());
		}

		if(queue_1 != null && queue_1.size() == 1) {
			int poppedEle = queue_1.remove();
			System.out.println("Queue Popped Element is: " + poppedEle);

			Queue<Integer> tempQueue = queue_1;
			queue_1 = queue_2;
			queue_2 = tempQueue;
		}
	}
}