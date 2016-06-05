/**
	Question: You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i), width w(i) and depth d(i) (all real numbers). You 			want to create a stack of boxes which is as tall as possible, but you can only stack a box on top of another box if the dimensions of the 2-D base 			of the lower box are each strictly larger than those of the 2-D base of the higher box. Of course, you can rotate a box so that any side functions 			as its base. It is also allowable to use multiple instances of the same type of box. Find the maximum height that can be formed.	
			IN SIMPLE, YOU HAVE TO PLACE THE BOXES IN PYRAMID FASION SUCH THAT WE GET THE MAXIMUM HEIGHT.

	Source: http://people.cs.clemson.edu/~bcdean/dp_practice/
			http://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
			http://stackoverflow.com/questions/2329492/box-stacking-problem?rq=1

	NOTE: For simplicity we will always make sure WIDTH is <= DEPTH.

	What is Height, Width and Depth of a rectangle?
		Consdier a rectangle in 3D space. 
		Height ==> From top to bottom.
		Width  ==> From left to right of the rectangle.
		Depth  ==> The reamining line is depth. When you make the rectangle as below diagram and see from top then Depth is sides.
		Base   ==> (Depth x Width)
						 ------- W --------
						| 				  |
						D                 D
						|                 |
						-------- W --------
		If you want to know how it looks visually then do check the image "Box_Height_Width_Depth.gif" in the current folder.

	Logic: 
		- See the video mentioned @ "http://people.cs.clemson.edu/~bcdean/dp_practice/" and also go through above links.
		- Take a box and note that you can place the box 3 ways. Visualize it by taking a mobile phone or a box.
		  Consider the below scenario with (H x W x D) = (1, 2, 3)
		  We can place the box in three ways, (Take a box or mobile and imagine how many ways you can place the box. => 3 ways)
		  		(1, 2, 3) ==> H = 1; W = 2; D = 3.
		  		(2, 1, 3) ==> H = 2; W = 1; D = 3.
		  		(3, 1, 2) ==> H = 3; W = 1; D = 2.
		  ==> So if a dimension of a box is given then we can place the box in three ways.
		  ==> If we have N boxes then after all the possible rotations for each box we will have 3N boxes. ==> ROTATIONS
		- Now we will come to "how to place them". The one with large base will go at the bottom. So we need to calculate the base for all rotations of all given boxes and sort them in the decreasing order of their base value. (Note: For simplicity we will always make sure WIDTH <= DEPTH)
		- As of now we are ready with bases and now we need to arrange the piles based on height. 
		  Initialize all the DPHeight's array with the heights. (Just like we initialise the DP's with 1 in LIS (LongestIncreasingSubSeq.java)).
		- Now the business logic is,
			func(i, j) = ((ROTATIONS[i].WIDTH < ROTATIONS[j].WIDTH && ROTATIONS[i].DEPTH < ROTATIONS[j].DEPTH) 
								&& 
						  (DPHeight[j] + ROTATIONS[i].height > DPHeight[j]))
				where j <= i	  
			DPHeight[i] = Max(func(i, j))

			Finally the one with highest DPHeight will be the output.

	Example: (H x W x D)
		- Input: Box1 = (4, 6, 7), Box2 = (1, 2, 3), Box3 = (4, 5, 6), Box4 = (10, 12, 32)
		- Nowe will do rotations. For simplicity we will make sure (WIDTH <= DEPTH)
		- Step 1: Rotate them. (H x W x D)
			=> Box1 = (4, 6, 7)
				Rotation-1 => (4 x 6 x 7); (same as input)
				Rotation-2 => (6 x 4 x 7); 
				Rotation-3 => (7 x 4 x 6);

			=> Box2 = (1, 2, 3)
				Rotations =	(1 x 2 x 3) 
							(2 x 1 x 3) 
							(3 x 1 x 2)

			=> Box3 = (4, 5, 6)
				Rotations =	(4 x 5 x 6) 
							(5 x 4 x 6)  
							(6 x 4 x 5)

			=> Box4 = (10, 12, 32)
				Rotations = (10 x 12 x 32)	
							(12 x 10 x 32) 
							(32 x 10 x 12)
		- Now calcualte the base for each of the rectangle. ==> Base = (Width x Depth)
		  Why to sort them basing on base? => Since the box with big base has to be at the base of the box stack.

				(4 x 6 x 7)	= Base is 42; (6 x 4 x 7) = 28; (7 x 4 x 6) = 24;
				
				(1 x 2 x 3) = 6; (2 x 1 x 3) = 3; (3 x 1 x 2) = 2;
				
				(4 x 5 x 6) = 30; (5 x 4 x 6) = 24; (6 x 4 x 5) = 20;
				
				(10 x 12 x 32) = 384; (12 x 10 x 32) = 320; (32 x 10 x 12) = 120;
		
		- Sort the boxes in decreasing order basing on the calculated base value.
			(10 x 12 x 32) = 384;
			(12 x 10 x 32) = 320;
			(32 x 10 x 12) = 120;
			(4 x 6 x 7) = 42;
			(4 x 5 x 6) = 30;
			(6 x 4 x 7) = 28;
			(7 x 4 x 6) = 24;
			(5 x 4 x 6) = 24;
			(6 x 4 x 5) = 20;
			(1 x 2 x 3) = 6;
			(2 x 1 x 3) = 3;
			(3 x 1 x 2) = 2;

		- Take the 1st one as base of the Stack box. (10 x 12 x 32); DP[0] = 10; Assign height to DP.
		- 2nd one, (12 x 10 x 32). Initialize DP of current box with DP[1] = 12;
		  	Inorder to include this one, it has to satisfy the below condition.
				(rotations[i].width < rotations[j].width) && (rotations[i].depth < rotations[j].depth)
						AND 
				(DP[i] < DP[j] + rotations[i].height)

		  What does this mean (DP[i] < DP[j] + rotations[i].height)?
		   ==> The DP of the previous box (DP_prev + current_box_height) should be less than the (height_of_the_current box).
		  If you didn't understand please refer LIS implementation in "LongestIncreasingSubSeq.java"
*/

