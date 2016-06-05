/**
	Question: Median of two sorted arrays of different sizes.

	Reference:  https://www.youtube.com/watch?v=_H50Ir-Tves
				https://www.youtube.com/watch?v=MHNTl_NvOj0

	Logic-1: Take new array and merge array1 and array2 and then sort them and get the median.

	Logic-2: Merge the two arrays in sorted order. (Like the way we merge two sorted arrays.) Finally return the median.

	Logic-3:
		1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.
		2) If m1 and m2 both are equal then we are done.
		     return m1 (or m2)
		3) If m1 > m2, then median is present in one 
		   of the below two subarrays.
		    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
		    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
		4) If m1 < m2, then median is present in one    
		   of the below two subarrays.
		   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
		   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
		5) Repeat the above process until size of both the subarrays 
		   becomes 2.
		6) If size of the two arrays is 2 then use below formula to get 
		  the median.
		    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
*/

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 4, 5}; // median is 3
		int[] array2 = {6, 7, 8, 9, 10}; // median is 8. Output for both should be 5.5

		double median = getMedian(array1, array2);
		System.out.println("Median is = " + median);

		// second input.
		int[] c = {1,2,99, 100}; // median is 50.5
        int[] d = {4,5,101, 102}; // median is 53. Output for both should be 52
        median = getMedian(c, d);
        System.out.println("Median is = " + median);
	}

	public static double getMedian(int[] A, int[] B) {
		return getMedian(A, B, 0, A.length - 1, 0, B.length - 1);
	}

	public static double getMedian(int[] A, int[] B, int low1, int high1, int low2, int high2) {

		// Negative case
		if(low1 > high1 || low2 > high2) {
			return -1;
		}

		// If only one element is present then.
		if(high1 - low1 == 0 && high2 - low2 == 0) {
			return (A[low1] + B[low2]) / 2.0;
		}

		// If only two elements are present for each array.
		if(high1 - low1 == 1 && high2- low2 == 1) {
			return ( Math.max(A[low1], B[low2]) + Math.min(A[high1], B[high2]) ) / 2.0;
		}

		double m1 = findMedian(A, low1, high1);
		double m2 = findMedian(B, low2, high2);

		// 1. m1 == m2 then return m1
		// 2. m1 < m2 then ignore elements that are < m1 in A and ignore elements that are > m2 in B.
		// 3. m1 > m2 then ignore elements that are > m1 in A and ignore elements that are < m2 in B.
		int length1 = high1 - low1 + 1;
		int length2 = high2 - low2 + 1;
		if(m1 == m2) {
			return m1;
		} else if(m1 < m2) {
			// For array A. If odd, then get the mid index
			if(length1 % 2 == 1) {
				low1 = ( (high1 - low1) / 2 ) + 1;
			} else {
				low1 = ( (high1 - low1) / 2 ) + 1;
			}

			// For array B. If odd, then get the mid index
			if(length2 % 2 == 1) {
				high2 = ( (high2 - low2) / 2 ) - 1;
			} else {
				high2 = ( (high2 - low2) / 2 );
			}
		} else {
			// For array A. If odd, then get the mid index
			if(length1 % 2 == 1) {
				high1 = ( (high1 - low1) / 2 ) - 1;
			} else {
				high1 = ( (high1 - low1) / 2 ) - 1;
			}

			// For array B. If odd, then get the mid index
			if(length2 % 2 == 1) {
				low2 = ( (high2 - low2) / 2 ) + 1;
			} else {
				low2 = ( (high2 - low2) / 2 ) + 1;
			}
		}

		return getMedian(A, B, low1, high1, low2, high2);
	}

	public static double findMedian(int[] array, int low, int high) {
		int length = (high - low + 1);
		int mid = low + (high - low) / 2;
		if(length % 2 == 0) {
			return (array[mid] + array[mid + 1]) / 2.0;
		} else {
			return array[mid];	
		}
	}
}