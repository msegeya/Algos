/**
	Question: Maximum Product Subarray. Given an array that contains both positive and negative integers, find the product of the maximum product subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.

	Reference: http://www.geeksforgeeks.org/maximum-product-subarray/
	
	Inputs: {6, -3, -10, 0, 2} // 180
			{-1, -3, -10, 0, 60} // 60
			{-2, -3, 0, -2, -40} // 80

	Logic: (We will use Kadane's algorithm approach here.)
		- Take 3 variables max_ending_here and min_ending_here 
			where, max_ending_here = maximum positive product ending here.
				   min_ending_here = minimum negative product ending here.
				   max_so_far = maximum so far.
		- For every element we have three cases, > 0, < 0 and = 0.
		- For > 0, max_ending_here = max_ending_here * array[i]
				   min_ending_here = Math.min(min_ending_here * array[i], 1)
		- For = 0, just reset the max_ending_here and min_ending_here to default value.
		- For < 0, A little Tricky. So this number is negative. 
				   1) save max_ending_here => int temp = max_ending_here;
				   2) max_ending_here = Math.max(max_ending_here * array[i], 1);
				   3) min_ending_here = temp * array[i];
*/

class MaxProductSubArray {
	public static void main(String[] args) {
		// int[] array = {6, -3, -10, 0, 2}; // 180
		int[] array = {-1, -3, -10, 0, 60}; // 60
		// int[] array = {-2, -3, 0, -2, -40};

		// max positive product.
		int max_ending_here = 1;
		// min negative product.
		int min_ending_here = 1;
		// Overall max product.
		int max_so_far = 1;

		for(int i = 0; i < array.length; i++) {
			if(array[i] > 0) {
				max_ending_here *= array[i];
				min_ending_here = Math.min(min_ending_here * array[i], 1);
			} else if(array[i] == 0) {
				max_ending_here = 1;
				min_ending_here = 1;
			} else {
				// save the previous max sum.
				int temp = max_ending_here;
				max_ending_here = Math.max(min_ending_here * array[i], 1);
				min_ending_here = temp * array[i];
			}

			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
		}

		System.out.println(max_ending_here);
	}
}