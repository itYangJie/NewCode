package com.xmu.leetcode;

public class LongestRepeatingCharReplace {
	public static void main(String[] args) {
		characterReplacement("AABABBA", 1);
	}

	public static int characterReplacement(String s, int k) {

		int max = 0, start = 0, end = 0, max_cur = 0;
		int[] count = new int[26];
		while (end < s.length()) {
			max_cur = Math.max(max_cur, ++count[s.charAt(end) - 'A']);
			while (end - start + 1 - max_cur > k)
				count[s.charAt(start++) - 'A']--;
			max = Math.max(max, end - start + 1);
			end++;
		}
		return max;

	}
}
