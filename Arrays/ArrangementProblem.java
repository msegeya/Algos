/**
	Question: Suppose given a set of numbers randomly can you sort them only by using rotations. 

	Example: Conside the following example where we need to arrange the numbers in the sorted order. You have only one condition you can rotate number only in a subset of 3.
			1) Input: {3, 1, 2} ==> Output: Yes. 
			We can rotate by 1 towards left ==> {1, 2, 3}
	
			2) {1, 3, 4, 2} ==> Output: Yes
			We can rotate subset (3, 4, 2) to left by one. It becomes (2, 3, 4) ==> {1, 2, 3, 4}

			3) {1, 2, 3, 5, 4} ==> NO
			Subset of 3 that is (3, 5, 4) ==> Rotations does not order 5 and 4 within this set. So cannot be sorted.

	NOTE: This question can also be asked as 15-puzzle problem. Look the below video for more details.

	Reference: https://www.youtube.com/watch?v=TKXiHdgOHaU

	Logic: 
		- Given an array check whether using rotations it can be sorted or not.
		- For each element in the array check how many elements on the right are less than this element .. add the number of elements to **count**
		- If count is even then the elements can be sorted else cannot be sorted.
*/

class ArrangementProblem {
	public static void main(String[] args) {
        int[][] array = {
        				{3, 1, 2},
        			  	{1, 3, 4, 2},
        			  	{1, 2, 3, 5, 4}
        			  };

        for(int i = 0; i < array.length; i++) {
        	using_15_puzzle_approach(array[i]);
        }			  
    }
    
    static void using_15_puzzle_approach(int[] array) {
        int total_nums = 0;
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    total_nums += 1;
                }
            }
        }
        
        // even
        if(total_nums % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}