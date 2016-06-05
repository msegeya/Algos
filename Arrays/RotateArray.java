/**
	Question: Rotate Array - Given array and a number x. So the array should 
	NOTE: It's clock wise rotation.

	Example: 
			i/p: 1 2 3 4 and number of rotations = 1
			o/p: 2 3 4 1

			i/p: 1 2 3 4 and number of rotations = 2
			o/p: 3 4 1 2 

			i/p: 1 2 3 4 and number of rotations = 3
			o/p: 4 1 2 3						
*/

import java.util.*;

class RotateArray {

	static int[] rotateByOne(int[] array) {
		int temp = array[0];

		int i = 0;
		for(; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}

		array[i] = temp;

		return array;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		Scanner sc = new Scanner(System.in);
		int rot = sc.nextInt();

		while(rot > 0) {
			array = rotateByOne(array);
			ArrayUtil.print(array, "Each Rotation: ");
			rot--;
		}

		ArrayUtil.print(array, "Iterative Rotation Result: ");

		rotateRecur(array, rot);
		ArrayUtil.print(array, "Recursive Rotation Result: ");
	}

	static void rotateRecur(int[] array, int rot) {
		rotateByOne_Recur(array, rot, 0);
	}

	static void rotateByOne_Recur(int[] array, int rot, int index) {
		if(index == array.length) {
			return;
		}

		int temp = array[(index + rot) % array.length];
		rotateByOne_Recur(array, rot, index + 1);
		array[index] = temp;
	}
}