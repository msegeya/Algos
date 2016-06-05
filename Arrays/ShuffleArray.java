/**
	Question: Shuffle a given array. Given an array, write a program to generate a random permutation of array elements. This question is also asked as "shuffle a deck of cards" or "randomize a given array".

	Reference: http://stackoverflow.com/a/1520212/967638

	NOTE: Question can also be asked as "Randomly play a song from a list of given songs in such a way that no songs is repeated until all the songs are played"

	Logic: (Using Fisher–Yates shuffle)
		- Use java.util.concurrent.ThreadLocalRandom to generate random number. (For concurrent access, using ThreadLocalRandom instead of Math.random() results in less contention and, ultimately, better performance.)
		- Swap every element with a random number.
*/

import java.util.*;
import java.util.concurrent.*;

class ShuffleArray {
	public static void main(String[] args) {
		// int[] array = {1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11};
		int[] array = {1, 2, 3, 4, 5};

		ArrayUtil.print(array, "Input Array before shuffling: ");
		doShuffle(array);
		ArrayUtil.print(array, "Array after shuffling: ");
	}

	public static void doShuffle(int[] array) {
		Random rand = ThreadLocalRandom.current();
		for(int i = array.length -1; i > 0; i--) {

			int rand_num = rand.nextInt(i + 1); // returns number between 0 and i + 1.

			// Simple swap
			int temp = array[rand_num];
			array[rand_num] = array[i];
			array[i] = temp;
		}
	}
}