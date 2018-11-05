package com.xmu.leetcode;

public class IntBreak {
	public static void main(String[] args) {
		new IntBreak().integerBreak(10);
	}
	public int integerBreak(int n) {
		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j < i; j++) {
				max = Math.max(max, j * (i - j));
				max = Math.max(max, j * dp[i - j]);
			}
			dp[i] = max;
		}
		return dp[n];
	}
}
