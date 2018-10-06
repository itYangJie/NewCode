package com.xmu.interviewgold;

public class MaxSubMat {

	public int maxSubMatrix(int[][] mat, int n) {

		int[][] right = new int[n][n];
		int[][] below = new int[n][n];

		// right[i][j] = 1+right[i][j+1]
		// below[i][j] = 1+below[i+1][j]
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (j == n - 1 || mat[i][j] != mat[i][j + 1]) {
					right[i][j] = 1;
				} else {
					right[i][j] = 1 + right[i][j + 1];
				}
				if (i == n - 1 || mat[i][j] != mat[i + 1][j]) {
					below[i][j] = 1;
				} else {
					below[i][j] = 1 + below[i + 1][j];
				}
			}
		}
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int len = Math.min(below[i][j],right[i][j]);
				int k=len;
				for(;k>=1;k--) {
					if(right[i+k-1][j]>=k && below[i][j+k-1]>=k)
						break;
				}
				res = Math.max(res, k);
			}
		}
		return res;
	}
}
