/**
	Question: Find the largest pair sum in an unsorted array.

	Reference: http://www.geeksforgeeks.org/find-the-largest-pair-sum-in-an-unsorted-array/

	Logic: 
		- You will get largest sum when you get the first max and second max numbers.
		- Return (max1 + max2) as result
*/

class LargestPairSumInUnSortedArray {
	public static void main(String[] args) {
		int[] array = {12, 34, 10, 6, 40}; // 74

		System.out.println(getLargestPair(array));
	}

	public static int getLargestPair(int[] array) {
		int max1 = array[0];
		int max2 = Integer.MIN_VALUE;

		for(int i = 1; i < array.length; i++) {
			if(array[i] > max1) {
				max2 = max1;
				max1 = array[i];
			}
		}

		return max1 + max2;
	}
}