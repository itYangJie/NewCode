package com.xmu.leetcode;

public class MaxPointsOnALine {
	
	public int maxPoints(Point[] points) {
		int n = points.length;
		int max = 0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				int count = 0;
				for(int k=0;k<n;k++) {
					if( (points[j].x-points[i].x)*(points[k].y-points[i].y)==
							(points[k].x-points[i].x)*(points[j].y-points[i].y))
						count++;
				}
				max = Math.max(count, max);
			}
		}
		return max;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
