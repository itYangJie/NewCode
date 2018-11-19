package com.xmu.leetcode;

import java.util.TreeSet;

public class OneThreeTwoPattern {
	public boolean find132pattern(int[] nums) {
		int n = nums.length;
		if(n<3)
			return false;
		
		int leftMin[] = new int[n];
		leftMin[0] = Integer.MAX_VALUE;
		
		for(int i=1;i<n;i++) {
			leftMin[i] = Math.min(leftMin[i-1], nums[i-1]);
		}
		TreeSet<Integer> set = new TreeSet<>();
		set.add(nums[n-1]);
		for(int i=n-2;i>0;i--) {
			int left = leftMin[i];
			if(nums[i]<=left) {
				set.add(nums[i]);
				continue;
			}
			Integer ceiling = set.floor(nums[i]-1);
			if(ceiling!=null && ceiling>left)
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
