/**
	Question Prims algorithm to find the minimum spanning tree.
	
	Reference: https://www.youtube.com/watch?v=Pn874kEc3IA

	Applications: http://stackoverflow.com/questions/7320465/applications-of-kruskal-and-prims-algorithms

	Logic: 
		- Remove all loops. A loop is nothing but an edge where start and end vertex are same.
		  ==> If egde has same src and des same then ignore that from the edge list.
		- Remove all parallel edges. If two edge are like (A to B) = 10 and (A to B) = 20 then select the one with minimum weight  that is (A to B) = 10.
		- Now we have final list of edges with no loops and parallel edges.
		- Now we will apply DFS on this. Start from a node and see what is the minimum weight vertex from this node. If the node is not yet visisted then add this edge in final list and mark the visited node as true.
		- Continue until all the vertices are visited.
*/

import java.util.*;

class PrimsAlgo {

	public int V;
	public List<Edge> edges;
	public int source;
	public int[][] matrix;
	public boolean[] visited;

	public static void main(String[] args) {
		PrimsAlgo paObj = new PrimsAlgo();
		paObj.initialize();
		paObj.cleanEdges();
		paObj.printMinSpanGraph();
	}

	public void initialize() {
		V = 4; // total vertices

		visited = new boolean[V + 1];
		edges = new ArrayList<Edge>();

 		// from vertex 1
		Edge edge1 = new Edge(1, 1, 8); edges.add(edge1);
		Edge edge2 = new Edge(1, 2, 5); edges.add(edge2);
		Edge edge3 = new Edge(1, 3, 10); edges.add(edge3);
		Edge edge4 = new Edge(1, 3, 12); edges.add(edge4);
		Edge edge16 = new Edge(1, 4, -1); edges.add(edge16);

		// from vertex 2
		Edge edge5 = new Edge(2, 1, 5); edges.add(edge5);
		Edge edge6 = new Edge(2, 3, 4); edges.add(edge6);
		Edge edge7 = new Edge(2, 4, 11); edges.add(edge7);

		// from vertex 3
		Edge edge8 = new Edge(3, 1, 12); edges.add(edge8);
		Edge edge9 = new Edge(3, 1, 10); edges.add(edge9);
		Edge edge10 = new Edge(3, 2, 4); edges.add(edge10);
		Edge edge11 = new Edge(3, 4, 5); edges.add(edge11);
		
		// from vertex 4
		Edge edge12 = new Edge(4, 1, -1); edges.add(edge12);
		Edge edge13 = new Edge(4, 2, 11); edges.add(edge13);
		Edge edge14 = new Edge(4, 3, 5); edges.add(edge14);
		Edge edge15 = new Edge(4, 4, 4); edges.add(edge15);

		GraphUtil.printEdges(edges, "Printing all edges.");
		System.out.println("Total Edges: " + edges.size());
	}

	public void cleanEdges() {
		// 1. Remove loops
		edges = GraphUtil.removeLoops(edges);
		GraphUtil.printEdges(edges, "Printing edges after removing loops.");

		// 2. Remove parallel edges
		edges = GraphUtil.removeParEdges(edges);
		GraphUtil.printEdges(edges, "Printing edges after removing Parallel Edges.");

		// 3. Prepare adjacent matrix.
		matrix = GraphUtil.preMatrixFromEdges(edges, V);
		System.out.println("After converting all edges to adjacent matrix: ");
		GraphUtil.print(matrix);
	}

	public void printMinSpanGraph() {
		int start = 1;
		List<Edge> output = doPrimsAlgo(matrix, start);
		GraphUtil.printEdges(output, "Final selected edges are: ");

		System.out.println("Weight of the MST is " + GraphUtil.getWgt(output));
	}

	public List<Edge> doPrimsAlgo(int[][] matrix, int start) {
		List<Edge> output = new ArrayList<Edge>();

		int row = start;
		visited[row] = true;
		while(row <= V) {
			int min_weight = Integer.MAX_VALUE;
			int min_col = -1;

			// Get the minimum edge weight of all the adjacent nodes of this vertex.
			for(int col = 1; col < matrix[0].length; col++) {
				if(row != col && matrix[row][col] != -1 && !visited[col]) {
					int edge_wgt = matrix[row][col];
					if(edge_wgt < min_weight) {
						min_weight = edge_wgt;
						min_col = col;
					}
				}
			}
			
			visited[min_col] = true;
			output.add(new Edge(row, min_col, min_weight));
			row = min_col;

			// termination condition. To cover all the vertices we need at max (V - 1) edges.
			if(output.size() == (V - 1)) {
				break;
			}
		}

		return output;
	}
}