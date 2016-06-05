/**
	Question: Kruskals Algorithm. Find minimum spanning tree.
	Example: By using minimum value if edges we should cover all the vertices.

	Reference: https://www.youtube.com/watch?v=fAuF0EuZVCk
			   https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/KruskalMST.java

	Applications: http://stackoverflow.com/questions/7320465/applications-of-kruskal-and-prims-algorithms

	Logic: 
		- Before going furthur first learn about disjoint sets. We need union and find operations here.
		- Now to Kruskals algorithm.
		- Sort all the edges in increasing order of edge weight.
		- Now, take each edge do two steps,
			1) Using findParent get the parent of the node.
			2) Using Union merge them into a single set only if the set parents are different.
		- Which ever edges are included make sure to save them. We need them to calculate total minimum weight as well as minimum path.
*/

import java.util.*;

class KruskalsAlgo {

	public List<Edge> edges;
	public int source;
	public Map<Integer, DisjointNode> map;

	public static void main(String[] args) {
		KruskalsAlgo kaObj = new KruskalsAlgo();
		kaObj.initialize();
		kaObj.printMinSpanPath();
	}

	public void initialize() {
		map = new HashMap<Integer, DisjointNode>();
		edges = new ArrayList<Edge>();
		source = 1;

		for(int i = 1; i <= 6; i++) {
			DisjointNode newNode = new DisjointNode(i);
			map.put(i, newNode);
		}

		System.out.println("***** Finding Parent for each Node is *****");
		for(int i = 1; i <= 6; i++) {
			System.out.println("Parent of node " + i + " is " + findParent(i));
		}

		// Now we are moving to edges.	
		Edge edge1 = new Edge(1, 4, 1); edges.add(edge1);
		Edge edge2 = new Edge(1, 2, 3); edges.add(edge2);
		Edge edge3 = new Edge(2, 3, 1); edges.add(edge3);
		Edge edge9 = new Edge(2, 4, 3); edges.add(edge9);
		Edge edge4 = new Edge(3, 4, 1); edges.add(edge4);
		Edge edge5 = new Edge(3, 6, 4); edges.add(edge5);
		Edge edge6 = new Edge(3, 5, 5); edges.add(edge6);
		Edge edge7 = new Edge(4, 5, 6);	edges.add(edge7);
		Edge edge8 = new Edge(5, 6, 2); edges.add(edge8);

		GraphUtil.printEdges(edges, null);
	}

	public void printMinSpanPath() {
		Map<String, Object> output = doKruskal(edges, source);
		GraphUtil.printEdges((List<Edge>) output.get("VALID"), "Valid Edges are: ");
		GraphUtil.printEdges((List<Edge>) output.get("NOT_VALID"), "Not Valid Edges are: ");
		System.out.println("Minimum cost is: " + (Integer) output.get("COST"));
	}

	public Map<String, Object> doKruskal(List<Edge> edges, int source) {
		List<Edge> exclEdgeList = new ArrayList<Edge>();
		List<Edge> inclEdgeList = new ArrayList<Edge>();
		int cost = 0;

		EdgeComparator edgeComp = new EdgeComparator();
		Collections.sort(edges, edgeComp);

		GraphUtil.printEdges(edges, "Edges after sorting: ");

		for(int i = 0; i < edges.size(); i++) {
			Edge tempEdge = edges.get(i);
			int vertex_one = tempEdge.src;
			int vertex_two = tempEdge.des;
			boolean isValid = union(vertex_one, vertex_two);
			if(isValid) {
				inclEdgeList.add(tempEdge);
				cost = cost + tempEdge.wgt;
			} else {
				exclEdgeList.add(tempEdge);
			}
		}

		Map<String, Object> output = new HashMap<String, Object>();
		output.put("VALID", inclEdgeList);
		output.put("NOT_VALID", exclEdgeList);
		output.put("COST", cost);

		return output;
	}

	/*	
		Steps: 
		1. Get the Node for this vertex from map.
		2. From Node get the parent of each node.
		3. For each Node get the parent.
		4. If parents are equal then they are in the same set.
		5. If parents are not equal then increment the rank of the parent which has the >= rank among the sets and make the parent as the parent of the lower rank set.
	*/
	public boolean union(int vertex_one, int vertex_two) {
		DisjointNode node_one = map.get(vertex_one);
		DisjointNode node_two = map.get(vertex_two);

		DisjointNode parent_one = findParent(node_one);
		DisjointNode parent_two = findParent(node_two);

		if(parent_one.data == parent_two.data) {
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

	// We already have find and Union but here we will try to implement them for practice.
	public int findParent(int data) {
		DisjointNode node = map.get(data);
		DisjointNode parent = findParent(node);
		return parent.data;
	}

	public DisjointNode findParent(DisjointNode node) {
		if(node.parent == node) {
			return node;
		}

		DisjointNode parent = node.parent;
		return findParent(parent);
	}

}