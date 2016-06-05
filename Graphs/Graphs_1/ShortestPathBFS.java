/**
	Question: Find shortest path between two nodes of an UNWEIGHTED graph.
	NOTE: 
	1. The reason why we are not using DFS is, DFS just tells us whether the two nodes has a path between them or not. But what we actually need is the shortest path between the two nodes.
	2. This works only for UNWEIGHTED graph. If the graph is WEIGHTED then go for Dijkstra's algorithm.

	Reference: https://www.youtube.com/watch?v=n-0JFFXuZ0c

	Logic:
		- Use BFS. Start from source and enqueue all the unvisited nodes into the queue and mark them as visited.
		- Then poll the next element and do the same if the link ndoe is unvisited.
		- Do until you find the destination.

		- How do we keep track of distance that is hops?
		  => Initiaze the distance of source with 0. Now distance of every link of source will be calculated by distance[link_node] = distance[source_from_where_it_came] + 1;
		  So when the destination is reached then return the distance[destination]

		- How to print the path?
			Similar to distance for every unexplored node save the parent (that is the immedaite node from which it is reached) and then by using parent array you can easily print the path.
*/

import java.util.*;

class ShortestPathBFS {

	public int V;
	public int[][] matrix;
	public int[] distance;
	public boolean[] visited;
	public int[] parent;

	public static void main(String[] args) {
		ShortestPathBFS spbObj = new ShortestPathBFS();
		spbObj.initialize();
		spbObj.shortestPath();
	}

	public void initialize() {
		V = 4;
		matrix = new int[V + 1][V + 1];
		distance = new int[V + 1];
	    visited = new boolean[V + 1];
	    parent = new int[V + 1];

		matrix[1][2] = 1; matrix[1][3] = 1;
		matrix[2][1] = 1; matrix[2][3] = 1;
		matrix[3][1] = 1; matrix[3][2] = 1; matrix[3][4] = 1;
	}

	public void shortestPath() {
		int source = 1;
		int des = 4;

		int cost = doBFS(source, des);
		System.out.println("Shortest Path between " + source + " and " + des + " is " + cost);

		printShortestPath(parent, source, des);
	}

	public int doBFS(int source, int dest) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		

		while(!queue.isEmpty()) {
			int element = queue.poll();

			int index = 1;
			while(index <= V) {
				if(matrix[element][index] == 1 && !visited[index]) {
					queue.add(index);
					visited[index] = true;
					parent[index] = element;

					distance[index] = distance[element] + 1;

					if(index == dest) {
						return distance[index];
					}
				} 
				index++;
			}
		}

		return -1;
	}

	public void printShortestPath(int[] parent, int src, int des) {
		while(des != src) {
			System.out.print(des + "\t");
			des = parent[des];
		}
		System.out.print(src);
	}
}