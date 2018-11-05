package com.xmu.leetcode;

public class IncreasingTripletSubsequence {
	
	public boolean increasingTriplet(int[] nums) {
		if(nums.length<3)
			return false;
		//[1,2,3,4,5]
		int len = nums.length;
		int[] rightMax = new int [len];
		int[] leftMin = new int[len];
		
		leftMin[1] = nums[0];
		for(int i=2;i<len;i++)
			leftMin[i] = Math.min(leftMin[i-1], nums[i-1]);
		
		rightMax[len-2] = nums[len-1];
		for(int i=len-3;i>=0;i--)
			rightMax[i] = Math.max(rightMax[i+1], nums[i+1]);
		
		for(int i=1;i<len-1;i++) {
			if(nums[i]>leftMin[i] && nums[i]<rightMax[i])
				return true;
		}
		return false;
	}
}
