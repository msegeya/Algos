/**
	Question: Cycle Detection Algorithm for directed graph. (For Undirected graph please refer CycleDetection.java)
	
	Reference:  https://www.youtube.com/watch?v=rKQaZuoUR4M - It's a good video but we will follow geeks for geeks logic and do the task.
				http://www.geeksforgeeks.org/detect-cycle-in-a-graph/

	Logic: Using DFS and Using Topological Sort.
	
		Using DFS: A bit tricky.
			- For every vertex we need to do the following do DFS in the following way.
				#) Add it to the visited set and since it will be part of the recursion we will add it to recursive_set also.
				#) For each adjacent vertices, if the adjacent vertex is not visited then call DFS using this adjacent vertex.
				#) If any vertex is alread visited and is also part of the recursive_set then the current vertex is visiting the vertex which is already visited 
					==> there is a cycle.
				#) Else remove the stack from the recursive_set. Since for next vertex calls we need to remvoe the current vertex from the recursive_set.	
*/

import java.util.*;

class CycleDetectDirGraph {

	public int V;
	public Set<Integer> visited;
	public Set<Integer> vertices_in_recursion;
	public List<Edge> edges;

	public static void main(String[] args) {
		CycleDetectDirGraph cddgObj = new CycleDetectDirGraph();
		cddgObj.initialize();
		cddgObj.isCycle();
	}

	public void initialize() {
		V = 4;
		visited = new HashSet<Integer>();
		vertices_in_recursion = new HashSet<Integer>();
		edges = new ArrayList<Edge>();

		Edge edge01 = new Edge(0, 1); edges.add(edge01); 
		Edge edge02 = new Edge(0, 2); edges.add(edge02); 

		Edge edge12 = new Edge(1, 2); edges.add(edge12); 

		// cycle vertices
		Edge edge20 = new Edge(2, 0); edges.add(edge20); 
		Edge edge23 = new Edge(2, 3); edges.add(edge23); 

		// cycle vertices
		Edge edge33 = new Edge(3, 3); edges.add(edge33); 
	}

	public void isCycle() {
		if(solCycleDet()) {
			System.out.println("Cycle Exists in Directed Graph.");
		} else {
			System.out.println("Cycle DOESN'T Exists in Directed Graph.");
		}
	}

	public boolean solCycleDet() {
		visited = new HashSet<Integer>();
		vertices_in_recursion = new HashSet<Integer>();

		for(int vertex = 0; vertex < V; vertex++) {
			// if cycle present then return true.
			if(doDFS(vertex, edges, visited, vertices_in_recursion)) {
				return true;
			}
		}
		return false;
	}

	public boolean doDFS(int vertex, List<Edge> edges, Set<Integer> visited, Set<Integer> vertices_in_recursion) {

		if(!visited.contains(vertex)) {
			visited.add(vertex);
			vertices_in_recursion.add(vertex);

			for(Edge edge : edges) {
				if(edge.src != vertex) {
					continue;
				}

				int adj = edge.des;
				if(!visited.contains(adj)) {
					// make a recursive call with the adjacent vertex.
					boolean isCycle = doDFS(adj, edges, visited, vertices_in_recursion);
					if(isCycle) {
						return true;
					}
				} else {
					// If already visited node is been visited again then there is a cycle.
					if(vertices_in_recursion.contains(adj)) {
						return true;
					}
				}
			}
		}

		// this vertex is already visited so we can ignore this one.
		// remove this out of the recursion.
		vertices_in_recursion.remove(vertex);
		
		return false;
	}

}