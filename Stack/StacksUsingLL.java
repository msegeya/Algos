/**
	Question:   Design a stack with following operations.
				a) push(Stack s, x): Adds an item x to stack s
				b) pop(Stack s): Removes the top item from stack s
				c) merge(Stack s1, Stack s2): Merge contents of s2 into s1.
				Time Complexity of all above operations should be O(1).

	NOTE: If the question says O(1) then first thing that should come in mind is either we should use hash or arrays or LL.
	In this case, if we use arrays then there it is not possible to merge in O(1).

	Logic: 
		- Implement stacks using LL.
		- When asked to merge then just take the tail of first LL and join it to the second LL's head.
*/

class StacksUsingLL {

}