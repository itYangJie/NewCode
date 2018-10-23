package com.xmu.leetcode;

public class BestTimeBuySellStockIV {
	public int maxProfit(int k, int[] prices) {
		if(k==0 || prices.length==1)
			return 0;
		
		int day = prices.length;
		if(k>=day/2)
			return quickSolve(prices);
		int dp[][] = new int[k][day];
		
		int min = prices[0];
		for(int i=1;i<day;i++) {
			dp[0][i] = Math.max(dp[0][i-1], prices[i]-min);
			min = Math.min(min, prices[i]);
		}
		for(int i=1;i<k;i++) {
			int ttmp = -prices[0];
			for(int j=1;j<day;j++) {
				dp[i][j] = Math.max(dp[i][j-1], ttmp+prices[j]);
				ttmp = Math.max(ttmp, -prices[j]+dp[i-1][j-1]);
			}
		}
		return dp[k-1][day-1];
	}

	private int quickSolve(int[] prices) {
		int sum = 0;
		for(int i=0;i<prices.length-1;i++) {
			if(prices[i+1]>prices[i])
				sum += (prices[i+1]-prices[i]);
		}
		return sum;
	}
}
