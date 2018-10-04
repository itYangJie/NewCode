package com.xmu.interviewgold;

public class Nqueens {

	public int nQueens(int n) {
		if (n < 0)
			return 0;
		// write code here
		int[] record = new int[n];
		return process(0, record, n);

	}
	private int process(int i, int[] record, int n) {
		if (i == n)
			return 1;
		int res = 0;
		for (int j = 0; j < n; j++) {
			if (isValid(record, i, j)) {
				record[i] = j;
				res += process(i + 1, record, n);
			}
		}
		return res;
	}

	private boolean isValid(int[] record, int i, int j) {
		for (int k = 0; k < i; k++) {
			// 若在同一列或者对角线则返回false
			if (j == record[k] || Math.abs(record[k] - j) == Math.abs(k - i))
				return false;
		}
		return true;
	}
}
