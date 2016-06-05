/**
	Question: Print unique rows in a given matrix.

	Reference: http://www.geeksforgeeks.org/print-unique-rows/

	Logic: 
		- Consider each row as a string (word).
		- Now insert each word in a Trie. If the row(word) there then ignore it else print it.
*/

class PrintUniqueRows {

	private TrieNode root;

	int[][] matrix = new int[4][5];
	int ROWS = 4;
	int COLS = 5;

	public static void main(String[] args) {
		PrintUniqueRows purObj = new PrintUniqueRows();
		purObj.initialize();
		purObj.checkUnique();
	}

	public void initialize() {
	 	matrix[0][0] = 0; matrix[0][1] = 1; matrix[0][2] = 0; matrix[0][3] = 0; matrix[0][4] = 1; 
	 	matrix[1][0] = 1; matrix[1][1] = 0; matrix[1][2] = 1; matrix[1][3] = 1; matrix[1][4] = 0; 
	 	matrix[2][0] = 0; matrix[2][1] = 1; matrix[2][2] = 0; matrix[2][3] = 0; matrix[2][4] = 1; 
	 	matrix[3][0] = 1; matrix[3][1] = 1; matrix[3][2] = 1; matrix[3][3] = 0; matrix[3][4] = 0;

	 	print(matrix); 
	}

	public void print(int[][] matrix) {
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public void checkUnique() {
		for(int row = 0; row < ROWS; row++) {
			insert(matrix[row]);
		}
	}

	public void insert(int[] input) {
		System.out.println("\nINSERTING ***** ");
		TrieNode current = root;

		for(int col = 0; col < COLS; col++) {
			char ch = Character.forDigit(input[col], 10);
			
			if(null == root) {
				root = Trie.createRoot();
				current = root;
			}

			if(null == current.childMap.get(ch)) {
				TrieNode newNode = new TrieNode(ch);
				current.childMap.put(ch, newNode);
				current.numOfChilds = current.numOfChilds + 1;
				current = newNode;
			} else {
				current = current.childMap.get(ch);
			}
		}

		if(!current.isWord) {
			current.isWord = true;
			print(input);
			System.out.println("Inserted word");
		} else {
			print(input);
			System.out.println("Word already exists.");
			return;
		}
	}

	public void print(int[] input) {
		for(int c = 0; c < COLS; c++) {
			System.out.print(input[c] + "\t");
		}
	}

}