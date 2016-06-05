/**
	Question: Given a large string and a target string which is a substring of the large string. Find whether the sub-string exists or not?

	Example: 

	Source: https://www.youtube.com/watch?v=GTJr8OvyEVQ&index=7&list=PLTS60CibV9pAotipCiJwCdtC6Sntzgbww
			http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
			http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/

	Logic: 
		- Watch the video for detailed explanation.
		- Calcualte partial matching table. See below calPartialMatchTable(..) method for more details.
		- For finding pattern match see getPatternMatchPosition(..) method for more details.
*/

class KMP {
	public static void main(String[] args) {
		KMP kmpObj = new KMP();	
		
		// String text = "ABCBCGLX"; String pattern = "BCGL";	// output: pattern found at 3.
		// String text = "AAAAAAAAAAAAAAAAAB"; String pattern = "AAAAB"; // output: pattern found at 13.
		String text = "ABABABCABABABCABABABC"; String pattern = "ABABAC"; // output: Negative case.

		kmpObj.printPatternMatching(text, pattern);
	}

	void printPatternMatching(String text,
									String pattern) {
		int[] partialMatchTbl = calPartialMatchTable(pattern);
		int patternStartPos = getPatternMatchPosition(text, pattern, partialMatchTbl);
		System.out.println();
		System.out.println("Text pattern: " + text);
		if(-1 == patternStartPos) {
			System.out.println("Pattern sub-string not found.");
		} else {
			System.out.println("Pattern found at index: " + patternStartPos);
		}
	}

	/**
		Explanation: We have now the Partial Array so that we can make our process fast.
			Start from 0 in both text and pattern. When ever there is a mismatch then we cannot go backwards in text, we need to do that in pattern by using the partial array values.
			So when ever some character mismatches then just get the value of the previous index of j i,e. (j-1) and make the pointer point to that position.
			If j pointer reaches all the way to the end of the pattern then it matches else there is a mismatch. 
			Look at below comments for more details.
	*/
	int getPatternMatchPosition(String text, 
									String pattern,
										int[] partialMatchTbl) {
		int i = 0;
		int j = 0;
		boolean matchStatus = false;
		int PATTERNLENGTH = pattern.length() - 1;
		int startPos = -1;

		while(i < text.length() && j < pattern.length()) {
			// If char at i and j pointers are same then increment i and j.
			// If j reaches end and if the last character also matches then we are done.
			if(text.charAt(i) == pattern.charAt(j)) {
				if(j == PATTERNLENGTH) {
					break;
				}
				i += 1; 
				j += 1;
			} else {
				// If j is at index 0 then we can't move backwards so we make pointer i move forward.
				// else get the value of jth index from partialMatchTbl and move jth pointer to that index.
				if(j == 0) {
					i++;
				} else {
					j = partialMatchTbl[j - 1];
				}
			}
		}

		if(j == PATTERNLENGTH) {
			startPos = i - PATTERNLENGTH;
		}

		return startPos;
	}

	/**
		Explanation: (Partial table calculation.) ==> O(m)
			We need to create an array (say partial match array) where we calculate the prefix values of the string.

			Ex-1: 
				Pattern --> a 	b 	c 	d 	a 	b 	c 	a
		  Partial Array --> 0	0	0	0	1	2	3	1

		   Take two pointers j and i pointing to zeroth and first element respectively. 
		   Compare value at i and j,
		   		If matched then update the value at partialArray[i] with (j + 1) and increment i and j by 1 (until i reaches end of the string.)
		   		If not matched, then get the value partial index value at (j - 1) i,e. partialArray[j-1] and make j pointer move to that position.
		   		
		   	Why are we doing this?
				Look at above example's partial array. When ever a character or a set of characters has to be repeated previously in the patern then there is no need to search for the same characters again in the input "text". See the video for more explanation.
				The main reason for constructing the pattern array is, "not to repeat the comparisons and search on the pattern again with text."
	*/
	int[] calPartialMatchTable(String pattern) {
		int j = 0;
		int i = 1;

		int[] matchTbl = new int[pattern.length()];
		matchTbl[0] = 0;

		while(i < pattern.length() && j < i) {
			// If char at i and j are same then update the value at i by (index_of_j + 1)
			if(pattern.charAt(i) == pattern.charAt(j)) {
				matchTbl[i] = j + 1;
				i++;
				j++;
			} else {
				// If not matched then take the previous char's value from matchTbl and move j_pointer to that position.
				// Don't worry. j-pointer never goes out of index.

				// If j_ptr is at index 0 then it can't move furthur back. So we update the value at matchTbl index of i and increment i.
				if(j == 0) {
					matchTbl[i] = 0;
					i++;
				} else {
					j = matchTbl[j - 1];
				}
			}
		}

		System.out.print("Partial Matching Table for " + pattern + " is: ");
		for(int index : matchTbl) {
			System.out.print(index + " ");
		}
		return matchTbl;
	}

}