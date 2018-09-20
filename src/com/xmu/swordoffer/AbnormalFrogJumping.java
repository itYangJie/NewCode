package com.xmu.swordoffer;

public class AbnormalFrogJumping {
	
	 public int JumpFloorII(int target) {
	     int[] dp = new int[target+1];
	     dp[0] = 1;
	     int sum = 0;
	     for(int i=1;i<=target;i++) {
	    	 sum = sum+dp[i-1];
	    	 dp[i] = sum;
	     }
	     return dp[target];
	 }
}
