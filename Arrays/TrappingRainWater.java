/**
	Question: Trapping Rain Water. Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

	Reference: http://www.geeksforgeeks.org/trapping-rain-water/

	Logic: 
		- Pre-Compute highest bar to left and right of every bar including itself.
		- We will use this to pre-compute the amount of water between the bars.
*/

class TrappingRainWater {
	public static void main(String[] args) {
		int[] array = {3, 0, 0, 2, 0, 4};
		System.out.println(computeTrappedWater(array));

		int[] array2 = {2, 0, 2};
		System.out.println(computeTrappedWater(array2));

		int[] array3 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(computeTrappedWater(array3));		
	}

	public static int computeTrappedWater(int[] array) {
		// get the tallest bar to left of it including itself.
		int[] left = new int[array.length];

		// get the tallest bar to right of it including itself.
		int[] right = new int[array.length];

		// For left-most, it itself will be the tallest.
		left[0] = array[0];
		for(int i = 1; i < array.length; i++) {
			left[i] = Math.max(left[i - 1], array[i]);
		}


		// For right-most, it itself will be the tallest.
		right[array.length - 1] = array[array.length - 1];
		for(int i = array.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], array[i]);
		}

		// Now to get the accumulated water we do the following,
		// min(left[i], right[i]) - array[i] that is,
		// Minimum of the two heights(left-height and right-height) has to be considered since water traps to the minimum height.
		// Also we need to remove the current bar since that also has width where it cannot accomodate any water.
		int water = 0;
		for(int i = 0; i < array.length; i++) {
			water += Math.min(left[i], right[i]) - array[i];
		}

		return water;
	}
}