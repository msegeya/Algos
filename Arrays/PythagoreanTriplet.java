/**
	Question: Pythagorean Triplet in an array. Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a^2 + b^2 = c^2

	Reference: http://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/

	Logic: 
		- Do square of every number.
		- Sort the array.
		- Now do the same way as we have done in TripletSum.java
			For each element, check the sum of other two elements in the right whether their sum is equal to current element.
*/

import java.util.Arrays;

class PythagoreanTriplet {
	public static void main(String[] args) {
		int[] array = {3, 1, 4, 6, 5};

		for(int i = 0; i < array.length; i++) {
			array[i] = array[i] * array[i];
		}

		Arrays.sort(array);

		for(int i = array.length -1; i >= 0; i--) {
			int result_sum = array[i];

			int start = 0;
			int end = i - 1;

			while(start < end) {
				int total_sum = array[start] + array[end];

				if(total_sum == result_sum) {
					System.out.println("Pythagorean Triplet  elements are " + (int) Math.sqrt(array[start]) 
										+ " and " + (int) Math.sqrt(array[end])
										+ " gives " + (int) Math.sqrt(array[i]));
					return;						
				} else if(total_sum < result_sum) {
					start++;
				} else {
					end--;
				}
			}
		}
	}
}