/**
	Question: Bipartite graph. 

	Reference: 	https://www.youtube.com/watch?v=EVVjGtMpa7w
				https://www.youtube.com/watch?v=JpapV5DrBek
				http://www.sanfoundry.com/java-program-check-whether-graph-bipartite-using-bfs/

	Goal:
		- The goal of a Bipartite is to divide the graph in such a way that there will be two sets say S1 and S2
		where,  S1 intersection S2 = null
				S1 union S2 = All the elements.

	Applications: 
		- Matching pairs for marriage. Suppose we have 5 boys and 5 girls. Each boy can like max of all 5 girls and min of no girls. Similarly the girls. And the condition is no two boys should get married to each other. So all the girls should be colored blue and all the boys should be colored red.

	Logic:	
		- Start from a node. Color it with either RED or BLUE.
		- All the adjacent colors of this node has to be colored with color other than the current vertex color.
		- If you find any node having same color as its adjacent node then "Bipartite graph cannot be constructed."
*/

import java.util.*;

class Bipartite {

	public int[][] matrix;
	public int START;
	public int V;
	public final int RED = 1, BLUE = 2, NO_COLOR = 0;
	// color each vertex with RED or BLUE. Initially all the vertices will have no color.
	public int[] colored;

	public static void main(String[] args) {
		Bipartite bpObj = new Bipartite();
		bpObj.initialize();	

		bpObj.bipartiteGraph();
	}

	public void initialize() {
		V = 4;
		START = 1;
		matrix = new int[V + 1][V + 1];
		colored = new int[V + 1];

		matrix[1][1] = 0; matrix[1][2] = 1; matrix[1][3] = 0; matrix[1][4] = 1; 
		matrix[2][1] = 1; matrix[2][2] = 0; matrix[2][3] = 1; matrix[2][4] = 0; 
		matrix[3][1] = 0; matrix[3][2] = 1; matrix[3][3] = 0; matrix[3][4] = 1; 
		matrix[4][1] = 1; matrix[4][2] = 0; matrix[4][3] = 1; matrix[4][4] = 0;

		GraphUtil.print(matrix);
	}

	public void bipartiteGraph() {
		boolean result = doBFS(matrix, colored, START);

		if(result) {
			System.out.println("Bipartite Graph is: ");
			for(int vertex = 1; vertex <= V; vertex++) {
				System.out.println(vertex + " has color " + ((colored[vertex] == RED) ? "RED" : "BLUE"));
			}
		} else {
			System.out.println("Given graph cannot be biparted.");
		}
	}

	public boolean doBFS(int[][] matrix, int[] colored, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		colored[start] = RED;

		while(!queue.isEmpty()) {
			int element = queue.remove();

			int index = 1;
			while(index <= V) {
				// If there is a link between two vertices and there are of same color then say the given graph cannot be bipartite.
				if(matrix[element][index] == 1 && colored[element] == colored[index]) {
					return false;
				}

				if(matrix[element][index] == 1 && colored[index] == NO_COLOR) {
					colored[index] = (colored[element] == RED) ? BLUE : RED;
					queue.add(index);
				}

				index++;
			}
		}
		return true;
	}
}