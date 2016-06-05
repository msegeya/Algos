/**
	Question: Cycle Detection Algorithm for undirected graph. (For Directed graph please refer CycleDetectDirGraph.java)

	Reference:  https://youtu.be/n_t0a_8H8VY?t=325
				using Topological Sort, http://stackoverflow.com/questions/2739392/sample-directed-graph-and-topological-sort-code 

	NOTE: Use DFS, Topological Sort for Directed graph. Use Disjoint sets for undirected graph.

	Logic: 
	   1) Using Union and Find
	   2) Using DFS

		1) Using Union and Find: ###### UNION-FIND algorithm can be used to check whether an UNDIRECTED GRAPH (not for directed graph) has cycle or not. ######
			- Since the above question does not mention anything abt direction so we can proceed with Disjoint sets.
			=> We already know how this works. Refer DisjointSet.java for more details.
		
		2) Just like the DFS traversal except we need to store all the visited nodes in a Set.
			- For each vertex in the graph do the following,
			1) For each of its adjacent nodes check whether reached or not. If already visited then go to next node.
			2) If not visited yet then get all the connected nodes to this node and do following,
				i) If the parent of the node is adjacent node then ignore this and go to next adjacent node.
				ii) If the adjacent node is already present in the visited list then there is a cycle.
				iii) If not present then mark the adjacent's parent as current vertex node and do the above steps again for this adjacent node.
*/

import java.util.*;

class CycleDetectionUndirGraph {
	public int V;
	public int source;
	public int[][] matrix;
	public Set<Integer> visitedSet;
	public int[] parent;

	public static void main(String[] args) {
		CycleDetectionUndirGraph cdObj = new CycleDetectionUndirGraph();
		cdObj.initialize();

		cdObj.isCycle();
	}

	public void initialize() {
		V = 6;
		source = 1;
		matrix = new int[V + 1][V + 1];
		visitedSet = new HashSet<Integer>();
		parent = new int[V + 1];

		matrix[1][2] = 1; matrix[1][6] = 1; 
		matrix[2][1] = 1; matrix[2][3] = 1; 
		matrix[3][2] = 1; matrix[3][4] = 1; 
		matrix[4][3] = 1; matrix[4][5] = 1; 
		matrix[5][4] = 1; 
		matrix[6][1] = 1;

		// cycle edges
		// matrix[2][5] = 1; matrix[5][2] = 1; 

		System.out.println("Printing Matrix");
		GraphUtil.print(matrix);
	}

	public void isCycle() {
		System.out.println("\n************* Using DFS ************* ");		
		boolean isCycle = checkCycle_DFS(matrix, visitedSet, parent);
		System.out.println((isCycle == true) ? "Cycle Exists" : "Cycle does NOT exist.");

		System.out.println("\n************* Using Disjoint Sets ************* ");
		boolean isCycle_dj = usingDisjoiuntSet(matrix);
		System.out.println((isCycle_dj == true) ? "Cycle Exists" : "Cycle does NOT exist.");		
	}

	public boolean checkCycle_DFS(int[][] matrix, Set<Integer> visitedSet, int[] parent) {
		// we will start from source (1).
		for(int vertex = 1; vertex <= V; vertex++) {
			if(visitedSet.contains(vertex)) {
				continue;
			}

			// For the first node parent is null. Since it is an array we will use -1.
			parent[vertex] = -1;
			if(cycleUtilDFS(matrix, vertex, visitedSet, parent)) {
				return true;
			}
		}

		return false;
	}

	public boolean cycleUtilDFS(int[][] matrix, int vertex, Set<Integer> visitedSet, int[] parent) {
		visitedSet.add(vertex);

		for(int adj = 1; adj <= V; adj++) {
			if(matrix[vertex][adj] == 1) {
				if(adj == parent[vertex]) {
					continue;
				}

				// cycle exists condition.
				if(visitedSet.contains(adj)) {
					return true;
				}
				parent[adj] = vertex;
				boolean hasCycle = cycleUtilDFS(matrix, adj, visitedSet, parent);
				if(hasCycle) {
					return hasCycle;
				}
			}
		}

		return false;
	}

	public boolean usingDisjoiuntSet(int[][] matrix) {
		List<Edge> edges = new ArrayList<Edge>();

		Edge edge12 = new Edge(1, 2); edges.add(edge12);
		Edge edge16 = new Edge(1, 6); edges.add(edge16);

		Edge edge23 = new Edge(2, 3); edges.add(edge23);

		Edge edge34 = new Edge(3, 4); edges.add(edge34);

		Edge edge45 = new Edge(4, 5); edges.add(edge45);

		// Cycle creating Edge
		// Edge edge52 = new Edge(5, 2); edges.add(edge52);

		GraphUtil.printEdges(edges, null);

		// Prepare nodes for each vertex
		Map<Integer, DisjointNode> map = new HashMap<Integer, DisjointNode>();
		for(int vertex = 1; vertex <= V; vertex++) {
			DisjointNode node = new DisjointNode(vertex);
			map.put(vertex, node);
		}

		boolean isCycle = doUnionFind(edges, map);
		return isCycle;
	}

	public boolean doUnionFind(List<Edge> edges, Map<Integer, DisjointNode> map) {
		for(Edge edge : edges) {
			boolean setAddPass = union(edge.src, edge.des, map);
			if(!setAddPass) {
				return true;
			}
		}
		return false;
	}

	public boolean union(int src, int des, Map<Integer, DisjointNode> map) {
		DisjointNode node_one = map.get(src);
		DisjointNode node_two = map.get(des);

		DisjointNode parent_one = findParent(node_one);
		DisjointNode parent_two = findParent(node_two);

		if(parent_one.parent.data == parent_two.parent.data) {
			return false;
		}

		if(parent_one.rank >= parent_two.rank) {
			parent_one.rank = (parent_one.rank == parent_two.rank) ? parent_one.rank + 1 : parent_one.rank;
			parent_two.parent = parent_one;
		} else {
			parent_one.parent = parent_two;
		}

		return true;
	}

	public int findParent(int vertex, Map<Integer, DisjointNode> map) {
		DisjointNode node = map.get(vertex);
		DisjointNode parent = findParent(node);
		return parent.data;

	}

	public DisjointNode findParent(DisjointNode node) {
		if(node.parent == node) {
			return node;
		}

		DisjointNode parent = findParent(node.parent);
		return parent;
	}

}