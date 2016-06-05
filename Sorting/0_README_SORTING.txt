- Insertion Sort - O(n^2) : Insertion sort is the algorithm of choice either when the data is nearly sorted (because it is adaptive) or when the problem size is small.
InsertionSort.java

- Selection Sort - O(n^2) : One advantage of selection sort is that it requires only  nn  write operations.  If we have a system where write operations are extremely expensive and read operations are not, then selection sort could be ideal.
SelectionSort.java

- Quick Sort - O(nlogn) : Quick sort is better than Merge sort it terms of space other than that both of them takes the same time complexity O(nlogn).
  QuickSort.java

- Merge Sort - O(nlogn) : Mergesort is quicker when dealing with linked lists. This is because pointers can easily be changed when merging lists. It only requires one pass (O(n)) through the list. If the data that needs to be sorted does not fit in main memory then prefer Merge Sort.
  MergeSort.java

- External Sorting - If the RAM size is 3 and the total elements that need to be sorted are 10 then take 3 elements at a time and start merging them in terms of size 3.

- Heap Sort - O(nlogn)
	Use priority queue to do this.

- Heap Sort vs Quick Sort:
Quick Sort: It almost doesn't do unnecessary element swaps. Swap is time consuming.
Heap Sort: Even if all of your data is already ordered, you are going to swap 100% of elements to order the array.
So Quick sort is usually faster than Heap sort.

- Heap Sort Vs Merge Sort:

- QuickSelect
	Sometimes we don't need to sort the entire array. Suppose say we need to find median of an array of numbers. What we usually do is sort the entire array and if the array length is odd then return the middle element else return the average of middle two elements. So for this we no need to sort all the elements, we just need to do sorting until a particular index (in this case it is the mid index of the array.
  QuickSelect.java