package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountSmallerNumbersAfterSelf {
	public static void main(String[] args) {
		new CountSmallerNumbersAfterSelf().countSmaller(new int[] {5});
	}
	public List<Integer> countSmaller(int[] nums) {
		if(nums.length==0)
			return new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		
		int n = nums.length;
		int dp[] = new int[n];
		dp[n-1] = 0;
		
		s.push(n-1);
		for(int i=n-2;i>=0;i--) {
			
			while(!s.isEmpty() && nums[s.peek()]>=nums[i])
				s.pop();
			int ind = n;
			if(!s.isEmpty())
				ind = s.peek();
			
			s.push(i);
			
			if(ind==n)
				dp[i] = 0;
			else
				dp[i] = 1+dp[ind];
		}
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<dp.length;i++)
			res.add(dp[i]);
		return res;
	}
}
