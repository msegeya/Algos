http://www.geeksforgeeks.org/data-structures/#Array

Finad the missing number in an array from 1.. 100
	==> FindMissingNumInUnSortedArray.java

Given an array A[] and a number x, check for pair in A[] with sum as x
	==> SumPair.java

Majority Element   ***** IMPORTANT *****
	==> MajorityElement.java

Find the Number Occurring Odd Number of Times   ***** IMPORTANT *****
	==> NumOccuringOddNumOfTimes.java

Find the two numbers with odd occurrences in an unsorted array   ***** IMPORTANT *****
	==> TwoNumOccuringOddTimes.java

Largest Sum Contiguous Subarray (Kadane's Algorithm)   ***** IMPORTANT *****
	==> MaxContSubArray.java

Search an element in a sorted and rotated array   ***** IMPORTANT *****
	==> SearchSortedRotated.java

Merge an array of size n into another array of size m+n
	==> MergeSortedArr.java

Write a program to reverse an array
	==> ReverseArray.java

Program for array rotation
	==> RotateArray.java

Reversal algorithm for array rotation
	==> RotateArray.java goto rotateRecur(..) method.

N/N - Block swap algorithm for array rotation

Maximum sum such that no two elements are adjacent   ***** IMPORTANT *****
	==> SumOfNonAdjEle.java

Leaders in an array
	==> LeaderEle.java

Sort elements by frequency
	==> SortByFrequency.java

Count Inversions in an array   ***** IMPORTANT ***** 
	==> InversionCounter.java

Two elements whose sum is closest to zero
	==> SumCloseToZero.java

Find the smallest and second smallest element in an array
	==> FirstAndSecondMax.java

Check for Majority Element in a sorted array
	==> MajorityEleInSortedArray.java

Maximum and minimum of an array using minimum number of comparisons
	==> Just go sequencially through all the numbers and keep track of min and max.

Segregate 0s and 1s in an array
	==> Get the number of 0's in the array with this count we will get the number of 1's.
	Finally put all the 0's at the start of the array and 1's after that.

k largest(or smallest) elements in an array ***** IMPORTANT ***** 
	==> Insert elements in PriorityQueue (MAX HEAP). Do k deletions such that the kth deletion is the kth largest element. --> O(nlogn)
			OR
	==> Sort the array and get the kth element from the start/end.		

Maximum difference between two elements
	==> Traverse the array and get Min and Max O(n). Get the difference of them.
	
Union and Intersection of two sorted arrays
==> 1) Sort both the arrays. (In this case they are already sorted.)
	2) Union:
		a) Take two pointers i (for array 1) and j (for array 2)
		b) If i and j index elements are same then do i++ and j++
		c) If i and j elements are different then print both array_1[i] and array_2[j] and then do i++ and j++
	3) Intersection: 
		a) Take two pointers i (for array 1) and j (for array 2)
		b) If i and j index elements are same then print and do i++ and j++.
		c) If i and j elements are different then,
			c1) If array_1[i] < array_2[j] then i++
			c2) If array_1[i] > array_2[j] then j++

Floor and Ceiling in a sorted array
	==> FloorAndCeilOfElement.java

A Product Array Puzzle
	==> ProductArray.java

Segregate Even and Odd numbers
	==> Take two pointers left and right. Move left to right until we see an odd element and similarly move right pointer to left until you see an even element.
	Swap them.
	Do this until left < right.

Find the two repeating elements in a given array
==> Use HashMap with key as element and value as count.

Sort an array of 0s, 1s and 2s   ***** IMPORTANT ***** 
	==> Sort012s.java

Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted   ***** IMPORTANT ***** 
	==> MinLenOfUnSortedArray.java

Find duplicates in O(n) time and O(1) extra space    ***** IMPORTANT *****
	==> RepeatedElements.java

Equilibrium index of an array
	==> EquilibriumOfArray.java

Linked List vs Array
	==>	
		- LL is fast for insertion or deletion. We can insert at head.
		- LL has variable chunk memory so there is not memory limit.

Which sorting algorithm makes minimum number of memory writes?
	==> Selection Sort.

Turn an array by 90 degree. Array can be squre or rectangle.   ***** IMPORTANT ***** 
	==> ArrayDegreeRotation.java

Next Greater Element    ***** IMPORTANT *****
	==> NextGreatestEleArray.java

Check if array elements are consecutive | Added Method 3
	==> Get the minimum element and the maximum element. The difference of this plus 1 should be equal to number of elements in the array.
		or
	==> Sort the array and see whether all the elements are consecutive or not.	

Find the smallest missing number in sorted array.    ***** IMPORTANT *****
	==> SmallestMissingNum.java

Count the number of occurrences in a sorted array
	==> Linearly search for the element and start counting it. 
		or
		Use Binary Search and check to the left and right indices of the element.
 
