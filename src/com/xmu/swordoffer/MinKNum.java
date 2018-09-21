package com.xmu.swordoffer;

import java.util.ArrayList;
import java.util.Collections;

public class MinKNum {

	public static void main(String[] args) {
		GetLeastNumbers_Solution(new int[] {1,5,2,6}, 4);

	}

	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input,
			int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if(k>input.length || k<=0)
			return res;
		solve(input, 0, input.length-1, k);
		for(int i=0;i<k;i++)
			res.add(input[i]);
		Collections.sort(res);
		return res;
	}

	private static void solve(int[] nums, int left, int right,int k) {

		int ind = partration(nums, left, right);
		if(ind==k-1)
			return;
		if(ind>k-1)
			solve(nums, left, ind-1, k);
		else
			solve(nums, ind+1, right, k);
	}

	private static int partration(int[] nums, int left, int right) {
		int mainEle = nums[left];
		while (left < right) {
			while (left < right && nums[right] > mainEle)
				right--;
			nums[left] = nums[right];
			while (left < right && nums[left] <= mainEle)
				left++;
			nums[right] = nums[left];
		}
		nums[right] = mainEle;
		return right;
	}
}
