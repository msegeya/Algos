/**
	Question: Boggle. Given a matrix of random characters. Find all the words that can be formed usign these characters. Note every character in a the output word should be adjacent to each other in any direction. 

	NOTE: Check similar kind of question @ https://crazycoders.quora.com/PROGRAM-TO-FIND-GIVEN-WORD-EXIST-IN-A-MATRIX-OF-CHARACTER-OR-NOT
		  For Java code check WordSearchInMtx.java

	Reference: http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
			   http://stackoverflow.com/questions/746082/how-to-find-list-of-possible-words-from-a-letter-matrix-boggle-solver/746102#746102

	Logic: (VERY TOUGH. We have to use both backtracking and DFS. Solution is easy but thought process is difficult.)
		- Just like the way we have done N-Queen and Knight Tour problem we do the same here. Start from a node and check a possibility if that leads to a solution then add it to the solution list.
		- Start at a particular cell and mark it as visited and check it the cell can form a word or not.
		- Do all word formations using util function.
		- If you encounter any word that is present in the dictionary then print it and proceed furthur.
		- Don't forget to make the cell false after completing the loop. Since we need to use the same cell for other words also.

*/

import java.util.*;

class Boggle {

	public char[][] boggle;
	public Set<String> dict;
	public boolean[][] visited;
	public int N;
	List<String> output = new ArrayList<String>();

	int[] xMove = {-1, -1, -1,  0,  1, 1, 1, 0};
	int[] yMove = { 1,  0, -1, -1, -1, 0, 1, 1};
	
	public static void main(String[] args) {
		Boggle bObj = new Boggle();
		bObj.initialize();
		bObj.solveBoggle();
	}

	public void initialize() {
		dict = new HashSet<String>();
		dict.add("GEEKS");
		dict.add("FOR");
		dict.add("QUIZ");
		dict.add("GO");

		N = 3;
		boggle = new char[N][N];
		boggle[0][0] = 'G'; boggle[0][1] = 'I'; boggle[0][2] = 'Z'; 
		boggle[1][0] = 'U'; boggle[1][1] = 'E'; boggle[1][2] = 'K'; 
		boggle[2][0] = 'Q'; boggle[2][1] = 'S'; boggle[2][2] = 'E'; 
		visited = new boolean[N][N];
	}

	public void solveBoggle() {
		int m = boggle.length;
		int n = boggle[0].length;
		for(int r = 0; r < m; r++) {
			for(int c = 0; c < n; c++) {
				String word = "";
				doDFSBacktracking(r, c, boggle, visited, dict, word, m, n);
			}
		}

		if(output.size() == 0) {
			System.out.println("No words present");	
		} else {
			System.out.println("Following are the words that can be formed using the input characters.");
			for(String str : output) {
				System.out.println(str);
			}			
		}
	}

	public void doDFSBacktracking(int r, int c, char[][] boggle, boolean[][] visited, Set<String> dict, String word, int m, int n) {
		
		if(r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
			return;
		}
		
		visited[r][c] = true;
		
		word = word + boggle[r][c];
		if(dict.contains(word)) {
			output.add(word + "");
		}

		for(int k = 0; k < 8; k++) {
			doDFSBacktracking(r + xMove[k], c + yMove[k], boggle, visited, dict, word, m, n);
		}
		
		// Just like the way we have done in N-Queen and Knight-tour problems using backtracking, 
		// if the end cell does not lead to result then make the visited as false.
		visited[r][c] = false;
	}

}