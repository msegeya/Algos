/**
	Question: Conenct Nodes at same level.

	Logic: 
		- Take two queues.
		- One queue is used for BFS traversal and the other is used for the same except that we don't pop any nodes.
		- After completing BFS traversal now goto queue-2 and do the following,
			- If null is encountered then reset the head to null
			- If not null then, 
				if head == null then assign head to this node.
				if head != null then assign head.next = this node.
*/

class ConnectNodesAtSameLevel {
	public void conenct(BTNode root) {
		Queue<BTNode> queue = new LinkedList<BTNode>();
		Queue<BTNode> queue_out = new LinkedList<BTNode>();

		queue.push(root);
		queue.push(null);
		int level = 1;

		while(!queue.isEmpty()) {
			BTNode pop = queue.remove();
			if(null == pop) {
				level++;

				if(!queue.isEmpty()) {
					queue.push(null);
					queue_out.push(null);
				}
			} else {
				if(null != pop.left) {
					queue.push(pop.left);
					queue_out.push(pop.left);
				} 

				if(null != pop.right) {
					queue.push(pop.right);
					queue_out.push(pop.right);
				}
			}
		}

		BTNode prev = null;
		while(!queue_out.isEmpty()) {
			BTNode pop = queue_out.remove();
			if(pop != null) {
				if(null == prev) {
					prev = pop;
				} else {
					prev.next = pop;
					prev = pop;
				}
			} else {
				prev.next = null;
			}
		}
	}
}