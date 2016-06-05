/**
	Question: Find a sorted subsequence of size 3 in linear time. Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time. If there are multiple such triplets, then print any one of them.

	Reference: http://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/

	NOTE: We can use DP/LongestIncrSubSeq.java for solving this. But that is O(nlogn) where as the below solution is O(n). Below solution is easy to understand but I am not sure why does this work.

	Logic: 
		- Create two auxillary arrays - smaller[] and greater[]
		- For smaller[] array,
			Fill the index of the smaller element than the current element which is on the left of the current element. 
		  	Else put -1.
		- For greater[] array,
			Fill the index of the greater element than the current element which is on the right of the current element.
			Else put -1.
		- Finally get the index of the two arrays where both the smaller[] and greater[] values are positive.

	Proof about the logic:
		- NO PROOF MENTIONED ANYWHERE.	
*/

class SortedSubSeqOfSize3 {
	public static void main(String[] args) {
		int[] array = {12, 11, 10, 5, 6, 2, 30};

		int[] smaller = new int[array.length];
		int[] greater = new int[array.length];

		// Fill the index of the elements which are smaller than the current element.
		smaller[0] = - 1;
		int min_index = 0;
		for(int i = 1; i < smaller.length; i++) {
			if(array[i] > array[min_index]) {
				smaller[i] = min_index;
			} else {
				min_index = i;
				smaller[i] = -1;
			}
		}

		ArrayUtil.print(smaller, "Smaller Array values ");

		// Fill the index of the elements which are greater than the current element.
		greater[array.length - 1] = -1;
		int max_index = array.length - 1;
		for(int i = array.length - 2; i >= 0; i--) {
			if(array[i] < array[max_index]) {
				greater[i] = max_index;
			} else {
				max_index = i;
				greater[i] = -1;
			}
		}

		ArrayUtil.print(greater, "Greater Array values ");

		for(int i = 0; i < array.length; i++) {
			if(smaller[i] != -1 && greater[i] != -1) {
				int first_num = array[smaller[i]];
				int second_num = array[i];
				int third_num = array[greater[i]];

				System.out.println(first_num + " " + second_num + " " + third_num);
				return;
			}
		}

		System.out.println("No Sub-Sequence of size 3 found.");
	}
}