/**
	Question: All pairs shortest path for directional graph.

	Source: http://www.geeksforgeeks.org/dynamic-programming-setInteger.MAX_VALUE6-floyd-warshall-algorithm/
			https://www.youtube.com/watch?v=EMAoMMsA5Jg
	
	NOTE: We can use Dijsktra's single source shortest path => It's more efficient.

	Logic: O(n^3)
		- Graph is directional so we won't have distance for each node to another node unless it is connected directly.
		- Take intermitent node say K and if there is a path between 'i' and 'j' (not necessarly direct) such that k is in between them,  then dist[i][j] = if(dist[i][k] + dist[k][j] < dist[i][j]) then update
				dist[i][j] = dist[i][k] + dist[k][j];
		- See code-commnets for more details.
*/

class AllPairsShortestPath {
	public static void main(String[] args) {
		int[][] graph = {
							{0, 5, Integer.MAX_VALUE, 10},
							{Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE},
							{Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
							{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
						};
	
		AllPairsShortestPath apspObj = new AllPairsShortestPath();
		apspObj.printAllShortPaths(graph);	
	}

	void printAllShortPaths(int[][] graph) {
		int[][] dist = getAllShortDist(graph);
		System.out.println("Final All Pairs Shortest Distance.");
		print(dist);
	}

	int[][] getAllShortDist(int[][] graph) {
		int[][] dist = new int[graph.length][graph[0].length];

		// copy all the graph matrix data to the dist matrix data
		for(int row = 0; row < dist.length; row++) {
			for(int col = 0; col < dist[0].length; col++) {
				dist[row][col] = graph[row][col];
			}
		}

		// Take each of the vertex as VIA node k
		for(int k = 0; k < dist.length; k++) {
			for(int row = 0; row < dist.length; row++) {
				for(int col = 0; col < dist[0].length; col++) {
					// the intermitenent k should neigther be row or col.
					if(row != k && col != k) {
						// If the nodes are not reachable then keep the value same.
						// If the distance using via is less than the original distance then update the cell with via distance. 
						if(dist[row][k] != Integer.MAX_VALUE 
									&& dist[k][col] != Integer.MAX_VALUE 
										&& (dist[row][k] + dist[k][col] < dist[row][col])) {
							dist[row][col] = dist[row][k] + dist[k][col];
						}
					}
				} // col loop
			} // row loop
		} // kth loop

		return dist;
	} // method ended

	void print(int[][] dist) {
		for(int row = 0; row < dist.length; row++) {
			for(int col = 0; col < dist[0].length; col++) {
				if(dist[row][col] != Integer.MAX_VALUE) {
					System.out.print(dist[row][col] + "\t");	
				} else {
					System.out.print(-1 + "\t");
				}
				
			}
			System.out.println();
		}
	}
}