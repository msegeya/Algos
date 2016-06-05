/**
	Question: Print all elements in sorted order from row and column wise sorted matrix.

	Reference: http://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/

	Logic: (Using merging k sorted array logic which is done using heaps.)
		- Since each row is sorted we can consider each row as an array and our goal is to print all the rows such that output is in sorted order.
		- Take a MIN heap of size as number of rows.
		- Add all the 0th elements of all the rows. Keep track of the elements from which row they belong to.
		- Pop an element from the heap and keep it in output. 
		- Now insert the next element from the row to which the poped element belongs.
		- Do this until all the elements in all the rows are completed.
*/

class SortRowWiseSortedElements {
	public static void main(String[] args) {
		
	}
}