/**
	Question: Merge Sort --> O(nlogn)

	Reference:  http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
				http://stackoverflow.com/questions/7878768/when-to-use-merge-sort-and-when-to-use-quick-sort

	When to use?
		- Mergesort is quicker when dealing with linked lists. This is because pointers can easily be changed when merging lists. It only requires one pass (O(n)) through the list. If the data that needs to be sorted does not fit in main memory then prefer Merge Sort.		
		- Quicksort's in-place algorithm requires the movement (swapping) of data. While this can be very efficient for in-memory dataset, it can be much more expensive if your dataset doesn't fit in memory. The result would be lots of I/O.

	Merge Sort Vs Quick Sort:
		1) - If we have all the data present in-place then prefer Quick sort. This case is always not possible. 
		   - If the data that needs to be sorted does not fit in main memory then prefer Merge Sort. 
		2) - Merge sort is slower than Quick sort since we need to copy all the elements into the temp array.   

	Logic: (Refer Merge_Sort.png)
		- Start initially with 	low to high where low index is 0 and high index is last element position.
		- Using recursion, split the array into equal parts such that low < high.
		- Now merge each splited part that we got from above step.
		- How to merge?
			- We will have an helper array and we will copy all the elements that are present between low and high.
			- Initialize i with low and j with high.
			- Use helper array, Compare low pos value with high pos value and see if low is less than high if so then just copy the minimum value to the ***original array***.
			- Do this for all the merges.
*/


class MergeSort {

	public static int[] helper;
	public static int[] array;

	public static void main(String[] args) {
		System.out.println("******* Merge Sort ********");
		array = new int[6];
		array[0] = 23;
		array[1] = 42;
		array[2] = 4;
		array[3] = 16;
		array[4] = 8;
		array[5] = 15;
		SortUtil.print(array, SortUtil.BEFORE_SORTING);
		helper = new int[array.length];
		sort();
	}

	public static void sort() {
		int low = 0, high = array.length - 1;
		mergeSort(low, high);
		SortUtil.print(array, SortUtil.AFTER_SORTING);
	}

	public static void mergeSort(int low, int high) {
		if(low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	public static void merge(int low, int mid, int high) {
		// first copy the contents from low to high
		for(int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;

		// As we have already copied all the necessary elements that is from low pos to high pos into the helper array.
		// We will only use the helper array for comparisons.
		// we only need to check from low to high.
		// NOTE: Put the compared elements into the original array.
		while(i <= mid && j <= high) {
			if(helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
				k++;
			} else {
				array[k] = helper[j];
				j++;
				k++;
			}	
		}

		// Finally if there are any remaining elements left in the left array then just copy them to the original array.
		while(i <= mid) {
			array[k] = helper[i];
			i++;
			k++;
		}
	}
}