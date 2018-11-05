package com.xmu.leetcode;

public class SegEqualSumSubset {
	public static void main(String[] args) {
		canPartition(new int[] {1,5,11,3});
	}
	public static boolean canPartition(int[] nums) {
		int len = nums.length;
		int sum[] = new int[len];

		sum[0] = nums[0];
		for (int i = 1; i < len; i++)
			sum[i] = sum[i - 1] + nums[i];

		if (sum[len - 1] % 2 == 1)
			return false;

		boolean[] dp = new boolean[sum[len - 1] + 1];
		dp[0] = true;
		// dp[nums[0]] = true;
		for (int i = 0; i < len; i++) {
			boolean [] temp = new boolean[sum[i]+1];
			for (int j = nums[i]; j <= sum[i]; j++) {
				if (dp[j - nums[i]])
					temp[j] = true;
			}
			for(int j=0;j<temp.length;j++)
				if(temp[j])
					dp[j] = true;
		}
		return dp[sum[len - 1] / 2];
	}
}
