/**
	Question: Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).

	Example:
		arr[] = {10, 3, 5, 6, 2}
		prod[] = {180, 600, 360, 300, 900}

	Reference: http://www.geeksforgeeks.org/a-product-array-puzzle/
*/

class ProductArray {
	public static void main(String[] args) {
		int[] array = {10, 3, 5, 6, 2};

		int mul = 1;
		int[] product = new int[array.length];

		for(int i = 0; i < array.length; i++) {
			product[i] = mul;
			mul *= array[i];	
		}

		mul = 1;
		for(int i = array.length - 1; i >= 0; i--) {
			product[i] *= mul;
			mul *= array[i];	
		}		

		for(int i = 0; i < array.length; i++) {
			System.out.println(product[i]);
		}

	}
}