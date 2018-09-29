package com.xmu.xz2016;

public class ChangeForChanges {

	public static void main(String[] args) {
		

	}

	public int countWays(int[] changes, int n, int x) {
		
		int[][] dp = new int[n][x+1];
		for(int i=0;i<n;i++)
			dp[i][0] = 1;
		for(int i=1;i<=x;i++)
			dp[0][i] = ((i%changes[0]==0)?1:0);
		for(int i=1;i<n;i++)
			for(int j=1;j<=x;j++) {
				dp[i][j] = dp[i-1][j]+((j-changes[i]>=0)?dp[i][j-changes[i]]:0);
			}
		return dp[n-1][x];
	}
}
