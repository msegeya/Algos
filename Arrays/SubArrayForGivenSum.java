/**
	Question: Find subarray with given sum. Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

	Reference: http://www.geeksforgeeks.org/find-subarray-with-given-sum/
	
	NOTE: There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.

	Logic: 
		- Take a variable as "sum" and initialize with the first value of the array.
		- Start from 1 and add each of the element to the "sum" and see if the sum = given sum.
		- If sum is greater than given sum then remove the first added element and move the pointer forward.
*/

class SubArrayForGivenSum {
	public static void main(String[] args) {
		int[] array = {15, 2, 4, 8, 9, 5, 10, 23};
		int sum = 23;

		int start = 0;
		int curr_sum = array[start];
		for(int i = 1; i < array.length; i++) {

			// remove the starting index elements if the curr_sum > sum.
			while(curr_sum > sum && start < i - 1) {
				curr_sum -= array[start];
				start++;
			}

			if(curr_sum == sum) {
				System.out.println("Sum = " + sum + " lies between indices " + start + " and " + (i - 1));
				return;
			}

			curr_sum += array[i];
		}

		System.out.println("No Sub Array found.");
	}
}