package com.xmu.xz2016;

public class Gloves {

	public static void main(String[] args) {

	}
	public int findMinimum(int n, int[] left, int[] right) {
		
		int sumZero = 0;
		int sumLeft=0,sumRight=0;
		int minLeft = Integer.MAX_VALUE,minRight = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(left[i]==0 || right[i]==0)
				sumZero += (left[i]+right[i]);
			else {
				sumLeft += left[i];
				sumRight += right[i];
				minLeft = Math.min(minLeft, left[i]);
				minRight = Math.min(minRight, right[i]);
			}
			
		}
		return Math.min(sumLeft-minLeft+1, sumRight-minRight+1)+1+sumZero;
    }
}
