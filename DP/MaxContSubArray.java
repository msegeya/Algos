/**
	Question: Find the maximum sum indices of an integer array.

	Source: http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/1

	Logic-1: (Using Kadane's Algorithm. NOTE: This algorithm does not work if all the numbers are negative, it will return output as 0.)
		- We will take two variables max_ending_here, max_so_far.
		- If the max_ending_here is > 0 update max_ending_here else make it zero.
		- If max_ending_here is > max_so_far then update max_so_far with max_ending_here.

	So what to do if all the numbers are negative?
		As kadane's algorithm does not work if tha array contains all the negative numbers. 
		So beofre going to kadane's logic we will have a small piece of code where we traverse the elements and if all the elements are negative then return the least value.

	Logic-2: (This will work for negative numbers also.)
		- Intialize current_sum and max_sum with first element of the array.
		- From next element onwards add each element to current_sum,
				- If current element is less than (current_sum + element) then assign sum to current_sum.
				- If max_sum is less than current_sum then assign current_sum to max_sum.
*/

class MaxContSubArray {

	int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};

	public static void main(String[] args) {
		MaxContSubArray mcsaObj = new MaxContSubArray();
		mcsaObj.printMaxSubArray();
	}

	void printMaxSubArray() {
		int sum = maxArrayUsingKadane(input);
		System.out.println("Using Kadane's Approach: " + sum);

		sum = maxContinousArray(input);
		System.out.println("Using Simple Approach: " + sum);
	}

	int maxArrayUsingKadane(int[] input) {
		// If all the elements are negative then return the least element of all.
		int max_in_all_negative = -999;
		for(int i = 0; i < input.length; i++) {
			if(input[i] < 0) {
				if(input[i] > max_in_all_negative) {
					max_in_all_negative = input[i];
				}
			} else {
				max_in_all_negative = -999;
				break;
			}
		}

		// If max_in_all_negative is 999 then we can say there are non-negative numbers and we can proceed to Kadane'e approach.
		// Else return the minimum element of the negative array.
		if(max_in_all_negative != -999) {
			System.out.println("All are negative numbers. Returning the maximum of the negative numbers.");
			return max_in_all_negative;
		}

		int start_index = 0;
		int end_index = 0;
		int max_ending_here = 0;
		int max_so_far = 0;

		for(int i = 0; i < input.length; i++) {
			max_ending_here = max_ending_here + input[i];

			if(max_ending_here < 0) {
				max_ending_here = 0;
				
				// Just to keep track of the index range of the max sub-array.
				start_index = i + 1;	
			} 

			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				end_index = i;
			}
		}

		System.out.println("Index range for max_so_far is start = " + start_index + " end = " + end_index);
		return max_so_far;
	}

	/*
		Alternate Approach:
		1. Initialize both current_sum and max_sum both to 0th element.
		2. For every element, 
			a) current_sum will be max of current input element and (current_sum + current input element)
			b) 
	*/
	int maxContinousArray(int[] input) {
		int current_sum = input[0];
		int max_sum = input[0];

		for(int i = 1; i < input.length; i++) {
			current_sum = Math.max(input[i], current_sum + input[i]);
			max_sum = Math.max(current_sum, max_sum);
		}
		return max_sum;
	}
}		