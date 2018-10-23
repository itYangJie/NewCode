package com.xmu.leetcode;

public class JumpGame2 {
	public int jump(int[] nums) {
		int n = nums.length;
		if(n==1)
			return 0;
		
		int [] dp = new int[n];
		dp[n-1] = 0;
		
		for(int i=n-2;i>=0;i--) {
			int steps = nums[i];
			int min = Integer.MAX_VALUE/2;
			for(int j=1;j<=steps&&i+j<n;j++) {
				min = Math.min(min, dp[i+j]);
			}
			dp[i] = 1+min;
		}
		return dp[0];
	}
}
