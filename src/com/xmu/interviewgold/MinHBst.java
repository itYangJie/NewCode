package com.xmu.interviewgold;

public class MinHBst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int buildMinimalBST(int[] vals) {
		int len = vals.length;
		return solve(len);
	}

	public int solve(int len) {
		if (len == 0)
			return 0;
		if (len % 2 == 1)
			return 1 + solve(len / 2);
		else
			return 1 + Math.max(solve(len / 2), solve(len / 2 - 1));
	}
}
