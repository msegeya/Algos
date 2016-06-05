/**
	Question: Maze Generator using DFS

	What is a Maze Generator?
	Given a grid of empty cells. You need to block some of the cells randomly. Such that when you apply maze finder on to this maze then it has to reach every cell which is blocked.

	Reference: http://www.migapro.com/depth-first-search/
			   http://algs4.cs.princeton.edu/41graph/Maze.java

	Logic: 
		- We will use custom DFS with a litte change.
		- Take a Grid of ROW x COL as 4 x 4.
		- Initialize entire Grid with 1's. That means all the cells are empty.
		- We will use 0 for blocking the cell. ==> 1 means empty, 0 means blocked.
		- Start at cell (0, 0). Now it has 4 ways to move UP, DOWN, RIGHT, LEFT.
		- Choose randomly one path and see whether we can block atleast 2 cells in that direction.
		- Similarly do this recursively for all the possible cells.
*/

import java.util.*;

class MazeGenerator {

	private int[][] maze;
	private int HEIGHT;
	private int WIDTH;

	public static void main(String[] args) {
		MazeGenerator mgObj = new MazeGenerator();
		mgObj.initialize();
		mgObj.mazeGenerator();
	}

	public void initialize() {
		HEIGHT = 4;
		WIDTH = 4;

		maze = new int[HEIGHT][WIDTH];

		for(int r = 0; r < HEIGHT; r++) {
			for(int c = 0; c < WIDTH; c++) {
				maze[r][c] = 1;
			}
		}

		print(maze, "Maze Initialization.");
	}

	public void mazeGenerator() {
		Random rand = new Random();
		int r = rand.nextInt(HEIGHT);
		while(r % 2 == 0) {
			r = rand.nextInt(HEIGHT);
		}

		int c = rand.nextInt(WIDTH);
		while(c % 2 == 0) {
			c = rand.nextInt(WIDTH);
		}

		// mark the cell (r, c) with 0.
		maze[r][c] = 0;

		doRecursively(r, c);

		System.out.println();
		print(maze, "After applying Maze generator. ");
	}


	/*
		How long does this logic run. This logic runs as long as all the four conditions below are broked that means there will be no furthur recursive calls.
	*/
	public void doRecursively(int row, int col) {
		int[] randomDirs = genRandomDir();
		System.out.println("\nRandom Numbers.");
		for(int i = 0; i < randomDirs.length; i++) {
			System.out.print(randomDirs[i] + "\t");
		}

		for(int i = 0; i < randomDirs.length; i++) {
			switch(randomDirs[i]) {
				case 1: // UP
					if(row - 2 <= 0){
						continue;
					}

					if(maze[row - 2][col] != 0) {
						maze[row - 2][col] = 0;
						maze[row - 1][col] = 0;
						doRecursively(row - 2, col);
					}
					break;

				case 2: // RIGHT
					if(col + 2 >= WIDTH - 1) {
						continue;
					}

					if(maze[row][col + 2] != 0) {
						maze[row][col + 2] = 0;
						maze[row][col + 1] = 0;
						doRecursively(row, col + 2);
					}
					break;

				case 3: // DOWN
					if(row + 2 >= HEIGHT - 1) {
						continue;
					}	

					if(maze[row + 2][col] != 0) {
						maze[row + 2][col] = 0;
						maze[row + 2][col] = 0;
						doRecursively(row + 2, col);
					}
					break;

				case 4: // LEFT
					if(col - 2 <= 0) {
						continue;
					}

					if(maze[row][col - 2] != 0) {
						maze[row][col - 2] = 0;
						maze[row][col - 1] = 0;
						doRecursively(row, col - 2);
					}
					break;
			}
		}
	}

	/*
		Collection.shuffle will just shuffle the contents of the list.
	*/
	public int[] genRandomDir() {
		List<Integer> randoms = new ArrayList<Integer>();
		int[] output = null;

		for(int i = 0; i < HEIGHT; i++) {
			randoms.add(i + 1);
		}	

		Collections.shuffle(randoms);
		output = new int[randoms.size()];

		for(int i = 0; i < randoms.size(); i++) {
			output[i] = randoms.get(i);
		}
		return output;
	}

	public void print(int[][] matrix, String msg) {
		System.out.println(msg);
		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c] + "\t");
			}
			System.out.println();
		}
	}
}
