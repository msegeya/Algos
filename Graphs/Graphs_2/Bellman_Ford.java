/**
	Question: Bellman-Ford shortest path algorithm. The goal is to find the shortest distance from source vertex to all other vertices even if the graph has a negative edge.

	Application: Routing.

	Reference:  https://www.youtube.com/watch?v=obWXjtg0L64
				https://www.youtube.com/watch?v=hxMWBBCpR6A

	Logic: 
		- The logic is same as Dijkstra's while calculating the minimum distance fo each vertex.
		- Start by initializing 0th row of "dist_mtrx" with src as 0 and the rest as INFINITY.
		- Now for every edge, (all edges not just source edges). If the edge(u, v), "u" has a value other INFINITY then calculate minimum value using the formula as v.d = Math.min(v.d, u.v + wgt(u, v)); 
		- Do this for (V - 1) iterations.
		- To check whether there is a negative cycle or not we need to go for one more iteration.
*/

import java.util.*;

class Bellman_Ford {

	public int V;
	public int[][] dist_mtrx;
	public List<Edge> edges;
	public int source;

	public static void main(String[] args) {
		Bellman_Ford bfObj = new Bellman_Ford();
		bfObj.initialize();

		bfObj.printAllPaths();
	}

	public void initialize() {
		V = 4;
		dist_mtrx = new int[V + 1][V];
		source = 0;
		edges = new ArrayList<Edge>();

		Edge edge01 = new Edge(0, 1, 5); edges.add(edge01);
		Edge edge02 = new Edge(0, 2, 2); edges.add(edge02);
		Edge edge10 = new Edge(1, 0, 3); edges.add(edge10);
		Edge edge13 = new Edge(1, 3, 4); edges.add(edge13);
		Edge edge23 = new Edge(2, 3, 6); edges.add(edge23);
		Edge edge30 = new Edge(3, 0, -1); edges.add(edge30);
	}

	public void printAllPaths() {
		do_BellmanFord_Algo(V, source, edges, dist_mtrx);
		int lastRow = V;
		for(int col = 0; col < V; col++) {
			System.out.println("Dist from (0, " + col + ") = " + dist_mtrx[lastRow][col]);
		}
	}

	/*	
		Do not consider initialization of dist_mtrx as iteration-1.
		Iteration starts from calculating Min value using edges.
	*/
	public void do_BellmanFord_Algo(int V, int src, List<Edge> edges, int[][] dist_mtrx) {
		for(int col = 0; col < V; col++) {
			if(col == src) {
				dist_mtrx[0][col] = 0;
			} else {
				dist_mtrx[0][col] = Integer.MAX_VALUE;
			}
		}

		// One extra iteration for checking the negative cycle.
		for(int iteration = 1; iteration <= V; iteration++) {
			for(Edge edge : edges) {
				int src_vertex = edge.src;
				int des_vertex = edge.des;

				// If the source vertex is having infinity then we don't need to proceed.
				// Else get the minimum value of (previous_value_at_vertex, current_vertex_value + edge_weight)
				if(dist_mtrx[iteration][src_vertex] != Integer.MAX_VALUE) {
					dist_mtrx[iteration][des_vertex] = Math.min(dist_mtrx[iteration - 1][des_vertex], 
																	dist_mtrx[iteration][src_vertex] + edge.wgt);
				} else {
					dist_mtrx[iteration][src_vertex] = dist_mtrx[iteration - 1][src_vertex];
				}
			}
		}
	}

}