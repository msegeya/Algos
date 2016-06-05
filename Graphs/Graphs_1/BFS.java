/**
	Question: Breadth First Search

	Reference: http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
				http://www.sanfoundry.com/java-program-traverse-graph-using-bfs/

	Applications:
		Following are the applications. All the below one's are easy and follows BFS algorithm approach.
		#) Shortest path in in a graph.
		#) Peer to Peer networks to find the nearest neighbours. Ex. Bit torrent
		#) Crawlers in search engine. To get the source page and look for all the closely related pages.
		#) Social Networking websites for nearest friends.
		#) Bipartite graph.

	Logic:
		- Push source in to the Queue and mark visited as True.
		- Poll the first element and start looking for all the links fo this node and push them all into the queue.
		- Continue polling and start pushing them into the queue if there are any unvisited nodes.
		- Whenever you are adding into the queue mark it as visited and print it.
*/

import java.util.*;		

class BFS {

	public int[][] graph;
	public int V;
	public boolean[] visited;
	public int source;

	public static void main(String[] args) {
		BFS bfsObj = new BFS();
		bfsObj.initialize();
		bfsObj.printBFS();
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

	public void printBFS() {
		doBFS(V, graph, source, visited);
	}

	public void doBFS(int total, int[][] matrix, int source, boolean[] visited) {
		System.out.println("BFS visited order is: ");

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);

		while(!queue.isEmpty()) {
			int element = queue.poll();
			visited[element] = true;
			System.out.print(element + "\t");

			int index = 1;
			while(index <= total) {
				if(matrix[element][index] == 1 && !visited[index]) {
					queue.add(index);
				}

				index++;
			}
		}

	}

}