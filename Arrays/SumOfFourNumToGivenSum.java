/**
	Question: Given an array of integers, find all combination of four elements in the array whose sum is equal to a given value X.

	Reference: http://stackoverflow.com/questions/3569504/find-four-elements-in-array-whose-sum-equal-to-a-given-number-x

	Example: {10, 2, 3, 4, 5, 9, 7, 8} // Either {10, 2, 3, 8} or {3, 5, 7, 8}

	Logic: 
		- For each pair of element get the sum and get the remaining sum.
		- If the remaining sum is present in the Map then prin the elements.
		- If the reamining sum is not present then put the current sum into the Map with the respective indices.
*/

import java.util.*;

class SumOfFourNumToGivenSum {
	public static void main(String[] args) {
		int[] array = {10, 2, 3, 4, 5, 9, 7, 8};
		int SUM = 23;

		Map<Integer, FourSumPairs> map = new HashMap<Integer, FourSumPairs>();

		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				int cur_sum = array[i] + array[j];
				int rem_sum = SUM - cur_sum;

				if(null != map.get(rem_sum)) {
					System.out.println(array[i] + " " + 
											array[j] + " " + 
												array[map.get(rem_sum).x] + " " + 
													array[map.get(rem_sum).y]);
					return;
				} else {
					map.put(cur_sum, new FourSumPairs(i, j));
				}
			}
		}
	}
}

class FourSumPairs {
	public int x;
	public int y;

	public FourSumPairs(int x, int y) {
		this.x = x;
		this.y = y;
	}
}