Given an array arr[], find the maximum j – i such that arr[j] > arr[i]    ***** IMPORTANT *****
	==> MaxSubArrayIndices.java

Maximum of all subarrays of window size "k" (Added a O(n) method)    ***** IMPORTANT *****
	==> MaxOfEachSubArray.java

Find whether an array is subset of another array | Added Method 3
	==> Sort both the arrays and then start from 0 in both the arrays and start comparing. If any element is missing then return false else true.

Find the minimum distance between two numbers    ***** IMPORTANT *****
	==> MinDistOfTwoEle.java

Find the repeating and the missing | Added 3 new methods
	==> RepeatAndMissing.java

Median in a stream of integers (running integers)    ***** IMPORTANT *****
	==> MedianOfIntegerStream.java

Find a Fixed Point in a given array
	==> Do binary search. The terminating condition will be,
			if(mid == array[mid]) {
				return mid;
			}
		Else return -1.	

Maximum Length Bitonic Subarray    ***** IMPORTANT *****
	==> BitonicSeq.java

Find the maximum element in an array which is first increasing and then decreasing
	OR
Find an element in a rotated sorted array.
	OR
Given a sorted and rotated array. I need to find the search the given element in this array.	***** IMPORTANT *****
	==> MaxEleIncrAndDecr.java

Count smaller elements on right side
	==> Refer InversionCounter.java
	==> CountSmallerEleOnRight.java

Minimum number of jumps to reach end   ***** IMPORTANT *****
	==> StepsToReachEndOfArray.java

Implement two stacks in an array
	==> Divide the array into two halfs and perform stack operations (push and pop) on the two halfs. Not space efficient.
		or
	==> Start both stacks are different ends. Stack-1 will start at index 0 and stack-2 at index n.
		http://www.geeksforgeeks.org/implement-two-stacks-in-an-array/

Find subarray with given sum    ***** IMPORTANT *****
	==> SubArrayForGivenSum.java

Dynamic Programming | Set 14 (Maximum Sum Increasing Subsequence)    ***** IMPORTANT *****
	==> DP/LongestIncrSubSeq.java

Longest Monotonically Increasing Subsequence Size (N log N)
	==> DP/LongestIncrSubSeq.java

Find a triplet that sum to a given value    ***** IMPORTANT *****
	==> TripletSum.java

Pythagorean Triplet in an array    ***** IMPORTANT *****
	==> PythagoreanTriplet.java

Find the smallest positive number missing from an unsorted array
	==> SmallestMissingPositiveNum.java

$$$ The Celebrity Problem $$$$$$$$$$$$$$$$$$$$$$$$$$$$
	==> 

Dynamic Programming | Set 15 (Longest Bitonic Subsequence)
	==> BitonicSeq.java

Find a sorted subsequence of size 3 in linear time    ***** IMPORTANT *****
	==> SortedSubSeqOfSize3.java

Find four elements that sum to a given value | Set 2 ( O(n^2Logn) Solution)    ***** IMPORTANT *****
	==> SumOfFourNumToGivenSum.java

Largest subarray with equal number of 0s and 1s    ***** IMPORTANT *****
	==> SubArrayWithEqual0And1.java

Partition problem - Dynamic Programming | Set 18 (Partition problem)    ***** IMPORTANT *****
	==> PartitionArray.java

Maximum Product Subarray    ***** IMPORTANT *****
	==> MaxProductSubArray.java

Find a pair with the given difference
	==> Sort the array and take two pointer's one at start and other at end.
		If the difference is less then do end--
		If the difference is more then do start++
	http://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/	

Given a sorted array and a number x, find the pair in array whose sum is closest to x
	==> Since the array is already sorted. Take two pointer start(0) and end(array.length - 1).
		Initialize DIFF = Integer.MAX_VALUE;
		If (array[start] + array[end] < X) { start++ }
		If (array[start] + array[end] > X) { end-- }
		else (array[start] + array[end] - X) and store the DIFF as DIFF = array[start] + array[end] - X;

Replace every element with the next greatest    ***** IMPORTANT *****
	==> ReplaceNextGreatestEle.java

Dynamic Programming | Set 20 (Maximum Length Chain of Pairs)    ***** IMPORTANT *****
	==> MaxLengthChainOfPairs.java

Sort a nearly sorted (or K sorted) array    ***** IMPORTANT *****
	==> SortKSortedArray.java

Maximum circular subarray sum $$$$$$$$$$$$$$$$$
	==> 

Find the row with maximum number of 1s
	==> Algos/Matrix/MaxOf1sInRow.java

Median of two sorted arrays of different sizes
	==> MedianOfTwoSortedArrays.java

Shuffle a given array    ***** IMPORTANT *****
OR
Randomly play a song from a list of given songs in such a way that no songs is repeated until all the songs are played
OR
If I am designing a media player and I want to store songs and play them in random order
 a) what data structure will you use to store songs?
 b) how will select the next song to play in a way which prevents the same song being played in consecutive turn
	==> ShuffleArray.java