import java.util.*;

class BoxStacking {
	public static void main(String[] args) {
		Box[] boxes = {new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32)};

		BoxStacking bsObj = new BoxStacking();

		// print input
		System.out.println("Given input boxes: ");
		Box.printBoxes(boxes);

		bsObj.printBoxStackHeight(boxes);
	}

	void printBoxStackHeight(Box[] boxes) {
		int height_stack_boxes = getHeightOfStackBoxes(boxes);
		System.out.println("\nSTACK HEIGHT IS: " + height_stack_boxes);
	}

	int getHeightOfStackBoxes(Box[] boxes) {
		// step-1: Rotate boxes
		Box[] rotations = getBoxRotations(boxes);	

		// step-2: Sort rotated boxes based on base that is (base = WIDTH * HEIGHT)
		Box[] rot = sortBoxesUsingBase(rotations);

		// step-3: Use LIS logic to get max stack height
		int max_height = calBoxHeightUsingLIS(rot);

		return max_height;
	}

	/**
		NOTE: For simplicity we will always make sure WIDTH is <= DEPTH.
	*/
	Box[] getBoxRotations(Box[] boxes) {
		Box[] rotations = new Box[3 * boxes.length];

		int count = 0;
		for(Box box : boxes) {
			// 1st one will be same as input
			rotations[count] = box;
			count++;

			// 2nd rotations and 3rd rotation should rotate in such a way that WIDTH <= DEPTH
			rotations[count] = new Box();
			rotations[count].height = box.width;
			rotations[count].depth = Math.max(box.height, box.depth); // Take the max of the remaining as DEPTH
			rotations[count].width = Math.min(box.height, box.depth); // Take the min of the remaining as WIDTH
			count++;

			// 3rd rotation
			rotations[count] = new Box();
			rotations[count].height = box.depth;		
			rotations[count].depth = Math.max(box.height, box.width); // Take the max of the remaining as DEPTH
			rotations[count].width = Math.min(box.height, box.width); // Take the min of the remaining as WIDTH
			count++;
		}

		// print rotated boxes.
		System.out.println("Box Rotations: ");
		Box.printBoxes(rotations);

		return rotations;
	}

	/**
		Sort boxes based on base value i,e. (WIDTH x DEPTH)
	*/
	Box[] sortBoxesUsingBase(Box[] boxes) {
		SortBoxUsingBase baseSort = new SortBoxUsingBase();
		Arrays.sort(boxes, baseSort);

		System.out.println("Boxes after Sorting: ");
		Box.printBoxes(boxes);

		return boxes;
	}

	/*
		Input are set of boxes which are already soreted. Now, we need to compare one box with another using width and height.
		Also (previous_box_height + 1) should be greater than the current_box_height.
	*/
	int calBoxHeightUsingLIS(Box[] boxes) {
		int[] DPHeight = new int[boxes.length];
		int[] pickedBoxesIndices = new int[boxes.length];
		int max_height = 1;
		int bestEnd = 0;

		// Initialize DPHeight's first height.
		DPHeight[0] = boxes[0].height;
		pickedBoxesIndices[0] = -1;

		for(int i = 1; i < boxes.length; i++) {
			DPHeight[i] = boxes[i].height;
			pickedBoxesIndices[i] = -1;
			for(int j = i - 1; j >= 0; j--) {
				Box cur_Box = boxes[i];
				Box prev_Box = boxes[j];

				if((cur_Box.width < prev_Box.width) 
							&& (cur_Box.depth < prev_Box.depth)
								&& (DPHeight[j] + cur_Box.height > DPHeight[i])) {

					DPHeight[i] = DPHeight[j] + cur_Box.height;
					pickedBoxesIndices[i] = j;
				}
			} // inner for loop.

			if(max_height < DPHeight[i]) {
				max_height = DPHeight[i];
				bestEnd = i;
			}
		} // outer for loop

		System.out.println("Selected boxes are: ");
		while(bestEnd != -1) {
			Box pickedBox = boxes[bestEnd];
			System.out.println(pickedBox.height + " x " + pickedBox.width + " x " + pickedBox.depth);
			bestEnd = pickedBoxesIndices[bestEnd];
		}

		return max_height;
	}

}