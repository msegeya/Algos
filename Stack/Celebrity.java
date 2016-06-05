/**
	Question: In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum number of questions.

	Reference: http://www.geeksforgeeks.org/the-celebrity-problem/

	Logic: 
		We have following observation based on elimination technique (Refer Polya’s How to Solve It book).
		- If A knows B, then A can’t be celebrity. Discard A, and B may be celebrity.
		- If A doesn’t know B, then B can’t be celebrity. Discard B, and A may be celebrity.
		- Repeat above two steps till we left with only one person.
		- Ensure the remained person is celebrity. (Why do we need this step? Such that the remaining person should not have acquaintance with any other person.
	
	Implementation Logic:
		-We can use stack to verity celebrity.
		- Push all the celebrities into a stack.
		- Pop off top two persons from the stack, discard one person based on return status of HaveAcquaintance(A, B).
		- Push the remained person onto stack.
		- Repeat step 2 and 3 until only one person remains in the stack.
		- Check the remained person in stack doesn’t have acquaintance with anyone else.	
*/

class Celebrity {

}