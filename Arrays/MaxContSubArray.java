/**
	Question: Largest Sum Contiguous Subarray. Write an efficient C program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.

	Reference: http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

	NOTE: Ignore the below logic. Goto DP/MaxContSubArray.java

	Logic: (Using Kadane's Algorithm) 
		- Follow code.
*/

class MaxContSubArray {

 	// Kadane's algorithm works only if there is atleast one positive element.
 	public static int kadaneAlgo(int[] array) {
 		int max_so_far = 0; 
 		int max_ending_here = 0;

 		for(int i = 0; i < array.length; i++) {
 			max_ending_here += array[i];

 			if(max_ending_here < 0) {
 				max_ending_here = 0;
 			}

 			if(max_so_far < max_ending_here) {
 				max_so_far = max_ending_here;
 			}
 		}

 		System.out.println("Max Sum is: " + max_so_far);
 		return max_so_far;
 	}

 	public static void main(String[] args) {
 		int array[] = {-2, -3, 4, -1, -2, 1, 5, -3};
 		kadaneAlgo(array);
 	}

 }