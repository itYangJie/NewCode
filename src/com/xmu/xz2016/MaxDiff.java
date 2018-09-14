package com.xmu.xz2016;

public class MaxDiff {

	public static void main(String[] args) {

	}
	public int getDis(int[] A, int n) {
		if(n<=1)
			return 0;
		int maxDiff = 0,min = A[0];
		for(int i=1;i<n;i++) {
			maxDiff = Math.max(maxDiff, A[i]-min);
			min = Math.min(min, A[i]);
		}
		return maxDiff;
    }
}
