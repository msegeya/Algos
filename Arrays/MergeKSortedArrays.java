/**
	Question: Merge k sorted arrays. Given k sorted arrays of size n each, merge them and print the sorted output.

	Reference:  (Own Implementation)
				http://www.geeksforgeeks.org/merge-k-sorted-arrays/


	Example: 
			Input:  k = 3, n =  4
 				    arr[][] = { {1, 3, 5, 7},
					            {2, 4, 6, 8},
					            {0, 9, 10, 11}
					          };
					Output: 0 1 2 3 4 5 6 7 8 9 10 11 

	Logic: (We will use MIN-HEAP. Alternatively you can refer Algos\Trees\Heap\MergeKSortedArrays.java)
		- In here we haven't used any classes for storing array row, current column in array, isArray completed or not.
		- Instead of that we are using an array to keep track of all the columns. We go this apporach from Matrix/CommonElementInAllRows.java
		- That's it. Rest all are same as the above mentioned class.
*/
import java.util.*;

class MergeKSortedArrays {
	public static void main(String[] args) {
		int[][] array = { 
							{1, 3, 5, 7},
					      	{2, 4, 6, 8},
					        {0, 9, 10, 11}
					    };
		int k = 3; // Is nothing but the number of rows.

		int[] output = getKSortedArray(array, k);
		ArrayUtil.print(output, "Output of K sorted arrays");
	}

	public static int[] getKSortedArray(int[][] array, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);

		int[] rowIndices = new int[k];
		int[] output = new int[k * array[0].length];

		for(int i = 0; i < k; i++) {
			int element = array[i][rowIndices[i]];
			pq.add(element);
		}

		int index = 0;
		while(!pq.isEmpty()) {
			int popEle = pq.poll();

			// reached end of all the arrays.
			if(popEle == Integer.MAX_VALUE) {
				break;
			}

			output[index++] = popEle;

			// after popping we should know from which array it came.
			for(int i = 0; i < array.length; i++) {
				if(rowIndices[i] < array[0].length && array[i][rowIndices[i]] == popEle) {
					rowIndices[i] = ++rowIndices[i];
					if(rowIndices[i] >= array[0].length) {
						pq.add(Integer.MAX_VALUE);
					} else {
						pq.add(array[i][rowIndices[i]]);
					}
					break;
				}
			}
		}

		return output;
	}
}