/**
	Question: Design a stack with operations on middle element
			How to implement a stack which will support following operations in O(1) time complexity?
			1) push() which adds an element to the top of stack.
			2) pop() which removes an element from top of stack.
			3) findMiddle() which will return middle element of the stack.
			4) deleteMiddle() which will delete the middle element.
			Push and pop are standard stack operations.

	Logic: 
		- Use a DLL to do the same. Take three pointers start, middle, end which are pointing to first, middle and last nodes.
		- For Insert, insert at the before the start pointer.
		- For Delete, Delete at the end pointer.
		- For findMiddle(), always calcualte middle pointer before insert/delete.
*/
