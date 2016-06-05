/**
	Question: Maze Finder.

	What is a Maze finder? 
	Given a grid of cells find all the blocks(say colored) in the given grid. 

	NOTE: This question can also be asked as like given a grid find a particular cell from starting cell in best way.

	Reference: http://www.bowdoin.edu/~ltoma/teaching/cs210/fall09/Examples/Maze.java
			   ##NOTE##: Take this only as referece. This approach has a flaw. As it goes into infinite loop. To make sure the above logic works we need to do one thing that is to mark each node that is visited as true.	
	
	Logic: Using DFS, Using BFS
		Terminalogies:
			X -> Can't go in that direction
			C -> Can go in that direction
			E -> Destination.

		Using DFS: (Stack Impl.)
		- Take a grid. Fill the grid with X, C and one E.
		- Create a class node for storing the cell and data details.
		- Push the start node that is (START_R, START_C) into stack.
		- Dequeue top of stack and explore insert NORTH, EAST, WEST and SOUTH cells only of they are valid. That is those cells which are not having data as 'X' or if the cell is already visited. Also make sure you mark every node that is inserted into the stack as true.
		- Now do the above dequeue procedure for all the nodes in the stack until the stack is empty.
		- If the stack is empty then there is no such cell or the cell is not reachable.

		Using BFS:
		- Take a grid. Fill the grid with X, C and one E.
		- Create a class node for storing the cell and data details.
		- Push start node that is (START_R, START_C) into the queue. Now remove the element from the queue and start pushing NORTH, EAST, WEST, SOUTH in to the queue.
		- Every element you push into the queue mark it as visited and store the parent of the node from which we came to this node.
		- Now do the same procedure for all the queue elements.
		- Do this until queue is empty.
		- If the destination is reached then print the path from source to destiantion using parent node starting from destination.
*/

import java.util.*;

