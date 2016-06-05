class PrintLevelRightToLeft {
	/* Using recursion logic is to print level by level from top to bottom or from bottom to top.
		
	   In Recursion we used to call,
	   	printLevel(root.left, level - 1);
	   	printLevel(root.right, level - 1);

	   So now to print from left to right we just need to reverse these statements.
		printLevel(root.right, level - 1);
	   	printLevel(root.left, level - 1);	   	
	*/

	/*
		Similarly in Iterative,
		 Insert right node into the queue then insert the left node.
	*/	   	
}