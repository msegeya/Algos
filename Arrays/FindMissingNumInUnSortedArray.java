/**
	Question: How to find a duplicate element in an array of shuffled consecutive integers? Given range and find the missing number in that range.

	Logic: 
		- Calculate sum of number that is n*(n + 1) / 2 where n = max number .. say M
		- Also do sum of all the numbers in the array and finally get the remainder that is (M - Sum) will give us the missing number.
*/

class FindMissingNumInUnSortedArray {

	public static void main(String[] args) {
		int[] array = {1, 4, 2};
		missingNum(array, array.length + 1);
	}

	public static void missingNum(int[] array, int n) {

		int sum_of_numbers = (n * (n + 1) / 2);

		int actual_sum = 0;
		for(int i = 0; i < array.length; i++) {
			actual_sum += array[i];
		}

		System.out.println("Sum of natural numbers = " + sum_of_numbers);
		System.out.println("Sum of given numbers = " + actual_sum);

		System.out.println("Missing Number is " + (sum_of_numbers - actual_sum));
	}
}