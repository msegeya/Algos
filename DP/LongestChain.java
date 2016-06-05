/**
	Question: You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. 
	A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. 
	Find the longest chain which can be formed from a given set of pairs.

	Source: http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/

	Example: 
			Given pairs {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }.
			Then the longest chain that can be formed is of length 3, and the pairs in chain are {{5, 24}, {27, 40}, {50, 90}}

	Logic: 
		- This problem is a variation of standard Longest Increasing Subsequence (LIS) problem. Following is a simple two step process.
			1) Sort given pairs in increasing order of first (or smaller) element.
				Input: {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}}
				Sort the pairs based on the first values.
				==> {{5, 24}, {15, 28}, {27, 40}, {39, 60}, {50, 90}}
			2) Now run a modified LIS process where we compare the second element of already finalized LIS with the first element of new LIS being constructed.
				==> O/P: {(5, 24), (27, 40), (50, 90)}
*/

import java.util.*;

class LongestChain {

	private Point[] points;

	public static void main(String[] args) {
		// let us take two arrays where each index in both the arrays form a point.
		// points are, index 0 = (5, 24), index 1 = (15, 28) .. 
		int[] north = {5, 15, 27, 39, 50};
		int[] south = {24, 28, 40, 60, 90};

		LongestChain lcObj = new LongestChain();
		lcObj.printLongChainLength(north, south);
	}

	void printLongChainLength(int[] north, 
									int[] south) {
		int chainLeng = getLongChainLen(north, south);
		System.out.println("\nLongest Chain Length is: " + chainLeng);
	}

	int getLongChainLen(int[] north, 
								int[] south) {
		points = new Point[north.length];
		
		// let's create a point basing on each index.
		for(int i = 0; i < north.length; i++) {
			Point p = new Point(north[i], south[i]);
			points[i] = p;
		}

		// sort points using priority queue and put them in a List
		SortNorthPoints sortObj = new SortNorthPoints();
		PriorityQueue<Point> pq = new PriorityQueue<Point>(north.length, sortObj);
		for(Point p : points) {
			pq.add(p);
		}

		List<Point> pointsList = new ArrayList<Point>();
		// After adding we will insert the sorted list 
		while(!pq.isEmpty()) {
			pointsList.add(pq.remove());
		}

		System.out.println("Sorted Points: ");
		for(int ptIndex = 0; ptIndex < pointsList.size(); ptIndex++) {
			System.out.print("(" + pointsList.get(ptIndex).north + ", " + pointsList.get(ptIndex).south + ")" + "  ");
		}

		int max_chain_length = calLIS(pointsList);
		return max_chain_length;
	}

	int calLIS(List<Point> pointsList) {
		int max_length = 1;
		int[] DP = new int[pointsList.size()];
		int[] pickedPointsIndex = new int[pointsList.size()];
		DP[0] = 1;
		pickedPointsIndex[0] = -1;
		int lastEndIndex = 0;

		for(int i = 1; i < pointsList.size(); i++) {
			DP[i] = 1;
			pickedPointsIndex[i] = -1;
			for(int j = i - 1; j >= 0; j--) {
				// p1=(n1, s1) and p2=(n2, s2) then to make sure p1, p2 are in chain we must satisfy n2 > s1
				if((pointsList.get(i).north >  pointsList.get(j).south) 
														&& (DP[j] + 1 > DP[i])) {
					DP[i] = DP[j] + 1;
					pickedPointsIndex[i] = j;
				}
			}
			if(max_length < DP[i]) {
				max_length = DP[i];
				lastEndIndex = i;
			}	
		} // outer for loop.

		System.out.println("\nSelected Points are (Printing points in reverse order): ");
		// Print the selected points in Chain.
		while(lastEndIndex != -1) {
			System.out.print("(" + pointsList.get(lastEndIndex).north + ", " + pointsList.get(lastEndIndex).south + ")" + "  ");
			lastEndIndex = pickedPointsIndex[lastEndIndex];
		}

		return max_length;
	}

}