/**
	Question: Find a triplet that sum to a given value. Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet present in array, then print the triplet and return true. Else return false. 

	Reference: http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/

	Logic: O(n^2)
		- Sort the array.
		- For each element from left, 
			#) Substract it from the sum.
			#) Now search from next index after element to end of the array by placing two pointers one at next element and the other at the end.
			#) If sum is less than the actual sum then start++ else end--.
		- Do this until the last element.
*/

import java.util.Arrays;

class TripletSum {
	public static void main(String[] args) {
		int[] array = {1, 4, 45, 6, 10, 8};
		int sum = 22;

		// sort
		Arrays.sort(array);
		// ArrayUtil.print(array, "After Sorting	");

		int rem_sum = 0;
		for(int i = 0; i < array.length; i++) {
			rem_sum = sum - array[i];

			int start = i + 1;
			int end = array.length - 1;
			while(start < end  && start < array.length) {
				int cur_sum = array[start] + array[end];

				if(cur_sum < rem_sum) {
					start++;
				} else if(cur_sum > rem_sum) {
					end--;
				} else {
					System.out.println("Elements " + array[i] + ", " + 
											array[start] + ", " + array[end] + " will give sum " + sum);
					return;
				}
			}
		}
	}
}