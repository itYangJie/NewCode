package com.xmu.leetcode;

public class LongestAbsoluteFilePath {
	// "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
	// "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
	public int lengthLongestPath(String input) {
		String[] paths = input.split("\n");
		int[] stack = new int[paths.length + 1];
		int maxLen = 0;

		for (String s : paths) {
			int lev = s.lastIndexOf("\t") + 1;
			int curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
			if (s.contains("."))
				maxLen = Math.max(maxLen, curLen - 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";

	}
}
