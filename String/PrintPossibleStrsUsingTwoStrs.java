/**
	Question: Given two strings say xyz and abc. Find all the strings that can be formed with these two strings. One constraint is that the sequence of characters in each string should remain the same.

	Example: xyabzc - Valid, xabcyz - Valid, abcxyz - Valid, xyzacb - Invalid. (b cannot come before c)

	Reference: http://stackoverflow.com/questions/37411609/print-strings-that-can-be-formed-with-two-strings

	Logic: 
		- We can do it recursively. Just follow the below code, it's very simple.
*/

import java.util.*;

class PrintPossibleStrsUsingTwoStrs {
	
	public static String str1;
	public static String str2;
	public static List<String> list;
	
	public static void main(String[] args) {
		str1 = new String("abc");
		str2 = new String("xyz");
		list = new ArrayList<String>();	
		
		genPosStrs(0, 0, "");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void genPosStrs(int i, int j, String result) {
		if(i == str1.length() && j == str2.length()) {
			list.add(result.toString());
		}
		
		if(i < str1.length()) {
			String subResult = result + Character.toString(str1.charAt(i));
			genPosStrs(i + 1, j, subResult);
		}
		
		if(j < str2.length()) {
			String subResult = result + Character.toString(str2.charAt(j));
			genPosStrs(i, j + 1, subResult);
		}
	}
}