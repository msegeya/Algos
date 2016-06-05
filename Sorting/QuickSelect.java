/**
	Question: Quick Select. Some time we no need to sort the entire data. We can do it until a particular index. 
			  Example finding a median. In this we need to find the middle element (if array is odd) and further we don't need to sort the list. In these cases we can use QuickSelect algorithm.
			  Just know for which index will give you the result and do a QuickSelect for that index.

	Reference: http://www.geekviewpoint.com/java/search/quickselect

	Logic: (A bit tricky.)
		- Get the pivot from low to high.
			1) Randomly get the pivot value between low to high.
			2) Swap the value between pivot and high.
			3) for each value i = low to high, if array[i] > array[high] then swap value at i and low.
			4) Increment low
			5) Swap value at low and high.
			6) Finally return low.
		- If the pivot index is what is we are looking then return the array value at pivot.
		- Else if
			1) If pivot is less than given index then do the above procedure from pivot + 1 to high
			2) Else do the same procedure from low to pivot - 1.	
*/

import java.util.*;

class QuickSelect {
	
	public static void main(String[] args) {
		System.out.println("******* QuickSelect Sort ********");
		int[] array = {23, 42, 4, 16, 8, 15};
		SortUtil.print(array, SortUtil.BEFORE_SORTING);
		sort(array);
	}

	static void sort(int[] array) {
		for(int index = array.length; index > 0; index--) {
			int k = quickSelect(array, index);
			System.out.println("Sorted array will have " + k + " at index " + index);
		}
	}

	static int quickSelect(int[] array, int k) {
		return quickSelect(array, 0, array.length - 1, k - 1);
	}

	static int quickSelect(int[] array, int low, int high, int k) {
		if(low <= high) {
			int pivot = partition(array, low, high);

			if(pivot == k) {
				return array[k];
			}

			if(pivot > k) {
				return quickSelect(array, low, pivot - 1, k);
			} else {
				return quickSelect(array, pivot + 1, high, k);
			}
		}

		return Integer.MIN_VALUE;
	}

	static int partition(int[] array, int low, int high) {
		int pivot = low + new Random().nextInt(high - low + 1);
		SortUtil.swap(array, high, pivot);

		for(int i = low; i < high; i++) {
			if(array[i] > array[high]) {
				SortUtil.swap(array, i, low);
				low++;
			}
		}

		SortUtil.swap(array, low, high);
		return low;
	}
}