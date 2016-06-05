/**
	Question: Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1).

	Reference: http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/

	Logic:
		- Create two stacks. One stack to store the input elements and the other stack keeps track of the Minimum element for the current element. The other stack is needed to get the element in O(1).
		- For each element we push in to main stack store the min element upto this element in the other stack.
*/

class StackMin {

}