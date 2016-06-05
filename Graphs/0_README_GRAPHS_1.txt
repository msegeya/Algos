Graphs Questions:(http://www.geeksforgeeks.org/data-structures/)

************************************************************************************************************

Graph and its representations
Introduction: http://www.geeksforgeeks.org/graph-and-its-representations/

************************************************************************************************************

Breadth First Traversal for a Graph       ******* IMPORTANT *******
############# BFS.java #############

************************************************************************************************************

Depth First Traversal for a Graph 		  ******* IMPORTANT *******	
############# DFS.java #############

************************************************************************************************************

Applications of DFS (http://www.geeksforgeeks.org/applications-of-depth-first-search/)

1) For an unweighted graph, DFS traversal of the graph produces 
	a) the minimum spanning tree { ############# KruskalsAlgo.java, PrimsAlgo.java ############# } ******* IMPORTANT *******
	b) all pair shortest path tree for a graph with equal weights on all edges. ******* IMPORTANT *******
				############# ShortestPathBFS.java #############
		{	
			DFS - Does not work since DFS just gives us whether there is a path between two nodes.
			BFS - Best algo for shortest path between two nodes for an UNDIRECTED graph.
		}

2) Detecting cycle in a graph.     ******* IMPORTANT *******
	A graph has cycle if and only if we see a back edge during DFS. So we can run DFS for the graph and check for back edges.
	############# CycleDetection.java #############
	NOTE: We can use the same algorithm for directed or undirected graph. The diff is present only while entering the matrix edges. Rest of teh logic is same.

3) Path Finding.    ******* IMPORTANT *******
	We can specialize the DFS algorithm to find a path between two given vertices u and z.
	i) Call DFS(G, u) with u as the start vertex.
	ii) Use a stack S to keep track of the path between the start vertex and the current vertex.
	iii) As soon as destination vertex z is encountered, return the path as the contents of the stack
	############# PathBtwTwoNodes.java #############

4) Topological Sorting  ******* IMPORTANT *******
		############# TopologicalSorting.java #############

5) To test if a graph is bipartite. 
	We can augment either BFS or DFS when we first discover a new vertex, color it opposited its parents, and for each other edge, check it doesn’t link two vertices of the same color. The first vertex in any connected component can be red or black! See this for details.
	############ Bipartite.java ############

6) Finding Strongly Connected Components of a graph. (KosaRaju's Algorithm)    ******* IMPORTANT *******
 	A directed graph is called strongly connected if there is a path from each vertex in the graph to every other vertex. (See this for DFS based algo for finding Strongly Connected Components)
	############ StronglyConnected.java ############

7) Solving puzzles with only one solution, such as mazes.    ******* IMPORTANT *******
	(DFS can be adapted to find all solutions to a maze by only including nodes on the current path in the visited set.) 
	http://www.bowdoin.edu/~ltoma/teaching/cs210/fall09/Examples/Maze.java
	############## MazeFinder.java, MazeGenerator.java, MazePos.java ############## 


8) Rat in Maze. Refer Maze finder.     ******* IMPORTANT *******
	In Maze finder we give any random cell as end but in Rat in maze we will given end cell as the last cell in the matrix.
	############## MazeFinder.java 	##############

9) N Queen Problem     ******* IMPORTANT *******
	(http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/)
	############# NQueenPro.java #############

10) Knight's Tour Problem     ******* IMPORTANT *******
	(http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/)
	############# KnightTour.java #############

************************************************************************************************************

