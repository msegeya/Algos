/**
	Question: Snake and Ladder problem. Get minimum moves to reach from 1 to 30. (Best is 3 moves.)
			  Look at the image Snakes_Ladder.jpg (in the same folder)

	NOTE: You don't know where are snakes and ladders in the board. We just need to throw a dice and move accordingly.

	Reference:  https://www.youtube.com/watch?v=19tY6Y90TP0
				https://www.dropbox.com/s/tywm6s06pw4503f/SnakeAndLadder.txt?dl=0
				http://www.geeksforgeeks.org/snake-ladder-problem-2/

	Explanation: 
		- You will have a board[30]. Board has numbers from 1 .. 30 as shown below.

							25	26	27	28	29	30
							24	23	22	21	20	19
							13	14	15	16	17	18
							12	11	10	9	8	7
							1	2	3	4	5	6

			Snakes are present at 27, 21, 17, 19 => board[27] = 1 => when you get down at 27th cell you will be moved to cell 1. 
			Array index starting from 0
				=> board[26] = 1; board[20] = 9; board[18] = 7; board[16] = 4; 
			Similarly we have LADDERS at 3, 5, 11, 20. So when we land at any of these places we can jump to the value index in the board.
				=> board[2] = 22; board[4] = 8; board[10] = 26; board[19] = 29; 

	Logic: (Very Easy. If you understand maze finder problem then this is same as that. It means RAT is at "0" and we need to reach postion "30". We can just look the board diagonally and consider it as a graph. So to find the shortest path between two vertices for an unweighted graph is done using "BFS".

*/

import java.util.*;

class SnakeAndLadder {

	public int[] board;
	public Set<Integer> visited;
	public int N;
	public int[] parent;

	public static void main(String[] args) {
		SnakeAndLadder slObj = new SnakeAndLadder();
		slObj.initialize();
		slObj.solveSnakeNLadder();
	}

	public void initialize() {
		N = 30;
		board = new int[N];
		visited = new HashSet<Integer>();
		parent = new int[N];
		
		// snake
		board[26] = 1; board[20] = 9; board[18] = 7; board[16] = 4; 
		
		// ladder
		board[2] = 22; board[4] = 8; board[10] = 26; board[19] = 29;  
	}

	public void solveSnakeNLadder() {
		int start = 0;
		int output = doBFS(start, visited, board, parent);
		if(output != -1) {
			System.out.println("\nShortest distance from 0 to " + (N - 1) + " is: " + output);
		} else {
			System.out.println("No path present.");
		}
	}

	public int doBFS(int start, Set<Integer> visited, int[] board, int[] parent) {
		Queue<SnakeNLadderNode> queue = new LinkedList<SnakeNLadderNode>();
		
		SnakeNLadderNode node = new SnakeNLadderNode();
		node.dist = 0;
		node.vertex = start;
		queue.add(node);
		
		visited.add(start);

		// parent of first node is null.
		parent[start] = -1;

		while(!queue.isEmpty()) {
			SnakeNLadderNode popNode = queue.remove();
			int nodeEle = popNode.vertex;
			
			if(nodeEle == (N - 1)) {
				System.out.print("Best path is: ");
				int path = parent[N - 1];
				while(path != -1) {
					System.out.print(path + " -> ");
					path = parent[path];
				}
				return popNode.dist;
			}
			
			// A dice's min range is 1 and max range is 6.
			// So from the current node value we need to check (current_node + 1) to (current_node + 6)
			for(int index = (nodeEle + 1); index <= (nodeEle + 6) && index < N; index++) {
				if(visited.contains(index)) {
					continue;
				}

				SnakeNLadderNode newNode = new SnakeNLadderNode();
				newNode.dist = popNode.dist + 1;
				
				visited.add(index);
				
				if(board[index] != 0) {
					newNode.vertex = board[index];
				} else {
					newNode.vertex = index;
				}
				parent[index] = nodeEle;
				queue.add(newNode);
			}
		}

		return -1;
	}
}