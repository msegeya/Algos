/**
	Question: Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that sorting this subarray makes the whole array sorted.

	Reference: http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/

	Example: [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60] for this the sub array is between indices 3 and 8.

	Logic: 
		- Start from left, get the index of the array where current element's right is less than element.
		- Start from right, get the index of the array where current element's left is more than element.
		- So we have two indices, start and end.
		- Get the MIN and MAX from this sub-array.
		- Start from 0th index to < "start-index" and find whether if there is any element greater than MIN and make this as start index else start index will remain the same.
		- Start from last index to > "end-index" and find whether if there is any element less than MAX and make this as end index else end index will remain the same.
*/

class MinLenOfUnSortedArray {
	public static void main(String[] args) {
		int[] array = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		// int[] array = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		printSubArray(array);
	}

	public static void printSubArray(int[] array) {
		int i = 0;
		for(i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				break;
			} 
		}

		int start = i;

		for(i = array.length - 1; i > 0; i--) {
			if(array[i] < array[i - 1]) {
				break;
			}
		}

		int end = i;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int j = start; j <= end; j++) {
			if(array[j] < min) {
				min = array[j];
			}

			if(max < array[j]) {
				max = array[j];
			}
		}

		System.out.println("Min = " + min + " and Max = " + max);

		for(i = 0; i < start; i++) {
			if(array[i] > min) {
				start = i;
				break;
			}
		}

		for(i = array.length - 1; i > end; i--) {
			if(array[i] < max) {
				end = i;
				break;
			}
		}

		System.out.println("start = " + start + " and end = " + end);		
	} 
}