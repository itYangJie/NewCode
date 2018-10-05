package com.xmu.interviewgold;

public class MaxSumSubMat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumOfSubMatrix(int[][] mat, int n) {
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			int temp[] = new int[n];
			for(int j=i;j<n;j++) {
				for(int k=0;k<n;k++) {
					temp[k] = temp[k]+mat[j][k];
				}
				max = Math.max(max,solve(temp,n));
			}
		}
		return max;
	}

	private int solve(int[] temp,int n) {
		
		int[] dp = new int[n];
		dp[0] = temp[0];
		int max = dp[0];
		for(int i=1;i<n;i++) {
			if(dp[i-1]<=0)
				dp[i] = temp[i];
			else
				dp[i] = dp[i-1]+temp[i];
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