class MazeFinder {
	private static char[][] maze = {
										{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
										{'X', 'S', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'X'},
										{'X', 'C', 'C', 'C', 'X', 'C', 'X', 'X', 'C', 'E'},
										{'X', 'C', 'X', 'X', 'X', 'C', 'X', 'X', 'C', 'X'}, 
										{'X', 'C', 'C', 'C', 'C', 'X', 'X', 'X', 'C', 'X'},
										{'X', 'X', 'X', 'X', 'C', 'X', 'X', 'X', 'C', 'X'},
										{'X', 'X', 'X', 'X', 'C', 'X', 'C', 'C', 'C', 'X'},
										{'X', 'X', 'C', 'X', 'C', 'X', 'X', 'C', 'C', 'X'}, 
										{'X', 'X', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'X'},  
										{'X', 'X', 'X', 'X', 'X', 'X', 'C', 'X', 'X', 'X'}
								    };
	private int HEIGHT, WIDTH;
	
	// We need to reach from (1, 1) to (2, 9)
	public final static int START_R = 1;
	public final static int START_C = 1;
	public final static int END_R = 2;
	public final static int END_C = 9;

	public static void main(String[] args) {
		MazeFinder mfObj = new MazeFinder();
		mfObj.initialize();

		mfObj.usingDFS();

		mfObj.usingBFS();
	}

	public void initialize() {
		HEIGHT = maze.length;
		WIDTH = maze[0].length;
	}

	public void usingDFS() {
		System.out.println("************** USING DFS ****************");
		boolean result = doDFS();

		if(result) {
			System.out.println("You reached destination.");
		} else {
			System.out.println("You where stuck in the maze grid.");
		}
	}

	public void usingBFS() {
		System.out.println("\n************** USING BFS ****************");
		boolean result = doBFS();

		if(result) {
			System.out.println("You reached destination.");
		} else {
			System.out.println("You where stuck in the maze grid.");
		}
	}

	public boolean doDFS() {
		MazePos[][] dfs_maze = make_copy();

		Stack<MazePos> stack = new Stack<MazePos>();
		stack.push(new MazePos(START_R, START_C, maze[START_R][START_C]));

		while(!stack.isEmpty()) {
			MazePos current = stack.pop();
			System.out.println("Searching for cell (" + current.r + ", " + current.c + ")");

			if(isFinal(current)) {
				return true;
			}

			MazePos next = north(current, dfs_maze);
			if(null != next && isClear(next, dfs_maze) && !next.visited) {
				next.visited = true;
				stack.push(next);
			}

			next = east(current, dfs_maze);
			if(null != next && isClear(next, dfs_maze)  && !next.visited) {
				next.visited = true;
				stack.push(next);
			}

			next = west(current, dfs_maze);
			if(null != next && isClear(next, dfs_maze)  && !next.visited) {
				next.visited = true;
				stack.push(next);
			}

			next = south(current, dfs_maze);
			if(null != next && isClear(next, dfs_maze)  && !next.visited) {
				next.visited = true;
				stack.push(next);
			}
		}

		if(!stack.isEmpty()) {
			return true;
		}

		return false;
	}

	public boolean doBFS() {
		Queue<MazePos> queue = new LinkedList<MazePos>();
		MazePos[][] bfs_maze = make_copy();

		queue.add(new MazePos(START_R, START_C, maze[START_R][START_C]));

		while(!queue.isEmpty()) {
			MazePos current = queue.remove();
			// System.out.println("Searching for cell (" + current.r + ", " + current.c + ")");

			if(isFinal(current)) {
				System.out.println("***** Path from source to destination is: *****");
				MazePos findParent = current;
				while(null != findParent) {
					System.out.println("(" + findParent.r + ", " + findParent.c + ")");
					findParent = findParent.parent;
				}

				return true;
			}

			MazePos next = north(current, bfs_maze);
			if(null != next && isClear(next, bfs_maze) && !next.visited) {
				next.visited = true;
				next.parent = current;
				queue.add(next);
			}

			next = east(current, bfs_maze);
			if(null != next && isClear(next, bfs_maze) && !next.visited) {
				next.visited = true;
				next.parent = current;
				queue.add(next);
			}			

			next = west(current, bfs_maze);			
			if(null != next && isClear(next, bfs_maze) && !next.visited) {
				next.visited = true;
				next.parent = current;
				queue.add(next);
			}

			next = south(current, bfs_maze);
			if(null != next && isClear(next, bfs_maze) && !next.visited) {
				next.visited = true;
				next.parent = current;
				queue.add(next);
			}
		}

		if(!queue.isEmpty()) {
			return true;
		}

		return false;

	}

	public boolean isInMaze(MazePos next) {
		return isInMaze(next.r, next.c);
	}

	public boolean isInMaze(int r, int c) {
		if(r < HEIGHT - 1 &&  r >= 0 && c < WIDTH - 1 && c >= 0) {
			return true;
		}

		return false;
	}

	public boolean isClear(MazePos next, MazePos[][] dfs_maze) {
		return isClear(next.r, next.c, dfs_maze);
	}

	public boolean isClear(int r, int c, MazePos[][] dfs_maze) {
		if(dfs_maze[r][c].data != 'X' && dfs_maze[r][c].data != 'V') {
			return true;
		}

		return false;
	}

	public boolean isFinal(MazePos mazePos) {
		if(mazePos.r == END_R && mazePos.c == END_C) {
			return true;
		}

		return false;
	}


	public MazePos[][] make_copy() {
		MazePos[][] copy_maze = new MazePos[HEIGHT][WIDTH];
		for(int r = 0; r < HEIGHT; r++) {
			for (int c = 0; c < WIDTH; c++) {
				copy_maze[r][c] = new MazePos(r, c, maze[r][c]);
			}
		}

		return copy_maze;
	}

	public void print(int[][] matrix) {
		for(int r = 0; r < HEIGHT; r++) {
			for(int c = 0; c < WIDTH; c++) {
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	public MazePos north(MazePos current, MazePos[][] dfs_maze) {
		int r = current.r;
		int c = current.c;
		if(isInMaze(r, c)) {
			return dfs_maze[r - 1][c];
		}
		
		return null;
	}
	
	public MazePos south(MazePos current, MazePos[][] dfs_maze) {
		int r = current.r;
		int c = current.c;
		if(isInMaze(r, c)) {
			return dfs_maze[r + 1][c];
		}
		
		return null;
	}
	
	public MazePos east(MazePos current, MazePos[][] dfs_maze) {
		int r = current.r;
		int c = current.c;
		if(isInMaze(r, c)) {
			return dfs_maze[r][c + 1];
		}
		return null;
	}
	
	public MazePos west(MazePos current, MazePos[][] dfs_maze) {
		int r = current.r;
		int c = current.c;
		if(isInMaze(r, c)) {
			return dfs_maze[r][c - 1];
		}
		return null;
	}
}