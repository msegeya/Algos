/**
	Question: Find the Number Occurring Odd Number of Times. Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. Find the number in O(n) time & constant space.

	Reference: http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/

	Logic-1: (Using Hasing (Space complexity is O(n)) or Sorting (O(nlogn)))

	Logic-2: (Using XOR)
		- XOR of all the elements gives us odd occuring element.
		- XOR of two elements is 0 if both elements are same.
		- XOR of a number x with 0 is x.
		- So the odd occuring element will be having xor with 0 ==> odd occuring element.
*/

class NumOccuringOddNumOfTimes {
	public static void main(String[] args) {
		int[] array = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};

		int result = 0;
		for(int i = 0; i < array.length; i++) {
			result = result ^ array[i];
		}

		System.out.println(result);
	}
}