/**
	Question: Maximum Sum Path in Two Arrays. Given two sorted arrays such the arrays may have some common elements. Find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays. We can switch from one array to another array ONLY at common elements.

	Reference: http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/

	Example: ar1[] = {2, 3, 7, 10, 12}, ar2[] = {1, 5, 7, 8} ==> Output = 35. 
			 ==> How? You can start at either at ar1 or at ar2. If you start at ar1 then take the first element 2 or if you start at ar2 then take the first element that is 1.

	Logic: 
		- From the above example we CANNOT say that since we don't know which one will give us the maximum result. So we will calculate both the array sums and check which one leads to maximum result.
		- 
*/

class MaxSumPathInTwoArrays {
	public static void main(String[] args) {
		// int[] A = {2, 3, 7, 10, 12}; int[] B = {1, 5, 7, 8}; // Output = 35
		// int[] A = {10, 12}; int[] B = {5, 7, 9}; // Output = 22
		int[] A = {2, 3, 7, 10, 12, 15, 30, 34}; int[] B = {1, 5, 7, 8, 10, 15, 16, 19}; // Output = 122

		System.out.println(getMaxPathSum(A, B));
	}

	public static int getMaxPathSum(int[] A, int[] B) {
		// A's sum
		int sum_A = 0;

		// B's sum
		int sum_B = 0;

		// result
		int result = 0;

		int i = 0, j = 0;
		while(i < A.length && j < B.length) {
			if(A[i] < B[j]) {
				sum_A += A[i];
				i++;
			} else if(A[i] > B[j]) {
				sum_B += B[j];
				j++;
			} else {
				result += Math.max(sum_A, sum_B);

				// if there are a sequence of result elements then just add them to the result.
				while(i < A.length && j < B.length && A[i] == B[j]) {
					result += A[i];
					i++;
					j++;
				}

				// since we have already stored sum's of A and B to result. We can reset them.
				sum_A = 0;
				sum_B = 0;
			}
		}

		// add the remaining elements of array A to sum_A.
		while(i < A.length) {
			sum_A += A[i];
			i++;
		}

		// add the remaining elements of array A to sum_B.
		while(j < B.length) {
			sum_B += B[j];
			j++;
		}

		// add the result.
		result += Math.max(sum_A, sum_B);

		return result;
	}
}