/**
	Question: Reverse Array. Just reverse the array.

	Logic: 
		- Take two indices *start* pointing to 1st element and *end* pointing to end element.
		- Until start < end swap(A[start], A[end]) then start++ and end--
*/

class ReverseArray {
	public int[] reverse(int[] array) {
		int start = 0;
		int end = array.length;

		while(start < end) {
			array = ArrayUtil.swap(array, start, end);
			start++;
			end--;
		}

		return array;
	}
}