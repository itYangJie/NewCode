package com.xmu.xz2016;

public class YearEndAwards {

	public static void main(String[] args) {

	}
	public int getMost(int[][] board) {
		int n = board.length,m = board[0].length;
		int[][] dp = new int[n][m];
		dp[0][0] = board[0][0];
		
		for(int i=1;i<n;i++)
			dp[i][0] = dp[i-1][0]+board[i][0];
		for(int i=1;i<m;i++)
			dp[0][i] = dp[0][i-1]+board[0][i];
		
		for(int i=1;i<n;i++)
			for(int j=1;j<m;j++) 
				dp[i][j] = board[i][j]+Math.max(dp[i-1][j], dp[i][j-1]);
		return dp[n-1][m-1];
    }
}