Count the number of possible triangles
	==> CountValidTriangles.java

Find the number of islands    ***** IMPORTANT *****
	==> NumOfIslands.java

Construction of Longest Monotonically Increasing Subsequence (N log N)
	==> DP/LongestIncrSubSeq.java

K'th Smallest/Largest Element in Unsorted Array $$$$$$$$$$$$$$$$$$$$$$$$$$
	==> KthSmallestElement.java

Find the first circular tour that visits all petrol pumps    ***** IMPORTANT *****
	==> VisitAllPetrolPumps.java

Find Union and Intersection of two unsorted arrays
	==> Same as "Union and Intersection of two sorted arrays". 
		Search for "Union and Intersection of two sorted arrays" in this page for the logic.

Common elements from n sorted arrays    ***** IMPORTANT *****
	==> Matrix/CommonElementInAllRows.java

Given n non-negative integers representing an 2-D elevation map where the width of each bar is 1, You need to compute how much water it is able to trap after raining.    ***** IMPORTANT *****
	==> TrappingRainWater.java

Given a 2-D plane and number of points are given on that 2-D plane which are represented by its (x,y) co-ordinates.
	==> CountPointsOnSameLine.java

Given an array of numbers, return array of products of all other numbers (no division is allowed)   ***** IMPORTANT *****
	==> ProductOfArrayWithoutDivision.java

Find three closest elements from given three sorted arrays    ***** IMPORTANT *****
	==> ClosestEleOf3SortedArrays.java

Given a string, find its first non-repeating character.    ***** IMPORTANT *****   ??????????????????????????
	OR
Find the first non-repeating character from a stream of characters
	==> FirstNonRepeatedCharInStream.java

Find the minimum element in a sorted and rotated array
	==> FindMinEleInRotatedSortedArray.java

Merge k sorted arrays
	==> MergeKSortedArrays.java

Arrange given numbers to form the biggest number    ***** IMPORTANT *****
	==> FormBiggestNumFromGivenNum.java

Given an unsorted array which contains unique numbers from 0 to 999 and size of array is 1000. At one of the index the element has been replaced by some other element. Find the original element.
	==> RepeatAndMissing.java

Find the first repeating element in an array of integers
	==> FindFirstRepeatingElementInArray.java

Move all zeroes to end of array
	==> Move0sToEnd.java

Find common elements in three sorted arrays
	==> Matrix/CommonElementInAllRows.java

Print all possible combinations of r elements in a given array of size n
	==> AllPossibleCombinationsOfArray.java

Find a peak element
	==> FindPeakEleInArray.java

Find the largest pair sum in an unsorted array
	==> LargestPairSumInUnSortedArray.java

Replace every array element by multiplication of previous and next.
	==> ReplaceWithMulOfAdjEle.java

Find the element that appears once     ??????????????????????????
	==> ElementAppearedOnlyOnce.java

Smallest subarray with sum greater than a given value
	==> SmallestSubArrayWithSum.java

Sort an array according to the order defined by another array
	==> SortArrayBasedOnAnotherArray.java

Maximum Sum Path in Two Arrays
	==> MaxSumPathInTwoArrays.java

Merge Overlapping Intervals
	==> 




Pancake sorting
A Pancake Sorting Problem
Tug of War
Find the maximum repeating number in O(n) time and O(1) extra space
Stock Buy Sell to Maximize Profit
Rearrange positive and negative numbers in O(n) time and O(1) extra space
Given an array of of size n and a number k, find all elements that appear more than n/k times
Find the point where a monotonically increasing function becomes positive first time
Find the Increasing subsequence of length three with maximum product
Stable Marriage Problem
Find number of pairs such that x^y > y^x
Count all distinct pairs with difference equal to k
Find if there is a subarray with 0 sum
Check if a given array contains duplicate elements within k distance from each other
Sort an array in wave form
Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in a binary array
Find the closest pair from two sorted arrays
Given a sorted array and a number x, find the pair in array whose sum is closest to x
Count 1’s in a sorted binary array
Print All Distinct Elements of a given integer array
Construct an array from its pair-sum array
Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’
Find position of an element in a sorted array of infinite numbers
Can QuickSort be implemented in O(nLogn) worst case time complexity?
Check if a given array contains duplicate elements within k distance from each other
Check if any two intervals overlap among a given set of intervals
Delete an element from array (Using two traversals and one traversal)
Online algorithm for checking palindrome in a stream
Maximum profit by buying and selling a share at most twice
Given an array os 0s and 1s, and another input m, I was supposed to tell the longest continuous streak of 1s after flipping m 0s to 1s. E.g., Array is {1,1,0,0,1,1,1,0,1,1} m = 1 (which means I can flip ‘m’ one 0 to 1)