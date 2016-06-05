/**
	Question: Disjoint sets using Find, Union and Rank.

	NOTE: UNION-FIND algorithm can be used to check whether an UNDIRECTED GRAPH (not for directed graph) has cycle or not.

	Reference: https://www.youtube.com/watch?v=ID00PMy0-vE
				https://github.com/mission-peace/interview/blob/5dda4bd22376f2a3d3be42e9eb6a9ac54b6c810a/src/com/interview/graph/DisjointSet.java

	Logic:
		- See the above video for explanation.
		- See code comments for each method below.
*/

import java.util.*;

public class DisjointSet {

	public Map<Integer, DisjointNode> map;

	public static void main(String[] args) {
		DisjointSet djsObj = new DisjointSet();
		djsObj.initialize();
	}

	public void initialize() {
		map = new HashMap<Integer, DisjointNode>();

		for(int i = 1; i <= 7; i++) {
			make_set(i);	
		}
		
		// First we will print the parent nodes of all the nodes using find.
		System.out.println("***** Find Parent for each Node is *****");
		for(int i = 1; i <= 7; i++) {
			System.out.println("Parent of node " + i + " is " + findParent(i));
		}

		System.out.println("After each union operation");
		// Now we will get to Union of two nodes i,e edge.
		union(1, 2);
		System.out.println("After Union(1, 2) Parent of 1 and 2 are: " + findParent(1) + " and " + findParent(2));

		union(2, 3);
		System.out.println("After Union(2, 3) Parent of 2 and 3 are: " + findParent(2) + " and " + findParent(3));

		union(4, 5);
		System.out.println("After Union(4, 5) Parent of 4 and 5 are: " + findParent(4) + " and " + findParent(5));

		union(6, 7);
		System.out.println("After Union(6, 7) Parent of 6 and 7 are: " + findParent(6) + " and " + findParent(7));

		union(5, 6);
		System.out.println("After Union(5, 6) Parent of 5 and 6 are: " + findParent(5) + " and " + findParent(6));

		union(3, 7);
		System.out.println("After Union(3, 7) Parent of 3 and 7 are: " + findParent(3) + " and " + findParent(7));

	}

	public void make_set(int data) {
		DisjointNode newNode = new DisjointNode();
		newNode.data = data;
		newNode.parent = newNode;
		newNode.rank = 0;

		// key as element and value as Node.
		map.put(data, newNode);
	}

	/*
		If two nodes have the same parent then they are in the same set.
		If not same then, check whether who is having more.
		If parent_one is >= parent_two then incremenet rank of parent_one and make parent_two's parent as parent_one.
		else parent_one's parent as parent_two.
	*/
	public void union(int data_one, int data_two) {
		DisjointNode node_one = map.get(data_one);
		DisjointNode node_two = map.get(data_two);

		DisjointNode parent_one = findParent(node_one);
		DisjointNode parent_two = findParent(node_two);

		// If both the parents are same then they are in the same set.
		// So just return.
		if(parent_one.data == parent_two.data) {
			return;
		}

		// If they are not same then check which node has the highest rank.
		// The one with the highest rank will be the parent for the other node.
		if(parent_one.rank >= parent_two.rank) {
			// first we will update the rank of parent_one. 
			// If both have same rank then increment parent_one rank else don't change parent_one rank.
			parent_one.rank = (parent_one.rank == parent_two.rank) ? parent_one.rank + 1 : parent_one.rank;
			parent_two.parent = parent_one;
		} else {
			parent_one.parent = parent_two;
		}

	}

	/*
		Find parent is nothing but to find the parent of the given node. 
		Now given a data, First we will get the node using map.
		Then we will get the parent of this node.
	*/
	public int findParent(int element) {
		DisjointNode findNode = map.get(element);
		DisjointNode resultNode = findParent(findNode);
		return resultNode.data;
	}

	/*
		Logic is: For every given node check whether it is parent to itself or not.
		If YES, then return the node.
		If NO, then recursively call findParent now passing node.parent.
	*/
	public DisjointNode findParent(DisjointNode node) {
		if(node.parent == node) {
			return node;
		}

		DisjointNode parent = node.parent;
		return findParent(parent);
	}

}
