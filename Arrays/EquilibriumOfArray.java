/**
	Question: Equilibrium index of an array. Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

	Reference: http://www.geeksforgeeks.org/equilibrium-index-of-an-array/

	Logic: 
		- Get the sum of the array.
		- Initialize leftSum = 0.
		- Now traverse the array again, for each value do the following.
			- Subtract value from sum
			- If sum == leftSum return index of value as Equilibrium position.
			- Else add the value to leftSum.
*/

class EquilibriumOfArray {
	public static void main(String[] args) {
		int[] array = {-7, 1, 5, 2, -4, 3, 0};

		int leftSum = 0;
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		System.out.println("Total sum = " + sum);

		for(int i = 0; i < array.length; i++) {
			sum = sum - array[i];

			if(leftSum == sum) {
				System.out.println("Equilibrium Index is = " + i);
				return;
			} 

			leftSum += array[i];
		}
	}
}