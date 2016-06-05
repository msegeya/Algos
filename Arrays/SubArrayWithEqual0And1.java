/**
	Question: http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/

	Reference: http://stackoverflow.com/a/31201586/967638

	Logic: 
		- Take an new Array say "count_arr" of length = actual length + 1.
		- Initialize count_arr[0] = 0.
		- Then for every element of array get the difference of 0's and 1's until the current index and store it at count_arr[i + 1]
		- Now we need to get all the indices that are same such that the distance between the same indices should be maximum. We will do it using Maps.
*/

import java.util.*;

class SubArrayWithEqual0And1 {
	public static void main(String[] args) {
		int[] array = {1, 0, 1, 1, 1, 0, 0}; // 6 (0 to 5)
		// int[] array = {1, 1, 1, 1}; // -1
		// int[] array = {0, 0, 1, 1, 0}; // 4 (0 to 3)

		printMaxSubArray(array);
	}

	private static void printMaxSubArray(int[] array) {
		int[] count_arr = new int[array.length + 1];

		int count_1 = 0;
		int count_0 = 0;

		count_arr[0] = 0;
		for(int i = 0; i < array.length; i++) {
			if(1 == array[i]) {
				count_1++;
			} else {
				count_0++;
			}

			count_arr[i + 1] = count_1 - count_0;
		}

		ArrayUtil.print(count_arr, "1's and 0's count array: ");


		// create a hash table where key will be the length and value will be the point(start index, end index) of this length.
		Map<Integer, Start_End_Point_Array> map = new HashMap<Integer, Start_End_Point_Array>();
		for(int i = 0; i < count_arr.length; i++) {
			if(null == map.get(count_arr[i])) {
				Start_End_Point_Array sepa = new Start_End_Point_Array();
				sepa.start = i;
				map.put(count_arr[i], sepa);
			} else {
				Start_End_Point_Array map_point = map.get(count_arr[i]);
				map_point.end = i;
			}
		}

		Set<Integer> keys = map.keySet();
		int max_length = 0;
		int max_start = -1;
		int max_end  = -1;
		for(Integer key : keys) {
			Start_End_Point_Array sepa = map.get(key);

			System.out.println("Length = " + key + " start = " + sepa.start + " end = " + sepa.end);

			if(max_length < (sepa.end - sepa.start)) {
				max_length = sepa.end - sepa.start;
				max_start = sepa.start;
				max_end = sepa.end;
			} 
		}

		/*System.out.println("Max Length = " + max_length + 
								" start at " + (max_start - 1) + 
									" end at " + (max_end - 1));*/
		System.out.println("Max Sub-Array Length = " + max_length);
	}
}

class Start_End_Point_Array {
	public int start;
	public int end;
}