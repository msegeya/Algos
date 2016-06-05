/**
	Question: Strongly connected componenets

	What is Strongly Connected Components? 
	==> A Strongly connected componenets is a set of nodes where each node in that componenet can reach every other node.

	Reference: https://www.youtube.com/watch?v=RpgcYiky7uw

	Applications: 
		- Find groups of people who are more closely related in a huge set of data. Think of facebook and how they recommend people that might be your friends.
		- Model checking: Given a system then exhaustively and automatically check whether this model meets given specifications or not.

	Logic: 
		- For every node in the graph,
			1)
			-> Check if the node is already visited. If so then continue to next node.
			-> Else mark it as visited and check out for adjacent nodes.
			-> For each adjacent node do the above procedure.
			-> Do this until there is unvisited adjacent node for this vertex.
			-> Push it into the stack.
		- 	
			-> Once all the nodes are in the stack. 
			-> Clear the visited set.
			-> Revere the edges in the graph. If there is an edge between 1 -> 2 then make it as 2 -> 1.
			-> Now for each popped vertex from the stack do,
				1) If it is already visited then continue to pop the next vertex from the stack.
				2) Else mark it as visited and check the adjacents nodes of this vertex and do the following
				3) If the adj vertex is not visited yet and has a link then add it to the visited list and do the same above procedure.
				4) Do this until all the adjacents of the given vertex are explored.
				5) Add them all to a set and it will be out first component.
		- 	Now take the next node and see if it visited or not. If not visited then do the abvoe procedure to get the next componenet.
*/

import java.util.*;

class StronglyConnected {
	private Stack<Integer> stack;
	private Set<Integer> visited;
	private int[][] graph;
	private int V;

	public static void main(String[] args) {
		StronglyConnected scObj = new StronglyConnected();
		scObj.initialize();

		scObj.printStrongComp();
	}

	public void initialize() {
		V  = 11;
		stack = new Stack<Integer>();
		visited = new HashSet<Integer>();
		graph = new int[V + 1][V + 1];

		graph[1][2] = 1;
		graph[2][3] = 1; graph[2][4] = 1;
		graph[3][1] = 1;
		graph[4][5] = 1;
		graph[5][6] = 1;
		graph[6][4] = 1;
		graph[7][6] = 1; graph[7][8] = 1;
		graph[8][9] = 1;
		graph[9][10] = 1;
		graph[10][11] = 1; graph[10][7] = 1;

		GraphUtil.print(graph);
	}

	public void printStrongComp() {
		List<Set<Integer>> output = doDFS(graph, visited, stack, V);

		if(null == output) {
			System.out.println("No Connected componenets.");
		} else {
			System.out.println("Strongly Connected Componenets are: ");
			StringBuilder builder = new StringBuilder();
			for(Set<Integer> setOut : output) {
				Iterator<Integer> iter = setOut.iterator();
				while(iter.hasNext()) {
					builder.append(iter.next());
					builder.append(" ");
				}
				System.out.println(builder.toString());
				builder.setLength(0);
			}
		}
	}

	public List<Set<Integer>> doDFS(int[][] graph,
									Set<Integer> visited, 
										Stack<Integer> stack, 
											int V) {

		List<Set<Integer>> output = new ArrayList<Set<Integer>>();

		for(int vertex = 1; vertex <= V; vertex++) {
			if(visited.contains(vertex)) {
				continue;
			}

			dfsUtil(vertex, visited, stack, graph);
		}

		// Now we will rever the graph
		graph = reverseGraph(graph);

		// clear the visited set
		visited.clear();

		while(!stack.isEmpty()) {
			int popVertex = stack.pop();
			if(visited.contains(popVertex)) {
				continue;
			}

			Set<Integer> conCompSet = new HashSet<Integer>();
			revereDfsUtil(popVertex, conCompSet, stack, graph, visited);
			output.add(conCompSet);
		}

		return output;
		
	}

	public void dfsUtil(int vertex, 
							Set<Integer> visited, 
								Stack<Integer> stack, 
									int[][] graph) {
		visited.add(vertex);

		for(int adj = 1; adj <= V; adj++) {
			if(visited.contains(adj)) {
				continue;
			}
			if(graph[vertex][adj] == 1) {
				dfsUtil(adj, visited, stack, graph);
			}
		}

		// System.out.println(vertex);
		stack.push(vertex);
	}

	public void revereDfsUtil(int vertex, 
									Set<Integer> conCompSet, 
										Stack<Integer> stack, 
											int[][] revGraph, 
												Set<Integer> visited) {
		visited.add(vertex);
		conCompSet.add(vertex);

		for(int adj = 1; adj <= V; adj++) {
			if(visited.contains(adj)) {
				continue;
			}
			
			if(revGraph[vertex][adj] == 1) {
				revereDfsUtil(adj, conCompSet, stack, revGraph, visited);
			}
				
		}
	}

	public int[][] reverseGraph(int[][] graph) {
		int[][] matrix = new int[V + 1][V + 1];

		// System.out.println("Rows : " + graph.length + " Columns: " + graph[0].length);

		for(int r = 1; r < graph.length; r++) {
			for(int c = 1; c < graph[0].length; c++) {
				if(graph[r][c] == 1) {
					matrix[c][r] = 1;
				}
			}
		}

		/*matrix[2][1] = 1;
		matrix[3][2] = 1; matrix[4][2] = 1;
		matrix[1][3] = 1;
		matrix[5][4] = 1;
		matrix[6][5] = 1;
		matrix[4][6] = 1;
		matrix[6][7] = 1; matrix[8][7] = 1;
		matrix[9][8] = 1;
		matrix[10][9] = 1;
		matrix[11][10] = 1; matrix[7][10] = 1;*/
		return matrix;
	}
}