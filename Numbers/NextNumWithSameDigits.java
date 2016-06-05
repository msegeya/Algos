/**
	Question: Given number get the next number which should contain the same digits as the given number.

	Reference: 
	http://stackoverflow.com/questions/9368205/given-a-number-find-the-next-higher-number-which-has-the-exact-same-set-of-digi
	http://www.geeksforgeeks.org/find-next-greater-number-set-digits/

	Logic: 
		- Start from the right. Point y to last and x to last but one digits.
		- Move pointer x and y to left until x >= y.
		- If there is not element which satifiying above condition then return -1.
		- If there is any value x, y then 
			a) From x + 1 to end of number get the smallest digit and call this digit index as 'k'
			b) Remove this k from its postion and insert it before 'x'
			c) Now sort all the digits that are after k .. that is from digit x to end.
			d) Finally replace the digits from x to k with the sorted digits.
*/

import java.util.*;

class NextNumWithSameDigits {
	public static void main(String[] args) {
		int[] numbers = {218765, 1234, 4321, 534976};

		for(int num : numbers) {
			System.out.println("For " + num + "\t output = " + getNextGreatest(num));
		}
	}

	public static int getNextGreatest(int num) {
		StringBuilder builder = new StringBuilder(Integer.toString(num));
		int j = builder.length() - 1;
		int i = builder.length() - 2;
		while(i >= 0 && j >= 0) {
			if(builder.charAt(i) >= builder.charAt(j)) {
				i--;
				j--;
			} else {
				break;
			}
		}

		if(i < 0) {
			return -1;
		}

		if(i >= 0) {
			int k = i + 1;
			while(k < builder.length() && builder.charAt(i) < builder.charAt(k)) {
				k++;
			}

			if(k <= builder.length()) {
				k -= 1;

				char temp = builder.charAt(k);
				builder.deleteCharAt(k);
				builder.insert(i, temp);

				// sort the digits after the kth element.
				char[] remainDigits = builder.substring(i + 1, builder.length()).toCharArray();
				Arrays.sort(remainDigits);
				builder.replace(i + 1, builder.length(), String.valueOf(remainDigits));
			}
		}

		return Integer.parseInt(builder.toString());
	}
}