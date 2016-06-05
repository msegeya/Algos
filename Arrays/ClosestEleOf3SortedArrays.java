/**
	Question: Find three closest elements from given three sorted arrays. Given three sorted arrays A[], B[] and C[], find 3 elements i, j and k from A, B and C respectively such that MAX( abs(A[i] – B[j]), abs(B[j] – C[k]), abs(C[k] – A[i]) ) is minimized. Here abs() indicates absolute value.

	Reference: http://www.geeksforgeeks.org/find-three-closest-elements-from-given-three-sorted-arrays/

	Logic: 
		- Take three pointers i, j, k for each of the rows.
		- Get the maximum and minimum value at these indices.
		- The difference of (maximum - minimum) should be minimum. So calculate (maximum - minimum). It the min_so_far is greater than the difference then assign the difference to min_so_far.
		- Now shall we increment all the pointers .. NOPE. We should increment the pointer that gave us the minimum value while calculating minimum.
		- Do this until minimum index value pointer reaches end of the array.
*/

class ClosestEleOf3SortedArrays {
	public static void main(String[] args) {
		int[] A = {1, 4, 10};
    	int[] B = {2, 15, 20};
    	int[] C = {10, 12};

    	printTriplet(A, B, C);
	}

	public static void printTriplet(int[] A, int[] B, int[] C) {
		int i = 0;
		int j = 0;
		int k = 0;

		int min_so_far = Integer.MAX_VALUE;
		int result_i = 0, result_j = 0, result_k = 0;

		while(i < A.length && j < B.length && k < C.length) {
			// Get min and max value from all the rows at their respective indices.
			int maximum = Math.max( A[i], Math.max(B[j], C[k]) );
			int minimum = Math.min( A[i], Math.min(B[j], C[k]) );

			if( (maximum - minimum) < min_so_far) {
				min_so_far = maximum - minimum;

				result_i = i;
				result_j = j;
				result_k = k;
			}

			// We can't get more than 0 since as per the condition the result is absolute.
			if(min_so_far == 0) {
				break;
			}

			// Increment the pointer of the array which has minimum value.
			if(minimum == A[i]) {
				i++;
			} else if(minimum == B[j]) {
				j++;
			} else {
				k++;
			}
		}

		System.out.println(A[result_i] + " " + B[result_j] + " " + C[result_k]);
	}
}