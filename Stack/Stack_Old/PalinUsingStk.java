/**
	Question: Check whether given string is palindrome or not.

	Reference: Karumanchi.

	Logic - 1: 
		1) Take two poiner startPtr and endPtr. One at start and the other at the end of the String.
		2) Move 'startPtr' and 'endPtr' one step at a time and compare the values at these positions.
		3) Do this until startPtr <= endPtr or until value at startPtr != value at endPtr.

	Logic - 2: (Using stack)
		1) Get the mid-point of the stack.
		2) Push characters in to stack until we reach the mid-point.
		3) Then start from (mid-point + 1) and check the top of the stack if they both are same then pop item from stack and move to next element. 
		4) If any element is mismatched or the stack is not empty then "Not a palindrome" else "It is a palindrome."
*/

import java.util.*;

class PalinUsingStk {
	public static void main(String[] args) {
		String[] input = {"ababaXababa", "ababaXYababa"};

		for(String item : input) {
			checkPalindrome(item);
		}
	}

	static void checkPalindrome(String input) {
		usingLogin_One(input);
		usingLogic_Two(input);
	}

	static void usingLogin_One(String input) {
		int startPtr = 0;
		int endPtr = input.length() - 1;

		while(startPtr < endPtr) {
			if(input.charAt(startPtr) == input.charAt(endPtr)) {
				startPtr++;
				endPtr--;
			} else {
				break;
			}
		}

		if(startPtr < endPtr) {
			System.out.println("Using Logic_One ==> " + "String " + input + " is a not a palindrome.");
		} else {
			System.out.println("Using Logic_One ==> " + "String " + input + " is a palindrome.");
		}
	}

	static void usingLogic_Two(String input) {
		Stack<Character> stack = new Stack<Character>();

		int length = input.length();
		int mid = input.length() / 2;

		for(int i = 0; i < mid; i++) {
			stack.push(input.charAt(i));
		}

		if(length % 2 == 0) {
			stack.push(input.charAt(mid));
		}

		int j = mid + 1;
		for(; j < length; j++) {
			if(stack.pop() == input.charAt(j)) {
			} else {
				break;
			}
		}

		if(!stack.isEmpty() || j < length) {
			System.out.println("Using Logic_Two ==> " + "String " + input + " is a not a palindrome.");
		} else {
			System.out.println("Using Logic_Two ==> " + "String " + input + " is a palindrome.");
		}		
	}
}