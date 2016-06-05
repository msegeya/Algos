/**
	Question: Connect ropes at minimum cost. You will be given a set of ropes where each rope has a cost. When we add two ropes the cost for adding will be the sum of two ropes. Now connect all these ropes such that the cost is minimum.
	
	Reference: http://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/

	Logic: 
		- Add all the ropes to Heap. (MIN_HEAP)
		- Let us say given ropes are of lenght 5, 2, 6, 1
			Adding 5 and 2 gives 7
			Adding 7 and 6 gives 13
			Adding 13 and 1 gives 14 so total cost is 14.
		- But we can also do the same in less cost. Sort the list => 1, 2, 5, 6
			Adding 1 and 2 gives 3. Now insert back the result into the heap. Take the next 2 minimum elements.
			Adding 3 and 5 gives 8.
			Adding 6 and 8 gives 14.
				
*/

import java.util.*;

class ConnectRopes {

	public int[] ropes;

	public static void main(String[] args) {
		ConnectRopes cpObj = new ConnectRopes();
		cpObj.initialize();

		cpObj.printMinCost();
	}

	public void initialize() {
		ropes = new int[4];
		ropes[0] = 4;
		ropes[1] = 3;
		ropes[2] = 2;
		ropes[3] = 6;
	}

	public void printMinCost() {
		System.out.println("Min Cost is: " + connectRopes(ropes));
	}

	public int connectRopes(int[] ropes) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(ropes.length, new SortRopes());

		for(int i = 0; i < ropes.length; i++) {
			pq.add(ropes[i]);
		}

		int count = 1;
		int cost = 0;
		int min_cost = 0;
		while(count <= ropes.length - 1) {
			int rope_1 = pq.poll();
			int rope_2 = pq.poll();

			cost = rope_1 + rope_2;
			min_cost += cost;
			// insert it back to queue.
			pq.add(cost);

			count++;
		}

		return min_cost;
	}
}

class SortRopes implements Comparator<Integer> {
	@Override
	public int compare(Integer i1, Integer i2) {
		return i1 - i2;
	}
}