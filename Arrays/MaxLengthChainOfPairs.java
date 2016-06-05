/**
	Question: Maximum Length Chain of Pairs. You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs.

	Reference:  http://stackoverflow.com/a/17534064/967638
				http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/

	Logic: 
		- Sort the pairs by their y value.
		- Now for every pair check whether the current pair x value is greater than the last added pair's y value. If so add it to the selected list else proceed to the next pair.
*/

import java.util.*;

class MaxLengthChainOfPairs {
	public static void main(String[] args) {
		int[][] array = {
							{5, 24}, 
							{15, 25}, 
							{27, 40},
							{50, 60}
						};

		ChainPairs[] pairs = new ChainPairs[array.length];
		for(int i = 0; i < array.length; i++) {
			pairs[i] = new ChainPairs(array[i][0], array[i][1]);
		}

		Arrays.sort(pairs, new Comparator<ChainPairs>() {
							public int compare(ChainPairs c1, ChainPairs c2) {
								return c1.y - c2.y;
							}
		});

		int count = 1; // for first pair.
		int last_index = 0; // keeps track of the last selected pair.
		for(int i = 1; i < pairs.length; i++) {
			// current chain pair.
			ChainPairs cp = pairs[i];

			// last selected pair
			ChainPairs cp_last = pairs[last_index];
			
			if(cp.x > cp_last.y) {
				count++;
				last_index = i;
			}
		}

		System.out.println("Total count is = " + count);
	}
}

class ChainPairs {
	public int x;
	public int y;

	public ChainPairs(int x, int y) {
		this.x = x;
		this.y = y;
	}
}