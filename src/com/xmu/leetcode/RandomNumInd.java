package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class RandomNumInd {
	public static void main(String[] args) {
		RandomNumInd clf = new RandomNumInd(new int[] {1,4,3,1,2,4,3,3,5,4,7,-2});
		clf.pick(-2);
	}

	private HashMap<Integer, ArrayList<Integer>> map;
	private Random r;
	public RandomNumInd(int[] nums) {
		this.map = new HashMap<Integer,ArrayList<Integer>>();
		this.r = new Random();
		
		for(int i=nums.length-1;i>=0;i--) {
			if(!map.containsKey(nums[i]))
				map.put(nums[i], new ArrayList<>());
			map.get(nums[i]).add(i);
		}
	}

	public int pick(int target) {
		ArrayList<Integer> list = map.get(target);
		return list.get(r.nextInt(list.size()));
	}
	/*private int[] nums;
	private Random r;

	public RandomNumInd(int[] nums) {
		this.nums = nums;
		this.r = new Random();
		Arrays.sort(this.nums);
	}

	public int pick(int target) {
		int lowInd = findLowInd(nums, target);
		int highInd = findHighInd(nums, target);

		return lowInd + r.nextInt(highInd - lowInd + 1);
	}

	private int findLowInd(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] >= target)
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}

	private int findHighInd(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right + 1) / 2;
			if (nums[mid] <= target)
				left = mid;
			else
				right = mid - 1;
		}
		return left;
	}*/
}
