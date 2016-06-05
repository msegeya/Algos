/**
	Question: Dijkstra’s shortest path algorithm. Given a vertex calculate the shortest distance between the given vertex and all other vertices. And note there should be no negative edges.

	NOTE: Dijkstra’s Algo works both for directed and undirected graph. The only condition for this algorith is all weights should be >= 0. It won't work for negative edges. If you have negative edges then use Bellmanford Algorith.

	Why Dijkstra’s does not work for negative edges? (http://stackoverflow.com/a/13159425/967638)
	Recall that in Dijkstra's algorithm, once a vertex is marked as "closed" (and out of the open set) - the algorithm found the shortest path to it, and will never have to develop this node again - it assumes the path developed to this path is the shortest.

	Reference: 	https://www.youtube.com/watch?v=1057z9XTfcs
				https://www.youtube.com/watch?v=WOCV2UcxNrI
				http://stackoverflow.com/a/13159425/967638

	Logic: Please see code comments.
		- Start from the source vertex.
		- Create a matrix. Initialize source vertex with 0 and all other remaining vertices with INFINITY.
		- For each adjacent vertex if,
			1) If it is not visisted yet then caluclate the min.
			2) calculate Min(distance_at_adj_vertex, current_vertex_distance + Edge_distance_from_vertex_to_edge)
		- Now mark the vertex as visited and check for the next minimum value of the vertices
*/

import java.util.*;

class Dijkstra_Algo {

	public int[][] graph;
	public int V;
	public Set<Integer> visited;

	public static void main(String[] args) {
		Dijkstra_Algo djaObj = new Dijkstra_Algo();
		djaObj.initialize();

		djaObj.getBestPath();
	}

	public void initialize() {
		V = 6;
		graph = new int[V][V];
		visited = new HashSet<Integer>();

		
		graph[0][1] = 10; graph[0][2] = 5;  
		graph[1][2] = 8; graph[1][3] = 12; graph[1][4] = 6;
		graph[2][4] = 12; 
		graph[3][4] = 5; graph[3][5] = 4;    
		graph[4][5] = 6; graph[4][3] = 5;
	}

	public void getBestPath() {
		int src = 0, des = 5;
		int shortest_dist = doDijkstra(src, des, graph, visited);
		System.out.println("Distance between " + src + " and " + des + " is " + shortest_dist);
	}

	/*
		A bit tricky implementation.
		$) Calculate 0th row of the matrix. Source vertex will have 0 and the rest will have INFINITY.
		$) Keep of variable row_count to keep track of the rows. NOTE-It just keeps track of the rows. Nothing more than that.
		$) For every row get the node which has the minimum value and let the vertex be "choosen_vertex"
		$) Now we need to check adjacents vertices of all the choosen_vertex.
		$) But if the adjacent vertex already has a value and now we need to compare the value with choosen_vertex to adjacent and get the minimum of it. To get the previous value of the adjacent vertex we need row_count. Using (row_count - 1) we will get the previous value of the adjacent vertex.
	*/
	public int doDijkstra(int src, int des, int[][] graph, Set<Integer> visited) {
		int[][] dist_matrix = new int[V][V];

		// initialize distance matrix for 0th row.
		for(int col = 0; col < V; col++) {
			if(col == src) {
				dist_matrix[0][col] = 0;
			} else {
				dist_matrix[0][col] = Integer.MAX_VALUE;
			}
		}
		
		int row_count = 1;
		while(row_count < V) {
			int choosen_vertex = getMinColOfRow(dist_matrix[row_count- 1], visited);
			int min_value = dist_matrix[row_count - 1][choosen_vertex];
			visited.add(choosen_vertex);
			
			for(int col = 0; col < V; col++) {
				if(graph[choosen_vertex][col] > 0) {
					if(!visited.contains(col)) {
						dist_matrix[row_count][col] = Math.min(dist_matrix[row_count - 1][col], 
																min_value + graph[choosen_vertex][col]);
					} else {
						dist_matrix[row_count][col] = dist_matrix[row_count - 1][col]; 
					}
				} else {
					dist_matrix[row_count][col] = dist_matrix[row_count - 1][col];
				}
			}
			
			row_count++;
		}
		
		// finally return the destination column value of the last row.
		return dist_matrix[V - 1][des];
	}

	public int getMinColOfRow(int[] row_data, Set<Integer> visited) {
		int min_value = Integer.MAX_VALUE;
		int min_col = -1;

		for(int col = 0; col < V; col++) {
			if(visited.contains(col)) {
				continue;
			}
			if(min_value > row_data[col]) {
				min_value = row_data[col];
				min_col = col;
			}
		}

		return min_col;
	}
}