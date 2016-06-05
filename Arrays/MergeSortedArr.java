/**
	Question: Merge two sorted arrays. Merge an array of size n into another array of size m+n.

	Reference: http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/	

	Example: 
	Array-1: int MN[] = {2, 8, NA, NA, NA, 13, NA, 15, 20};
	Array-2: int N[] = {5, 7, 9, 25};

	Logic: 
		- Logic is same as that of merging two sorted arrays. But we should do a little more update on the array before we proceed.
		- Move all the elements to the right in the same order as they appeared before.
			Ex: This {2, 8, NA, NA, NA, 13, NA, 15, 20} will become {2, 8, NA, NA, 2, 8, 13, 15, 20};
		- Now place a pointer at index (MN.length - N.length) position.
		- Place another pointer at index 0 of N array.
		- Start comparing and store the least element in MN array starting at index 0.
*/

class MergeSortedArr {
	public static int[] moveToEnd(int[] MN) {
		int j = MN.length - 1;
		for(int i = MN.length - 1; i >= 0; i--) {
			if(MN[i] != -999) {
				MN[j] = MN[i];
				j--;
			}
		}

		return MN;
	}

	public static int[] merge(int[] MN, int[] N) {
		int mn_len = MN.length;
		int n_len = N.length;

		int i = mn_len - n_len - 1;
		int j = 0;
		int k = 0;

		while(i < mn_len && j < n_len) {
			if(MN[i] <= N[j]) {
				MN[k] = MN[i];
				k++;
				i++;
			} else {
				MN[k] = N[j];
				k++;
				j++;
			}
		}

		while(i < mn_len) {
			MN[k] = MN[i];
			k++;
			i++;
		}

		while(j < n_len) {
			MN[k] = N[j];
			k++;
			j++;
		} 

		return MN;
	}

	public static void main(String[] args) {
		int MN[] = {2, 8, -999, -999, -999, 13, -999, 15, 20};
		int N[] = {5, 7, 9, 25};

		int[] moved = moveToEnd(MN);

		System.out.println("After Moving Elements to Right");
		print(moved);

		int[] output = merge(moved, N);
		System.out.println("After Merging");
		print(output);
	}

	public static void print(int[] items) {
		for(int item : items) {
			System.out.print(item + "\t");
		}
		System.out.println();
	}
}