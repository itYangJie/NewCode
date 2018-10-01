package com.xmu.test;

public class FindSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLongest("1A2C3D4B56", 10, "B1D23CA45B6A", 12));
	}

	public int findLongest(int[] A, int n) {
		if(n<=1)
			return n;
		
		int[] dp = new int[n];
		int max = 0;
		
		dp[0] = 1;
		
		for(int i=1;i<n;i++) {
			int temp = 1;
			for(int j=0;j<i;j++) {
				if(A[j]<A[i])
					temp = Math.max(temp, 1+dp[j]);
			}
			dp[i] = temp;
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static int findLCS(String A, int n, String B, int m) {

		if (n == 0 || m == 0)
			return 0;
		int dp[][] = new int[n][m];

		boolean flag = false;
		for (int i = 0; i < m; i++) {
			if (flag || A.charAt(0) == B.charAt(i)) {
				dp[0][i] = 1;
				flag = true;
			}
		}
		flag = false;
		for (int i = 0; i < n; i++) {
			if (flag || B.charAt(0) == A.charAt(i)) {
				dp[i][0] = 1;
				flag = true;
			}
		}
		int maxComLen = 0;
		for (int i = 1; i < n; i++)
			for (int j = 1; j < m; j++) {
				if (A.charAt(i) != B.charAt(j))
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				else
					dp[i][j] = 1 + dp[i - 1][j - 1];
				if (dp[i][j] > maxComLen) {
					maxComLen = dp[i][j];
				}
			}

		return maxComLen;
	}

	public static int findLongest(String A, int n, String B, int m) {
		if (n == 0 || m == 0)
			return 0;
		int dp[][] = new int[n][m];

		for (int i = 0; i < m; i++)
			if (A.charAt(0) == B.charAt(i))
				dp[0][i] = 1;
		for (int i = 0; i < n; i++)
			if (B.charAt(0) == A.charAt(i))
				dp[i][0] = 1;

		int maxComLen = 0;
		for (int i = 1; i < n; i++)
			for (int j = 1; j < m; j++) {
				if (A.charAt(i) != B.charAt(j))
					dp[i][j] = 0;
				else
					dp[i][j] = 1 + dp[i - 1][j - 1];
				if (dp[i][j] > maxComLen) {
					maxComLen = dp[i][j];
				}
			}
		return maxComLen;
	}
	/**
	 * ×îÐ¡±à¼­¾àÀë£¨²åÈë£¬É¾³ý£¬ÐÞ¸Ä£©
	 */
	public int findMinCost(String A, int n, String B, int m, 
			int c0, int c1, int c2) {
        
		int[][] dp = new int[n+1][m+1];
		
		dp[0][0] = 0;
		for(int i=1;i<=n;i++) {
			dp[i][0] = i*c1;
		}
		for(int i=1;i<=m;i++) {
			dp[0][i] = i*c0;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(A.charAt(i-1)==B.charAt(j-1))
					dp[i][j] = Math.min(Math.min(dp[i-1][j-1], c0+dp[i][j-1]),
							c1+dp[i-1][j]);
				else
					dp[i][j] = Math.min(Math.min(c0+dp[i][j-1],
							c1+dp[i-1][j]),c2+dp[i-1][j-1]);
				
			}
		}
		return dp[n][m];
    }
}
