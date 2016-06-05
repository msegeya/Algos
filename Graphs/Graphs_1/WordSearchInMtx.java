/**
	Question: Program to find given word exist in a matrix  of character  or not. We are given matrix of character as 
		      { {ACPRC}, {XSOPC}, {VOVNI}, {WGFMN}, {QATIT} }
			  suppose we need to find words like "CAT" and "MICROSOFT" in a matrix then it should print yes else in other case no.

	Reference: https://crazycoders.quora.com/PROGRAM-TO-FIND-GIVEN-WORD-EXIST-IN-A-MATRIX-OF-CHARACTER-OR-NOT

	Logic:
		- Use the given input characters and make create a 2D array to store the characters row by row.
		- Create a array say "alphabets" of size 26 characters and place all the given input chartacters in the respective index position. 
		  Starting with a = 0 to z = 25
		- Now get the search inputs "CAT" and "MICROSOFT" and do the following,
			1) For every character in the input check if that index has a character in the ALPHABETS array. 
			2) If present then move to next input character in the search string.
			3) Else print that the search word is not available.
*/

class WordSearchInMtx {
	char[][] input_chars = {
							{'A', 'C', 'P', 'R' , 'C'},
							{'X', 'S', 'O', 'P', 'C'}, 
							{'V', 'O', 'V', 'N', 'I'}, 
							{'W', 'G', 'F', 'M', 'N'}, 
							{'Q', 'A', 'T', 'I', 'T'}	
						  };

	public int[] alphabets;
	public String[] search_words = {"CAT", "MICROSOFT", "AMARNATH"};

	public static void main(String[] args) {
		WordSearchInMtx wsmObj = new WordSearchInMtx();
		wsmObj.initialize();
		wsmObj.searchWord();
	}

	public void initialize() {
		alphabets = new int[26];
		for(int i = 0; i < alphabets.length; i++) {
			alphabets[i] = -1;
		}

		for(int r = 0; r < input_chars.length; r++) {
			for(int c = 0; c < input_chars[0].length; c++) {
				char ch = input_chars[r][c];
				alphabets[ch - 65] = 1;
			}
		}
	}

	public void searchWord() {
		for(String input : search_words) {
			doLinearSearch(input, alphabets);
		}
	}

	public void doLinearSearch(String input, int[] alphabets) {
		int i = 0;
		for(; i < input.length(); i++) {
			char ch = input.charAt(i);

			if(alphabets[ch - 65] != -1) {
				continue;
			} else {
				break;
			}
		}

		if(i < input.length()) {
			System.out.println(input + " word CANNOT be formed.");
		} else {
			System.out.println(input + " word CAN be formed.");
		}
	}
}