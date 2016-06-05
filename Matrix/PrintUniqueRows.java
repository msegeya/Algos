/**
	Question: Print unique rows in a given boolean matrix. 

	Reference: http://www.geeksforgeeks.org/print-unique-rows/

	Example:  Input:	
				{0, 1, 0, 0, 1}
        		{1, 0, 1, 1, 0}
        		{0, 1, 0, 0, 1}
        		{1, 1, 1, 0, 0}

			  Output: 
			  	{0, 1, 0, 0, 1}
			  	{1, 0, 1, 1, 0}
				{1, 1, 1, 0, 0}			  	

	Logic: (Using Trie Data Structure) 
		- Consider each row as a String where each cell is a character in that row.
		- Construct Trie using all these rows(string).
		- A row (string) that is repeated can be easily figured out using Trie so don't print them.
*/

import java.util.*;

class PrintUniqueRows {
	public static void main(String[] args) {
		int[][] grid = {
							{0, 1, 0, 0, 1},
							{1, 0, 1, 1, 0},
							{0, 1, 0, 0, 1},
        					{1, 1, 1, 0, 0}							
					   };

		printUniqueRows(grid);			   
	}

	public static void printUniqueRows(int[][] grid) {
		TrieMatrixNode root = new TrieMatrixNode(' ');

		// Each row is a string so we will pass the row and try to create a string in the trie if it does not exist.
		for(int i = 0; i < grid.length; i++) {
			if(insert(root, grid[i])) {
				MatrixUtil.print(grid[i], "Row = " + i);
			}
		}
	}

	public static boolean insert(TrieMatrixNode root, int[] row) {
		TrieMatrixNode current = root;

		int col = 0;
		for(col = 0; col < row.length; col++) {
			int key = row[col];
			if(null == current.link.get(key)) {
				TrieMatrixNode newNode = new TrieMatrixNode(key);
				current.link.put(key, newNode);
				current = newNode;
			} else {
				current = current.link.get(key);
			}
		}

		// If the string already exists then return false. 
		if(true == current.isEnd && col == row.length) {
			return false;
		} 

		// If it is the new string then mark it as end of the string.
		current.isEnd = true;
		return true;
	}
}

class TrieMatrixNode {
	public Integer ch;
	public Map<Integer, TrieMatrixNode> link;
	public boolean isEnd;

	public TrieMatrixNode(int ch) {
		this.ch = ch;
		link = new HashMap<Integer, TrieMatrixNode>();
		isEnd = false;
	}
}