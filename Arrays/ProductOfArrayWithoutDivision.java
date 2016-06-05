/**
	Question: Given an array of numbers, return array of products of all other numbers (no division is allowed.) You need to modify the array so that each index of array contains product of all elements except for the its own index element. Divison operator is not allowed.

	Reference: http://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div

	Logic: (Using auxillary array) 
		- Take two auxillary arrays. product_left[] and product_right[].
		- Go from left to right for filling product_left array.
		- Go from right to left for filling product_right array.
		- Finally for filling array,
	
	Logic-2: (Without using auxillary array.)
*/

class ProductOfArrayWithoutDivision {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};

		ArrayUtil.print(array, "Input Array: ");

		int[] output = productWithAuxillaryArray(array);

		ArrayUtil.print(output, "Finding product using Auxillary Array: ");

		int[] output2 = productWithoutAuxillaryArray(array);
		ArrayUtil.print(output2, "Finding product without using Auxillary Array: ");		
	}

	public static int[] productWithAuxillaryArray(int[] array) {
		int[] product_left = new int[array.length];
		int[] product_right = new int[array.length];

		int p = 1;
		for(int i = 0; i < array.length; i++) {
			product_left[i] = p;
			p *= array[i];
		}

		ArrayUtil.print(product_left, "Product Left");

		p = 1;
		for(int i = array.length - 1; i >= 0; i--) {
			product_right[i] = p;
			p  *= array[i];
		}

		ArrayUtil.print(product_right, "Product Left");

		// finally we will get the product from both the auxillary arrays
		int[] result = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = product_left[i] * product_right[i];
		}

		return result;
	}

	public static int[] productWithoutAuxillaryArray(int[] array) {
		
		int[] result = new int[array.length];

		int p = 1;
		for(int i = 0; i < array.length; i++) {
			result[i] = p;
			p *= array[i];
		}

		p = 1;
		for(int i = array.length - 1; i >= 0; i--) {
			// we need to multiply here.
			result[i] *= p;
			p *= array[i];
		}

		return result;
	}
}