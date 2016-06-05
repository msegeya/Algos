/**
	Question: Find longest sub-string with out any repeated characters.

	Source: http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
	
	NOTE: This is similar to MaxContSubArray.java where we solved using Kadane's algorithm. The only change is here the characters should not be repeated.

	Example: 
		Input: "ABDEFGABEF"; output: "BDEFGA" and "DEFGAB" (of length 6)
		Input: "GEEKSFORGEEKS"; output: "EKSFORG" and "KSFORGE"
	
	Logic-1: (A bit tricky.)
		- Let us talk about the linear time solution now. This solution uses extra space to store the last indexes of already visited characters. The idea is to scan the string from left to right, keep track of the maximum length Non-Repeating Character Substring (NRCS) seen so far. Let the maximum length be max_len. When we traverse the string, we also keep track of length of the current NRCS using cur_len variable. For every new character, we look for it is in already processed part of the string (A temp array called visited[] is used for this purpose). If it is not present, then we increase the cur_len by 1. If present, then there are two cases:
			a) The previous instance of character is not part of current NRCS (The NRCS which is under process). In this case, we need to simply increase cur_len by 1.

			b) If the previous instance is part of the current NRCS, then our current NRCS changes. It becomes the substring staring from the next character of previous instance to currently scanned character. We also need to compare cur_len and max_len, before changing current NRCS (or changing cur_len).

	See below code comments for more details.		
*/

class LongestNonRepSubStr {

	public static int CHARS_TOTAL_SCOPE = 256;	
	private String[] input;

	public static void main(String[] args) {
		LongestNonRepSubStr lnrsObj = new LongestNonRepSubStr();
		lnrsObj.prepareInput();

		lnrsObj.printNonRepeatSubStr();
	}

	void prepareInput() {
		input = new String[2];
		input[0] = "ABDEFGABEF";
		input[1] = "GEEKSFORGEEKS";
	}

	void printNonRepeatSubStr() {
		for(String str : input) {
			System.out.println("INPUT: " + str);
			int output_length = getSubString(str);
			System.out.println("OUTPUT: " + output_length);
		}
	}

	int getSubString(String str) {
		
		String output = null;
		
		// Take an array with 0 to 255 character length. As there are total of 256 characters.
		// We will use this array to keep track of the visited characters.
		int[] visited = new int[CHARS_TOTAL_SCOPE];

		// Initialize all visited array with default value as -1.
		for(int i = 0; i < visited.length; i++) {
			visited[i] = -1;
		}

		// As first char need not to be compared we will update it as visited.
		visited[str.charAt(0)] = 0;

		// current length of the sub-strings. We will initialize it with 1 as we have already visited one character.
		int cur_length = 1;

		// Final max_length of the sub-string. We will initialize it with 1 as we have already visited one character.
		int max_length = 1;

		// prev_index is used to store previous index.
		int prev_index = -1;

		// We will start at index 1 as we have already visited index 0.
		for(int i = 1; i < str.length(); i++) {

			// check whether the character is reached or not.
			// -1 means not visited.
			// 0 means it is visited.
			prev_index = visited[str.charAt(i)];

			// If a character is not visited then you will get prev_index as -1 OR
			// If the prev_index is some index_value other than -1 which means it is already visited then 
			// check whether it is in the index range of the current sub-string.
			// Example: Take input as "ABDEFGABEF". Non repetitive sub-string is from index 0 to 5. 
			// When index 6 came we need to check whether the element at index 6 (character 'A') is present or not in sub-string.
			// In-order to do that, we need to find out whether the index value from visited array that is prev_index is present 
			// within the current sub-string range or not. If present then go to else part.
			if(prev_index == -1 || ((i - cur_length) > prev_index)) {
				// increment the length
				cur_length++;
				// add its index as visited.
				visited[str.charAt(i)] = 0;
			} else {
				if(cur_length > max_length) {
					max_length = cur_length;
					output = new String(str.toCharArray(), i - cur_length, i - prev_index);
				}
				// As the new element occurred we need to change the length by including the current character 
				// and removing the index value of the previous occurrence of the current character. 
				cur_length = i - prev_index;
			}
			
			// In each iteration we need to update the index value of the visited character.
			visited[str.charAt(i)] = i;
		}

		if(cur_length > max_length) {
			max_length = cur_length;
		}
		
		System.out.println("Output String is: " + output);
		return max_length;
	}
}
