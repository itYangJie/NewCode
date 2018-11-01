package com.xmu.leetcode;

import java.util.Random;

public class ShuffleArray {
	private int[] origin;
	private int[] shuffle;
	private Random r;

	public ShuffleArray(int[] nums) {
        origin = nums;
        shuffle = origin.clone();
        r = new Random();
    }

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return origin;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int n = shuffle.length;
		for (int i = 0; i < n; i++) {
			int ind = r.nextInt(n - i) + i;
			
			int temp = shuffle[i];
			shuffle[i] = shuffle[ind];
			shuffle[ind] = temp;
		}
		return shuffle;
	}
	public static void main(String[] args) {
		ShuffleArray sa = new ShuffleArray(new int[] {1,2,3});
		sa.shuffle();
		sa.reset();
		sa.shuffle();
	}
}
