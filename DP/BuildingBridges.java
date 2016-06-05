/**
	Question: Building Bridges. Consider a 2-D map with a horizontal river passing through its center. 
			There are n cities on the southern bank with x-coordinates a(1) ... a(n) and n cities on the northern bank with x-coordinates b(1) ... b(n). You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross. 
			When connecting cities, you can only connect city "i" on the northern bank to city "i" on the southern bank."
											
													##### NORTH ##### 
										city-1			city-2			city-3
							RIVER --------------------------------------------------------- RIVER
											city-2				city-1			city-3
													##### SOUTH ##### 


	Source: http://people.cs.clemson.edu/~bcdean/dp_practice/
			http://stackoverflow.com/questions/19469485/longest-incresing-subsequence-to-solve-building-bridge
			http://stackoverflow.com/questions/7288585/building-bridges-problem-how-to-apply-longest-increasing-subsequence

	NOTE: "This preoblem is Variation of LIS (Longest Increasing Sub-Seq problem)"		

	Example: Northern Bank >> 7 4 3 6 2 1 5
			 Southern Bank >> 5 3 2 4 6 1 7
			 We need to make a bridge with same numbers from North side with the same number on the south side. Such that no two bridges should cross each other.
			 NOTE: The points(North, South) are paired we cannot change one without respecting the other position. 
			 That is 7 in North should always have 5 in south on the other side.

	Logic: 
		- We need to use LongestIncreasingSubSeq.java logic here.
		- Let given points be, 
						Northern Bank >> 7 4 3 6 2 1 5
						Southern Bank >> 5 3 2 4 6 1 7
		- Sort the points on one side .. let's say we sort them basing on the south value.
						Northern Bank >> 1 3 4 6 7 2 5
						Southern Bank >> 1 2 3 4 5 6 7
		- Now let us say we are having indexes to all these postions.
						Indexes ---> 0 	 1 	 2 	 3 	 4 	 5 	 6
						North   ---> 1 	 3 	 4 	 6 	 7 	 2 	 5
						South   ---> 1 	 2 	 3 	 4 	 5 	 6 	 7
			Take an integer array say X. Since we have sorted using South values we will take the SAME value in North and store the index value in array X.
			For value 1 in South, take the same value 1 in North which is at index = 0. ---> X = {0}
			For value 2 in South, at index 5 we have the same value 2 ---> X = {0, 5} . Hence we will add index 5 to array.
			For 3, index = 1 ---> X = {0, 5, 1}
			For 4, index = 2 ---> X = {0, 5, 1, 2}
			For 5, index = 6 ---> X = {0, 5, 1, 2, 6}
			For 6, index = 3 ---> X = {0, 5, 1, 2, 6, 3}
			For 7, index = 6 ---> X = {0, 5, 1, 2, 6, 3, 4}
		- Take this array X as input and calcualte LIS.
		- LIS result for X is, {0, 1, 2, 3, 4}
		- Now since these are the index values we need to get the corressponding North point values 
						==> values are {1, 3, 4, 6, 7}
		- Hence join these values points on both sides i,e. (1, 1), (3, 3), (4, 4), (6, 6), (7, 7).
		  These are the bridges that can be formed such that no two bridges cross eachother.
*/

import java.util.*;

class BuildingBridges {
	public static void main(String[] args) {
		BuildingBridges bbObj = new BuildingBridges();

		int[] NORTH = {7, 4, 3, 6, 2, 1, 5};
		int[] SOUTH = {5, 3, 2, 4, 6, 1, 7};

		bbObj.printBridgesCount(NORTH, SOUTH);
	}

	void printBridgesCount(int[] NORTH, 
								int[] SOUTH) {
		int[] points = getBridgePoints(NORTH, SOUTH);
		System.out.println("\nBridges count: " + points.length);
	}

	int[] getBridgePoints(int[] NORTH, 
										int[] SOUTH) {
		int[] bridgePoints = getPointsUsingLIS(NORTH, SOUTH);
		
		System.out.print("Bridge Points without crosses: ");
		for(int point : bridgePoints) {
			System.out.print(point + " ");
		}
		
		return bridgePoints;
	}


	/*
		How to sort the points?
		Since we need to sort the points based on South values we will create a PQ and insert all the points and the pq remove logic is based on the South points.


	*/
	int[] getPointsUsingLIS(int[] NORTH, 
									int[] SOUTH) {
		int[] Xindices = new int[NORTH.length];

		// sort the points using priority queue.
		// NOTE: PQ will be sorted but when you debug it does not show the elements as sorted 
		// but when you poll them it returns points in sorted order.
		SortSouthPoints sortPointObj = new SortSouthPoints();
		PriorityQueue<Point> pq = new PriorityQueue<Point>(SOUTH.length, sortPointObj);
		for(int index = 0; index < SOUTH.length; index++) {
			pq.add(new Point(NORTH[index], SOUTH[index]));
		}

		// After sorting we need to save the index position of the north element and viceversa.
		Map<Integer, Integer> mapKeyToIndexes = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapIndexToKey = new HashMap<Integer, Integer>();
		int index = 0;
		while(!pq.isEmpty()) {
			Point p = pq.remove();

			// For each point in PQ, get the south value and put the north value as key and index value as value.
			mapKeyToIndexes.put(p.north, index);

			// This is used to print the output after LIS operation.
			mapIndexToKey.put(index, p.north);

			index++;
		}
		
		// After sorting and storing in map.
		// For each sorted element of SOUTH end, get the index of the same element in NORTH end.
		int k = 0;
		Arrays.sort(SOUTH);
		for(int southEle : SOUTH) {
			Xindices[k++] = mapKeyToIndexes.get(southEle);
		}
		
		// Calculate the LIS. Which we will convert to actual values.
		int[] pickedIndices = calcualteLIS(Xindices);

		// Get the values of these indexes.
		int[] pointValues = new int[pickedIndices.length];
		k = 0;

		// Store all the respective values of the picked index from mapIndexToKey.
		for(int pickIndex : pickedIndices) {
			pointValues[k] = mapIndexToKey.get(pickIndex);
			k++;
		}

		return pointValues;
	}

	/**
		Check if current value is greater than previous value 
			AND
		Check if (DP_of_prev_index_value + 1) > DP_current_index.
	*/
	int[] calcualteLIS(int[] Xindices) {
		
		int length = Xindices.length;
		int[] DP = new int[length];
		
		int[] pickedIndices = new int[length];
		pickedIndices[0] = -1;

		// max_length is 1 since each element itself will be the longest.
		int max_length = 1;

		// Since at least an element itself can be the leongest one so 
		int bestEndIndex = 0;

		DP[0] = 1;
		for(int i = 1; i < length; i++) {
			
			DP[i] = 1;
			pickedIndices[i] = -1;
			
			for(int j = i - 1; j >= 0; j--) {
				if((Xindices[i] > Xindices[j]) && 
										((DP[j] + 1) > DP[i])) {
					DP[i] = DP[j] + 1;

					pickedIndices[i] = j;
				}
			}

			if(max_length < DP[i]) {
				max_length = DP[i];
				bestEndIndex = i;
			}
		}

		List<Integer> longSeqList = new ArrayList<Integer>();
		while(bestEndIndex != -1) {
			longSeqList.add(Xindices[bestEndIndex]);
			bestEndIndex = pickedIndices[bestEndIndex];
		}

		int[] output = new int[longSeqList.size()];
		for(int index = 0; index < longSeqList.size(); index++) {
			output[index] = longSeqList.get(index);
		}

		return output;
	}
}