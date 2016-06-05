/**
	Question: Given a graph and a source and destination. Check whether they are connected or not.

	We can use BFS or DFS. If the question does not mention anythign about the approach then go for BFS. It will given you the shortest path also. But if the question mentions about DFS then proceed furthur.
	For BFS approach, refer ShortestPathBFS.java

	Reference: http://www.geeksforgeeks.org/applications-of-depth-first-search/ --> See heading "Path Finding".

	Logic: (From above link) 
		- We can specialize the DFS algorithm to find a path between two given vertices u and z.
			i) Call DFS(G, u) with u as the start vertex.
			ii) Use a stack S to keep track of the path between the start vertex and the current vertex.
			iii) As soon as destination vertex z is encountered, return the path as the contents of the stack.

*/

import java.util.*;

class PathBtwTwoNodes {

	public int[][] graph;
	public int V;
	public boolean[] visited;
	public int source;

	public static void main(String[] args) {
		PathBtwTwoNodes ptnObj = new PathBtwTwoNodes();
		ptnObj.initialize();	

		ptnObj.findPath();
	}

	public void initialize() {
		V = 6; 
		visited = new boolean[V + 1];
		graph = new int[V + 1][V + 1];

		graph[1][2] = 1; graph[1][6] = 1; 
		graph[2][1] = 1; graph[2][3] = 1; graph[2][5] = 1;
		graph[3][2] = 1; graph[3][4] = 1; 
		graph[4][3] = 1; graph[4][5] = 1; 
		graph[5][4] = 1; graph[5][2] = 1;
		graph[6][1] = 1;

		source = 1;
		GraphUtil.print(graph, source);
	}

	public void findPath() {
		printPath(1, 5);
		printPath(1, 6);
		// Negative case
		printPath(1, 7);
	}

	public void printPath(int src, int dest) {
		List<Integer> path = doDFS(src, dest, graph);
		if(null == path) {
			System.out.println("NO Path exists between " + src + " and " + dest);
		} else {
			System.out.println("Path between " + src + " and " + dest + " is,");
			for(Integer vertex : path) {
				System.out.print(vertex + "\t");
			}
		}
		System.out.println();
	}

	public List<Integer> doDFS(int src, int dest, int[][] matrix) {
		List<Integer> path = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(src);
		visited[src] = true;
		boolean isPathExisits = false;

		while(!stack.isEmpty()) {

			int element = stack.peek();
			path.add(element);
			int adj = 1;
			while(adj <= V) {
				if(matrix[element][adj] == 1 && !visited[adj]) {
					path.add(adj);
					stack.push(adj);
					visited[adj] = true;

					if(adj == dest) {
						isPathExisits = true;
						return path;
					}

					element = adj;
					adj = 1;
				} else {
					adj++;
				}
			}
			stack.pop();
			path.clear();
		}
		
		// If isPathExisits false then return null.
		if(!isPathExisits) {
			return null;
		}

		return path;
	}
}