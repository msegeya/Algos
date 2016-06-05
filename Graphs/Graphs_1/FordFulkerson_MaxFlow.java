/**
	Question: Ford Fulkerson problem.
	
	Application: Maximum flow problem. Suppose we have a source "S" and destination "D" now we need to move from source to destination via edges where each edge has a maximum capacity. We must travel in such a path that the destination with max flow.

	Terminalogies: 
		#) Flow Network: Simple directed graph with one source(S) and one destination(T). No negative edges. Each edge had a capacity. And you cannot flow more than the given capacity. If a path from S to T has edges as, S (10)--> A (5)--> B (7)--> T. Now max we can send through this path is the minimum capacity of the edges in the path that is Minimum(10, 5, 7) = 5. So 5 is the best flow we can send through this path.

		#) Residual Graph: Suppose in the above path we havn't used the full capacity except for one edge that is A -> B which is having capacity of 5. Now other edges are still having capacity left with them that is S -> A has remaining capacity of (10 - 5) = 5 and B -> T has remaining capacity of (7 - 5) = 2.
		So now this path will be, S (5)-> A (0)-> B (7)-> T.
		Since the edge S -> A actually contains total weight 10 but after one flow of capacity 5 we remainder with only 5 we need to make the removed 5 appear on the graph by simply creating one reverse edge from A -> S that is of flow capacity 5.
		==> At a time the total capacity of the edge S to A will be (S -> A) + (A -> S) = 5 + 5 = 10 which is the actual weight of this edge.

		#) 

	Reference: 	https://www.youtube.com/watch?v=hmIrJCGPPG4
				https://www.youtube.com/watch?v=GiN3jRdgxU4&feature=youtu.be
				http://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/


	Logic: 
		- Create a graph matrix where value at (i, j) is distance of that edge.
		- Create a Residual graph for the above matrix. Look at what is residual graph definition above.
		- Use BFS to get path from source to destination. If there is a path then return true and also store the parent of each node.
		- For every edge in the BFS path get the values and find the minimum of the edges say "path_flow"
		- Add this path_flow to output.
		- Substract path_flow from each edge in the bove path and add this by creating a new reverse edge for the same edge and add this value to it.
		- You will get a new graph with updated edge values.
		- Do the above BFS until your source cannot reach destination.
		- Finally return output.
*/

import java.util.*;

class FordFulkerson_MaxFlow {
	private int[][] graph;

	private int V;
	private int source;
	private int destination;
	private Set<Integer> visited;

	public static void main(String[] args) {
		FordFulkerson_MaxFlow ffmfObj = new FordFulkerson_MaxFlow();
		ffmfObj.initialize();
		ffmfObj.getMaxFlow();
	}

	public void initialize() {
		V = 6;

		source = 0; destination = 5;

		visited = new HashSet<Integer>();

		graph = new int[V][V];
		graph[0][1] = 16; graph[0][2] = 13;
		graph[1][2] = 10; graph[1][3] = 12;
		graph[2][1] = 4;  graph[2][4] = 14;
		graph[3][2] = 9;  graph[3][5] = 20;
		graph[4][3] = 7;  graph[4][5] = 4;
	}

	public void getMaxFlow() {
		int output = solveFordFulker(graph, source, destination);
		System.out.println("Maxflow is " + output);
	}

	public int solveFordFulker(int[][] graph, int src, int dest) {
		int[][] res_graph = new int[V][V];

		for(int r = 0; r < graph.length; r++) {
			for(int c = 0; c < graph[0].length; c++) {
				res_graph[r][c] = graph[r][c];
			}
		}

		// initially every node parent is 0.
		int[] parent = new int[V];

		// initially max_flow is 0.
		int max_flow = 0;

		// this loop will go on until BFS return false. BFS returns false only when there is no path to destination.
		while(doBFSPath(res_graph, src, dest, parent)) {

			int des_parent = dest;
			int src_parent = parent[dest];

			// Calculate the minimum edge weight of the path.
			int path_flow = Integer.MAX_VALUE;
			while(-1 != src_parent) {

				path_flow = Math.min(path_flow, res_graph[src_parent][des_parent]);
				System.out.println(src_parent + " -> " + des_parent + " = " + path_flow);	

				des_parent = src_parent;
				src_parent = parent[des_parent];
			}

			System.out.println("path Flow is: " + path_flow);

			// Now substract the minimum weight from all the edge weights in the path.
			des_parent = dest;
			src_parent = parent[dest];
			while(-1 != src_parent) {
				res_graph[src_parent][des_parent] -= path_flow;
				res_graph[des_parent][src_parent] += path_flow;

				des_parent = src_parent;
				src_parent = parent[des_parent];	
			}

			max_flow += path_flow;
		}

		return max_flow;
	}

	// Get path from source to destination and store the parent node for each vertex.
	public boolean doBFSPath(int[][] res_graph, int src, int dest, int[] parent) {
		visited.clear();

		Queue<Integer> queue = new LinkedList<Integer>(); 
		
		queue.add(src);

		visited.add(src);
		
		// give parent of src as -1. This is the termination condition while checking parent of each vertex.
		parent[src] = -1;

		while(!queue.isEmpty()) {
			int vertex = queue.remove();
			int adj = 0;

			while(adj < V) {
				if(res_graph[vertex][adj] > 0 && !visited.contains(adj)) {
					visited.add(adj);
					parent[adj] = vertex;
					queue.add(adj);

					if(adj == dest) {
						return true;
					}	
				}

				adj++;
			}
		}

		return false;
	}

}