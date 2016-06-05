/**
	Question: Depth First Search of a tree.

	Reference: http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
				http://www.sanfoundry.com/java-program-traverse-graph-using-dfs-2/

	Logic: 
		- Start from source. Push it to stack and make visited of it as true.
		- Now get the top of the stack and say it as "element" and check whether it has any unvisited edges.
		- If there are any unvisited edge then push it on to stack and mark it as visited and now use this unvisited vertex as element and start the same procedure again.
		- Else continue the process again.
		- Continue this until the stack is empty.
		- Everytime you make a vertex as visited then print it.

*/

import java.util.*;

class DFS {

	public int[][] graph;
	public int V;
	public boolean[] visited;
	public int source;

	public static void main(String[] args) {
		DFS dfsObj = new DFS();
		dfsObj.initialize();

		dfsObj.printDFS();
	}

	public void initialize() {
		V = 4; 
		visited = new boolean[V + 1];
		graph = new int[V + 1][V + 1];
		graph[1][1] = 0; graph[1][2] = 1; graph[1][3] = 0; graph[1][4] = 1;
		graph[2][1] = 0; graph[2][2] = 0; graph[2][3] = 1; graph[2][4] = 0;
		graph[3][1] = 0; graph[3][2] = 1; graph[3][3] = 0; graph[3][4] = 1;
		graph[4][1] = 0; graph[4][2] = 0; graph[4][3] = 0; graph[4][4] = 1;

		source = 1;
		GraphUtil.print(graph, source);
	}

	public void printDFS() {
		doDFS(V, graph, source, visited);
	}

	public void doDFS(int total, int[][] matrix, int source, boolean[] visited) {
		System.out.println("DFS visited order is: ");

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		visited[source] = true;
		System.out.print(source + "\t");

		while(!stack.isEmpty()) {
			int element = stack.peek();

			int index = 1;
			while(index <= total) {
				if(matrix[element][index] == 1 && !visited[index]) {
					stack.push(index);
					visited[index] = true;

					System.out.print(index + "\t");

					element = index;
					index = 1;

					continue;
				} else {
					index++;
				}
			}
			stack.pop();
		}
	}

}