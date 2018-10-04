package com.xmu.interviewgold;

public class CoinExpress {

	public static void main(String[] args) {
		System.out.println(countWays(35837));
	}

	public static int countWays(int n) {
		int coins[] = new int[] {1,5,10,25};
		int[][] dp = new int[n+1][coins.length];
		//dp[i][j] = dp[i][j-1]+dp[i-coins[j]][j];
		for(int i=0;i<coins.length;i++)
			dp[0][i] = 1;
		for(int i=0;i<=n;i++)
			dp[i][0] = 1;
		for(int i=1;i<=n;i++)
			for(int j=1;j<coins.length;j++) {
				if(i-coins[j]>=0)
					dp[i][j] = (dp[i][j-1]+dp[i-coins[j]][j])%1000000007;
				else
					dp[i][j] = dp[i][j-1];
			}
		return dp[n][coins.length-1];
	}
}
