http://www.geeksforgeeks.org/heap/

Binary Heap
Heap.java

Time Complexity of building a heap O(nlogn)

Applications of Heap Data Structure (NOT NECESSARY)

Why is Binary Heap Preferred over BST for Priority Queue?
For sorting, Faster since it is usign arrays, no extra pointers.

Binomial Heap (http://www.geeksforgeeks.org/binomial-heap-2/)
A Binomial Tree of order 0 has 1 node. A Binomial Tree of order k can be constructed by taking two binomial trees of order k-1, and making one as leftmost child of other. A Binomial Heap is a set of Binomial Trees where each Binomial Tree follows Min Heap property. And there can be at-most one Binomial Tree of any degree

Fibonacci Heap (http://www.geeksforgeeks.org/fibonacci-heap-set-1-introduction/)
Fibonacci Heap is a collection of trees with min-heap or max-heap property. In Fibonacci Heap, trees can can have any shape even all trees can be single nodes 
(This is unlike Binomial Heap where every tree has to be Binomial Tree).

Heap Sort
Heap.java --> Check delete and percolateDown method.

K’th Largest Element in an array
Heap.java --> Construct MAX_Heap and start deleting and then do percolateDown until k times. kth deletion is kth largest element.
Another way, "SelectionSort". (http://stackoverflow.com/a/251821/967638)

Sort an almost sorted array
Insertion Sort works best for almost sorted arrays. See InsertionSort.java in Sorting folder.
Refer: 	http://stackoverflow.com/a/220054/967638s
		http://www.sorting-algorithms.com/

Tournament Tree (Winner Tree) and Binary Heap
Refer External sorting in Sorting folder. It's kinda of Tournament appl. 

Check if a given Binary Tree is Heap?
IsBSTHeap.java

How to check if a given array represents a Binary Heap?
Simple. We know heap values are stored at postions 0, 2 * index + 1, 2 * index + 2. Recursively check whether parent is >= each child.
IsArrayHeap.java

Print all elements in sorted order from row and column wise sorted matrix
We have already done this model. Here every row is sorted and every column is sorted. So consider either rows or columns as arrays.
Merge them like the way we have done for "MergeKSortedArrays.java"

Connect n ropes with minimum cost
ConnectRopes.java

Design an efficient data structure for given operations
Too Complex. But most of the features here can be implemented using Heaps.

Merge k sorted arrays | Set 1
MergeKSortedArrays.java

Sort numbers stored on different machines
Just like K sorted arrays but this time inputs are present in different machines.
I think we can do the same as MergeKSortedArrays.java