Applications of Breadth First Traversal
http://www.geeksforgeeks.org/applications-of-breadth-first-traversal/

	1) Shortest Path and Minimum Spanning Tree for unweighted graph.
	{
		In unweighted graph, the shortest path is the path with least number of edges. With Breadth First, we always reach a vertex from given source using minimum number of edges. Also, in case of unweighted graphs, any spanning tree is Minimum Spanning Tree and we can use either Depth or Breadth first traversal for finding a spanning tree.
		############# NOT_NECESSARY #############
	}

	2) Peer to Peer Networks. In Peer to Peer Networks like BitTorrent, Breadth First Search is used to find all neighbor nodes.
		############# NOT_NECESSARY #############

	3) Crawlers in Search Engines: Crawlers build index using Bread First. The idea is to start from source page and follow all links from source and keep doing same. Depth First Traversal can also be used for crawlers, but the advantage with Breadth First Traversal is, depth or levels of built tree can be limited.
		############# NOT_NECESSARY #############

	4) Social Networking Websites: In social networks, we can find people within a given distance ‘k’ from a person using Breadth First Search till ‘k’ levels.
		############# NOT_NECESSARY #############

	5) GPS Navigation systems: Breadth First Search is used to find all neighboring locations.
		############# NOT_NECESSARY #############

	6) Broadcasting in Network: In networks, a broadcasted packet follows Breadth First Search to reach all nodes.
		############# NOT_NECESSARY #############

	7) In Garbage Collection: Breadth First Search is used in copying garbage collection using Cheney’s algorithm. Refer this and for details. Breadth First Search is preferred over Depth First Search because of better locality of reference:
		############# NOT_NECESSARY #############

	8) Cycle detection in undirected graph:     ******* IMPORTANT *******
		In undirected graphs, either Breadth First Search or Depth First Search can be used to detect cycle. 
		In directed graph, only depth first search can be used.
		############# Use Union-Find #############

	9) Ford–Fulkerson algorithm In Ford-Fulkerson algorithm, we can either use Breadth First or Depth First Traversal to find the maximum flow. Breadth First Traversal is preferred as it reduces worst case time complexity to O(VE2).
		############# FordFulkerson_MaxFlow.java #############

	10) To test if a graph is Bipartite We can either use Breadth First or Depth First Traversal.
		############# Bipartite.java #############	

	11) Path Finding We can either use Breadth First or Depth First Traversal to find if there is a path between two vertices.
	############# BFS.java ############# We can use this algorith to check whether the given nodes are reachable or not.

	12) Finding all nodes within one connected component: We can either use Breadth First or Depth First Traversal to find all nodes reachable from a given node.
	############# BFS.java ############# We can use this algorith to check whether the given nodes are reachable or not.

************************************************************************************************************

Longest Path in a Directed Acyclic Graph
http://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/

************************************************************************************************************

Snake and Ladder Problem    ******* IMPORTANT *******
http://www.geeksforgeeks.org/snake-ladder-problem-2/
 ############ SnakeAndLadder.java ############

************************************************************************************************************

Minimize Cash Flow among a given set of friends who have borrowed money from each other
http://www.geeksforgeeks.org/minimize-cash-flow-among-given-set-friends-borrowed-money/
 ############ MinCashFlow.java ############

************************************************************************************************************

Boggle (Find all possible words in a board of characters)
http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 ############ Boggle.java ############

************************************************************************************************************

Assign directions to edges so that the directed graph remains acyclic.    ******* IMPORTANT *******
http://www.geeksforgeeks.org/assign-directions-to-edges-so-that-the-directed-graph-remains-acyclic/
 ############ AcyclicGraph.java ############

************************************************************************************************************

Program to find given word exist in a matrix  of character  or not.
https://crazycoders.quora.com/PROGRAM-TO-FIND-GIVEN-WORD-EXIST-IN-A-MATRIX-OF-CHARACTER-OR-NOT
 ############ WordSearchInMtx.java ############

************************************************************************************************************

Discussion on what data structure I will use to implement recommendation engine. 
e.g. if someone buy mobile from Amazon, it should recommend the ear phones, power bank etc.
	==> We can use graph data structure to do this.
		The engine searches for the same shooping or viewing pattern by other users and recommnads what other has viewed or brought after viewing these.
		That's the reason we see "People who bought this also bought bla bla bla"

		Refer the below link for more details,
		https://kunuk.wordpress.com/2012/03/04/how-does-the-amazon-recommendation-system-work-analyze-the-algorithm-and-make-a-prototype-that-visualizes-the-algorithm/

************************************************************************************************************

Longest Skiing Problem     ******* IMPORTANT *******
Given a matrix as following, 4x4 matrix.
	4 8 7 3 
	2 5 9 3 
	6 3 2 5 
	4 4 1 6

You can start at any cell in the matrix. You can only move in 4 directions .. TOP/BOTTOM/LEFT/RIGHT depending on the grid boundaries. You can make a move to any particular cell only if the cell value is strictly less than the current cell value. 
Example consider cell [0, 0] which has 4 as current value. It can move in two ways either towards 8(RIGHT) or towards 2 (DOWN). But as per our constraint the current value should be more than the next value so we can't move RIGHT => We move down. 
Now your task is to get the longest path where you can start at any point in the grid and reach a position at the end such that the (start_cell_value - end_cell_value) is maximum.
Examples: 9 -> 5 -> 3 -> 2 -> 1 => Path length is 5. Drop Size = First_step_length - Last_Step_Length = 9 - 1 = 8
		  We have another path, 
		  8 -> 5 -> 3 -> 2 -> 1 => Path length is 5. Drop Size = 8 - 1 = 7.
		  So BEST Path is 9 -> 5 -> 3 -> 2 -> 1 with drop size = 8.
		
	################## LongestSkiing.java ######################

Refer:  https://www.careercup.com/question?id=19369681
		http://geeks.redmart.com/2015/01/07/skiing-in-singapore-a-coding-diversion/
************************************************************************************************************		