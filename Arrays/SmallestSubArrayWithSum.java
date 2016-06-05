/**
	Question: Smallest subarray with sum greater than a given value. Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

	Reference: http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/

	Example: arr[] = {1, 4, 45, 6, 0, 19} and x = 51 then output is {4, 45, 6}

	Logic: 
		- Start adding each element to cur_sum.
		- If cur_sum is less than the given sum then keep on adding new elements.
		- If the sum is greater than given sum then save the result.
		- Delete the start index values since that can make out cur_sum more close to the given sum.
*/

class SmallestSubArrayWithSum {
	public static void main(String[] args) {
		int[] array = {1, 4, 45, 6, 0, 19};
		int sum = 51;

		System.out.println(smallestSubWithSum(array, sum));
	}

	public static int smallestSubWithSum(int[] array, int sum) {
		int cur_sum = 0;
		int min_len = array.length;

		int start = 0, end  = 0;

		int result_start = 0;
		int result_end = 0;

		while(end < array.length) {

			// keep adding elements when cur_sum is <= sum
			while(cur_sum <= sum && end < array.length) {
				cur_sum += array[end];
				end++;
			}

			// If cur_sum becomes greater than sum then delete the start index elements.
			while(cur_sum > sum && start < array.length) {
				if(end - start < min_len) {
					min_len = end - start;
					result_start = start;
					result_end = end;
				}

				cur_sum = cur_sum - array[start];
				start++;
			} // while end.
		}

		System.out.println("Start Index = " + start + " and End Index = " + end);
		return min_len;
	}
}