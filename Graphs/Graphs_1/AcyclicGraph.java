/**
	Question: Assign directions to edges so that the directed graph remains acyclic. Given a graph with directed edges and undirected edges. All the directed edges will not form any cycle. Now we need to add directions to undirected edges such that there will be no cycle formed.

	Reference: http://www.geeksforgeeks.org/assign-directions-to-edges-so-that-the-directed-graph-remains-acyclic/

	Logic: (Two methods using Disjoint sets and using Topological sorting.)
		Using Disjoint sets: We cannot use disjoint sets for directed graph.
		NOTE: UNION-FIND algorithm can be used to check whether an UNDIRECTED GRAPH (not for directed graph) has cycle or not.
		We can use either DFS or topological sorting.

		Using Topological Sorting:
			- For every vertex in the graph using the DIRECTED EDGE do the following,
				1) If not visited then mark it as visited
				2) For each adjacent vertex of the given vertex do the following,
					i) If the adj is already visited then continue.
				   ii) If the adj is not visited then mark it as visited and then do the same procedure for every adjacent vertex.
				  iii) If there are no adjacent vertices to be explored then add it to the stack.
				3) Finally top of the stack will have the vertex that has no pre-requisites and the bottom will have pre-requisite vertices above it.
			- Now for each unvisited edge check if src came before vertex in the topological order. 
			  If so then edge is from "src to des" else edge is from "des to src".
*/

import java.util.*;

class AcyclicGraph {

	public int N;
	public int[][] matrix;
	public List<Edge> undirEdges;
	public Stack<Integer> topoStk;
	public Set<Integer> visited;
	public List<Integer> topoList;

	public static void main(String[] args) {
		AcyclicGraph agObj = new AcyclicGraph();
		agObj.intialize();

		agObj.useTopoSort();
	}

	public void intialize() {
		N = 6;
		topoStk = new Stack<Integer>();
		visited = new HashSet<Integer>();
		topoList = new ArrayList<Integer>();

		matrix = new int[N][N];
		matrix[0][1] = 1; matrix[0][5] = 1; 
		matrix[1][2] = 1; matrix[1][3] = 1; matrix[1][4] = 1; 
		matrix[2][3] = 1; matrix[2][4] = 1; 
		matrix[3][4] = 1;
		matrix[5][1] = 1; matrix[5][1] = 1;

		undirEdges = new ArrayList<Edge>();
		undirEdges.add(new Edge(0, 2));
		undirEdges.add(new Edge(0, 3));
		undirEdges.add(new Edge(4, 5));
	}

	public void useTopoSort() {
		for(int vertex = 0; vertex < N; vertex++) {
			if(visited.contains(vertex)) {
				continue;
			} else {
				topoUtil(vertex, matrix, visited, topoStk);
			}
		}

		System.out.println("Topological order: (NO-DEPENDENT'S TO DEPENDENT) ");
		while(!topoStk.isEmpty()) {
			int popVertex = topoStk.pop();
			System.out.print(popVertex + "\t");
			topoList.add(popVertex);
		}
		System.out.println();

		for(Edge edge : undirEdges) {
			int src_edge = edge.src;
			int des_edge = edge.des;

			int src_edge_index = -1;
			int des_edge_index = -1;

			// get the index positions and compare them. If src_edge index is before des_edge then src_edge to des_edge is the direction else the opposite.
			for(int i = 0; i < topoList.size(); i++) {
				int vertex = topoList.get(i);
				if(src_edge == vertex) {
					src_edge_index = i;
				}

				if(des_edge == vertex) {
					des_edge_index = i;
				}

				if(-1 != src_edge_index && -1 != des_edge_index) {
					break;
				}
			}

			if(src_edge_index < des_edge_index) {
				System.out.println("Edge must have direction from " + src_edge + " to " + des_edge);
			} else {
				System.out.println("Edge must have direction from " + des_edge + " to " + src_edge);
			}
		}
	}

	public void topoUtil(int vertex, int[][] matrix, Set<Integer> visited, Stack<Integer> topoStk) {

		for(int adj = 0; adj < N; adj++) {
			if(visited.contains(adj)) {
				continue;
			}

			if(matrix[vertex][adj] == 1) {
				visited.add(adj);
				topoUtil(adj, matrix, visited, topoStk);	
			}
		}

		// If there are no adjacent vertices present then add the vertex to topological order.
		topoStk.push(vertex);
	}

}