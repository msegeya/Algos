class PrintLevelBottomToTop {
	/*
		Using RECURSION:
			We use a for loop and pass level[0..height] to below code,

			if(0 == level) {
				System.out.println(root.data);
			}
			printLevelByLevelRecur(root.left, level - 1);
			printLevelByLevelRecur(root.right, level - 1);

		The recursive code remains same. But the for loop logic changes as below,
			for loop now becomes, for level in [height..0].
		Change the for loop level from maximum level to minimum level.	


		Using ITERATIVE:
			Using BFS we push all the nodes into Queue and pop them and push children of the popped element.
			Now, 
				For all the elements which are popped from Queue, push them into the Stack.

			Finally, 
				pop each element from stack and print it.	
	*/
}