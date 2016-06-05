/**
	Question: Find the minimum element in a sorted and rotated array. A sorted array is rotated at some unknown point, find the minimum element in it.

	Reference: http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/

	Example: 
		Input: {5, 6, 1, 2, 3, 4}
		Output: 1

	Logic: 
		- We can do it linearly. But think about it we can do it even less than the linear time.
		- Yes, we will use Binary Search .. O(logn) time.
		- The minimum element is the only element whose previous element is greater than it.
		- If the previous element is not greater than the current element then there is no rotation and the first element is the minimum element.	
*/

class FindMinEleInRotatedSortedArray {
	public static void main(String[] args) {
		// int[] array = {5, 6, 1, 2, 3, 4}; // 1
		int[] array = {1, 2, 3, 4}; // 1
		// int[] array = {2, 1}; // 1

		System.out.println(getMinEle(array));
	}

	public static int getMinEle(int[] array) {
		return doBS(array, 0, array.length - 1);
	}

	public static int doBS(int[] array, int low, int high) {
		// If the array is not rotated at all then return the 0th element.
		if(low > high) {
			return array[0];
		}

		// If the subset has only one element left then return that element.
		if(low == high) {
			return array[low];
		}

		// else for more than on element.
		int mid = low + (high - low) / 2;

		// Check whether the mid element is greater than the (mid + 1) element. Then return (mid + 1) element.
		if(mid < high && array[mid] > array[mid + 1]) {
			return array[mid + 1];
		}

		// Check whether the mid element is itself the minimum element.
		if(mid > low && array[mid] < array[mid - 1]) {
			return array[mid];
		}

		// If all the above conditions fail then we need to decide to which side we have to go .. either left/right.
		// If the mid is less than high then we need to search left since we are looking for minimum element.
		// Else go right.
		if(array[mid] < array[high]) {
			return doBS(array, low, mid -1);
		}

		return doBS(array, mid + 1, high);
	}

}