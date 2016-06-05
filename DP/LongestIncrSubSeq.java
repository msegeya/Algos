/**
	Question: Longest Increasing sub-sequence. O(nlogn) method.

	Source: O(nlogn) --> https://www.youtube.com/watch?v=1RpMc3fv0y4
			https://github.com/IDeserve/learn/blob/master/LongestIncreasingSubsequence.java
			http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

	How is it different from LongestIncreasingSubSeq.java? 
		LongestIncreasingSubsequence.java is done using Dynamic Programming for which we have time complexity as O(n^2).
		Where as here we do in O(nlogn).
	
	Logic: Please watch the video before porceeding. 
		- Two principles,
			1) Append the current element to the increasing sequence if the current > last-element-of-the-incresing-seq
			2) If current <= last-element-of-the-incresing-seq then replace the element which is >= current.
		- Please follow code comments for more details.	
*/
class LongestIncrSubSeq {
	public static void main(String[] args) {
		// int[] array = {3, 1, 5, 2, 6, 4, 9};
		// int[] array = {3, 1, 5, 0, 6, 4, 9};
		int[] array = {12, 11, 10, 5, 6, 2, 30};

		LIS(array);
	}

	public static void LIS(int[] array) {
		// Index storage of all the increasing sequence elements.
		int[] incSeq = new int[array.length];
		// Index storage of the increasing sequence parents.
		int[] parent = new int[array.length];
		// Length of the increasing sequence.
		int length = 0;

		for(int i = 0; i < array.length; i++) {
			// We will use a binary search to figure out whether the current element is greater 
			// than the previous sub-sequence element.
			int low = 1;
			// high will be the highest index of the binary search .. that is the length of the sub-sequence so far.
			int high = length;

			// current element.
			int current = array[i];
			

			while(low <= high) {
				int mid = low + (high - low) / 2;

				int inc_seq_index = incSeq[mid];
				int last_inc_ele = array[inc_seq_index];

				if(last_inc_ele < current) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

			int pos = low;
			// parent of the current element will be the index of the previous element in the sub-sequence.
			parent[i] = incSeq[pos - 1];

			// Replace or Append. So incSeq of current position will be i.
			incSeq[pos] = i;

			// update pos if length is less than current pos.
			if(pos > length) {
				length = pos;
			}
		}

		// We got the parent indices as well as length of the sub-sequence.
		// Now we can print all the values of the sub-sequence.
		int[] LIS = new int[length];
		int k = incSeq[length];
		for(int j = length - 1; j >= 0; j--) {
			LIS[j] = array[k];
			k = parent[k];
		}

		print(LIS, "Longest Increasing Sub-Sequence is: ");

	}

	public static void print(int[] array, String msg) {
		System.out.println(msg + "\n");

		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}
}