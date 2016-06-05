/**
	Question: How to efficiently implement k stacks in a single array?

	Reference: http://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/

	Logic-1: Not space efficient.
		A simple way to implement k stacks is to divide the array in k slots of size n/k each, and fix the slots for different stacks, i.e., use arr[0] to arr[n/k-1] for first stack, and arr[n/k] to arr[2n/k-1] for stack2 where arr[] is the array to be used to implement two stacks and size of array be n.
		The problem with this method is inefficient use of array space. A stack push operation may result in stack overflow even if there is space available in arr[]. For example, say the k is 2 and array size (n) is 6 and we push 3 elements to first and do not push anything to second second stack. When we push 4th element to first, there will be overflow even if we have space for 3 more elements in array.

	Logic-2: (Space efficient. In simple we use store empty slots locations in the array. Such that these empty slots can be used by other stacks also.)
		The idea is to use two extra arrays for efficient implementation of k stacks in an array. This may not make much sense for integer stacks, but stack items can be large for example stacks of employees, students, etc where every item is of hundreds of bytes. For such large stacks, the extra space used is comparatively very less as we use two integer arrays as extra space.

		Following are the two extra arrays are used:
		1) top[]: This is of size k and stores indexes of top elements in all stacks.
		2) next[]: This is of size n and stores indexes of next item for the items in array arr[]. Here arr[] is actual array that stores k stacks.
		Together with k stacks, a stack of free slots in arr[] is also maintained. The top of this stack is stored in a variable ‘free’.
*/

class K_Stacks {

}