/**
	Question: Replace every element with the greatest element on right side. Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array. Since there is no element next to the last element, replace it with -1. For example, if the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}

	Reference: http://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/

	Logic: 
		- Please follow the steps.
*/

class ReplaceNextGreatestEle {
	public static void main(String[] args) {
		int[] array = {16, 17, 4, 3, 5, 2};

		// Step-1: Copy the last element of the array. Since we will update the -1 for last element.
		int max_so_far = array[array.length - 1];
		array[array.length - 1] = -1;

		// Step-2: Start from last but one element and do the following.
		for(int i = array.length - 2; i >= 0; i--) {
			// save the current element
			int temp = array[i];

			// repalce the current with max_so_far element.
			array[i] = max_so_far;

			// if max_so_far is less than temp (current) then update max_so_far.
			if(max_so_far < temp) {
				max_so_far = temp;
			}
		}

		ArrayUtil.print(array, "Next Greatest Elements Array: ");
	}
}