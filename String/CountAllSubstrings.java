/**
	Question: Print All SubStrings of a given string.

	Reference: https://www.careercup.com/question?id=3315662

	Logic: (We will use Suffix Algorithm.)
		- Get all the suffixes of a String.
			Ex: For "banana" => {banana, anana, nana, ana, na, a}
		- Sort the suffixes alphabetically.
			array = {a, ana, anana, banana, na, nana}
		- Take a variable called count and initialize it with the first string in the array. 
			Here, count = length("a") = 1
		- For every other string do the following,
			1) i = 0 to array.length - 1
				 s1 = array[i];
				 s2 = array[i + 1];
			2) Find the Longest Common Substring(LCS) of s1 and s2. say "lcs_len". LCS is nothing but to check until which length both the strings are having common characters.
			3) Do, count += length()
*/


import java.util.*;

class CountAllSubstrings {
	public static void main(String[] args) {
		String input = "abc";
		String[] prefixes = new String[input.length()];

		for(int i = 0; i < prefixes.length; i++) {
			prefixes[i] = input.substring(i, input.length());
			// System.out.println(prefixes[i]);
		}

		Arrays.sort(prefixes, new Comparator<String>() {
						public int compare(String s1, String s2) {
							return s1.compareTo(s2);
						}
		});

		int count = prefixes[0].length();
		for(int i = 0; i < prefixes.length - 1; i++) {
			String s1 = prefixes[i];
			String s2 = prefixes[i + 1];

			count += (s2.length() - LCP(s1, s2));
		}

		System.out.println("Total Sub Strings = " + count);
	}

	// Longest Common Prefix (LCP)
	public static int LCP(String s1, String s2) {
		int i = 0, j = 0;
		int counter = 0;
		while(i < s1.length() && j < s2.length()) {
			if(s1.charAt(i) == s2.charAt(i)) {
				counter++;
			} else {
				break;
			}
			i++;
			j++;
		}

		return counter;
	}

	public static void print(String[] prefixes) {
		for(int i = 0; i < prefixes.length; i++) {
			System.out.println(prefixes[i]);
		}	
	}
}