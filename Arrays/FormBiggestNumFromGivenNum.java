/**
	Question: Arrange given numbers to form the biggest number. 

	Reference: 	http://www.programcreek.com/2014/02/leetcode-largest-number-java/
				http://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/

	Example: [3, 30, 34, 5, 9] ==> 9534330

	Logic: 
		- Consider each integer in an array as a string.
		- One idea whcih we get is to sort the array in reverse order and then append the Integers and group them.
		  But this does not work. Take the  following example,
		  	548 is greater than 60, but in output 60 comes before 548. 
		  	98 is greater than 9, but 9 comes before 98 in output.
		- So just sorting won't help. While sorting for every adjacent numbers see two combination s1 and s2 or s2 and s1.
		  If s1 + s2 is greater than s2 + s1 then return s1 as the highest element else return s2.
*/
import java.util.*;

class FormBiggestNumFromGivenNum {
	public static void main(String[] args) {
		int[] array = {3, 30, 34, 5, 9}; // 9534330
		System.out.println(getBiggestNum(array));
	}

	public static String getBiggestNum(int[] array) {
		String[] strs = new String[array.length];

		for(int i = 0; i < array.length; i++) {
			strs[i] = Integer.toString(array[i]);
		}

		Arrays.sort(strs, new Comparator<String>() {
				public int compare(String s1, String s2) {
					String leftToRight = s1 + s2;
					String rightToLeft = s2 + s1;

					return rightToLeft.compareTo(leftToRight);
				}
		});

		ArrayUtil.print(strs, "After Sorting strings: ");

		StringBuilder builder = new StringBuilder();
		for(String s: strs) {
			builder.append(s);
		}

		// NOTE: If there is 0 at the start then we can remove it.
		if(builder.length() > 0 && builder.charAt(0) == '0') {
			builder.deleteCharAt(0);
		}

		return builder.toString();
	}
}