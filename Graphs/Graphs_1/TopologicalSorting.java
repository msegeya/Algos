/**
	Question: Topological sorting. 
	NOTE: It's a directional graph. 

	Reference: https://www.youtube.com/watch?v=ddTC4Zovtbc
			   https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/TopologicalSort.java

	Applications: One application of topological sort is including packages. Suppose say we have 4 packages A, B, C and D. Now if package C is dependent on A and B, and package D is dependent on B then before including C we have to include both A and B packages. Similarly we have to include package B before including D.

	Logic:
		- For each vertex do the following,
			1) Take the adj nodes of this vertex.
			  a) If already visited then go to next unvisited node.
			  b) Add the unvisited node to visited set.
			  c) Now do the same procedure for the above unvisited node.
			2) If there is unvisited node left then push this into the stack.
			3) Do this for every vertex in the graph.

	Output: Output should be in such a way that the vertex which does not have any dependencies will be at the top of the Stack. So bottom of the stack will have a lot of dependencies. While moving up the dependencies reduce.	

*/

import java.util.*;

class TopologicalSorting {

	public int V;
	public int[][] matrix;
	public List<Edge> edges;
	public Stack<Integer> stack;
	public Set<Integer> visited;

	public static void main(String[] args) {
		TopologicalSorting tsObj = new TopologicalSorting();
		tsObj.initialize();
		tsObj.printTopoSort();
	}

	public void initialize() {
		V = 7;
		matrix = new int[V + 1][V + 1];
		edges = new ArrayList<Edge>();

		matrix[1][3] = 1; 
		matrix[2][3] = 1; matrix[2][5] = 1;
		matrix[3][4] = 1; 
		matrix[4][6] = 1;
		matrix[6][7] = 1;

		GraphUtil.print(matrix);
	}

	public void printTopoSort() { 
		Stack<Integer> output = doTopoSort();
		System.out.println("Topological order: (NO-DEPENDENT'S TO DEPENDENT) ");
		while(!output.isEmpty()) {
			System.out.print(output.pop() + " -> ");
		}
		/*Iterator<Integer> iter = output.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " -> ");
		}*/
	}

	public Stack<Integer> doTopoSort() {
		stack = new Stack<Integer>();
		visited = new HashSet<Integer>();

		for(int vertex = 1; vertex <= 7; vertex++) {
			if(visited.contains(vertex)) {
				continue;
			}

			topoUtil(vertex, matrix, visited, stack);
		}

		return stack;
	}

	public void topoUtil(int vertex, 
							int[][] matrix, 
								Set<Integer> visited, 
									Stack<Integer> stack) {
		int element = vertex;
		for(int adj = 1; adj <= V; adj++) {
			if(matrix[element][adj] == 1) {
				if(visited.contains(adj)) {
					continue;
				}

				visited.add(adj);
				topoUtil(adj, matrix, visited, stack);
			}
		}

		// If no adjacent vertices are there for this vertex then push it to stack.
		stack.push(element);
	}

}