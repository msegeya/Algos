/**
	Question: Two elements whose sum is closest to zero

	Reference: http://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/

	Logic:
		- Sort the elements.
		- Two pointers start at index 0 and end at index array.length - 1.
		- If array[start] + array[end] is negative then increment start
*/

import java.util.Arrays;

class SumCloseToZero {
	public static void main(String[] args) {
		int[] array = {1, 60, -10, 70, -80, 85};

		Arrays.sort(array);
		int start = 0;
		int end = array.length - 1;
		
		int min_sum = Integer.MAX_VALUE;
		int min_start = 0, min_end = 0;

		while(start < end) {

			if(Math.abs(array[start] + array[end]) < Math.abs(min_sum)) {
				min_sum = array[start] + array[end];
				min_start = start;
				min_end = end;
			}

			if(array[start] + array[end] <= 0) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println("Min Sum is = " + min_sum + " with elements " + array[min_start] + " and " + array[min_end]);
	}
}