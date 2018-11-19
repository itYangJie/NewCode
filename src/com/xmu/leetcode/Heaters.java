package com.xmu.leetcode;

import java.util.TreeSet;

public class Heaters {
	public static void main(String[] args) {
		int[] nums = new int[] {4,14,2};
		int n = nums.length;

		int[] count0 = new int[32];
		int[] count1 = new int[32];

		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (((nums[j] >> i) & 1) == 1)
					count++;
			}
			count1[i] = count;
			count0[i] = n - count;
		}

		int res = 0;
		for (int i = 0; i < 32; i++) {
			res += (count0[i] * count1[i]);
		}
	}

	public int findRadius(int[] houses, int[] heaters) {

		TreeSet<Integer> set = new TreeSet<>();
		for (int i = heaters.length - 1; i >= 0; i--)
			set.add(heaters[i]);

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < houses.length; i++) {
			int x = houses[i];
			Integer high = set.ceiling(x);
			Integer low = set.floor(x - 1);
			if (high == null)
				res = Math.max(res, Math.abs(low - x));
			else if (low == null)
				res = Math.max(res, Math.abs(high - x));
			else
				res = Math.max(res, Math.min(Math.abs(low - x), Math.abs(high - x)));
		}
		return res;
	}
}
