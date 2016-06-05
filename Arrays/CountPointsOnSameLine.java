/**
	Question: Find the maximum number of points that lie on the same straight line. N points are given on a 2-dimensional plane. What is the maximum number of points on the same straight line?
	
	Reference:  http://stackoverflow.com/questions/4179581/what-is-the-most-efficient-algorithm-to-find-a-straight-line-that-goes-through-m
				https://www.careercup.com/question?id=1843671

	Logic: (Not sure about the logic. So please look for implementations.)
		- Sort the points basing on any axis .. say X-axis.
		- For every point with every other point calculate scope.
			==> scope (m) = (y2 - y1) / (x2 - x1)
		- Calculate y-intercept as, y = mx + c. We need to find out c here ==> c = (y - mx) where m is the slope and x, y is a point. Give priority to the positive point out of the two points.
		- If above two points are same then they are on the same line.
		- Store the above result in a data structure like Maps.
		- Fianlly get the points count which are having same scope and y-intercept.
*/

class CountPointsOnSameLine {

}