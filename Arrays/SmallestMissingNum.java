/**
	Question: Given a sorted array of n integers where each integer is in the range from 0 to m-1 and m > n. Find the smallest number that is missing from the array.

	Example: Input = {0, 1, 2, 6, 9} and m = 10
			 Output is 3

			 Input: {4, 5, 10, 11}, n = 4, m = 12
			 Output is 0

	Logic-1: (Using Binary Search)
		- We can do a binary search for each element starting from 0 to m-1. Stop at the point where the element does not exist. ==> O(mlogn)

	Logic-2: (Modified Binary Search)
		NOTE: This works only for distinct numbers.
		- If the first element is not same as the index then return the first index.
		- Else get the middle index say mid,
			1) If index mid > array[mid] them do binary search of left half.
			2) Else do the binary search of right half.
*/

class SmallestMissingNum {
	public static void main(String[] args) {
		// int[] array = {0, 1, 2, 6, 9}; // 3
		int[] array = {4, 5, 10, 11}; // 0
		int m = 10;

		int result = binarySearch(array, 0, array.length - 1);
		System.out.println(result);
	}

	public static int binarySearch(int[] array, int low, int high) {
		if(low > high) {
			return high + 1;
		}

		if(low != array[low]) {
			return low;
		}

		int mid = low + (high - low) / 2;
		if(array[mid] > mid) {
			return binarySearch(array, low, mid);
		} else {
			return binarySearch(array, mid + 1, high);
		}
	}
}