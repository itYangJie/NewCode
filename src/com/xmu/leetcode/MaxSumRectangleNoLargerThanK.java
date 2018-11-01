package com.xmu.leetcode;

import java.util.TreeSet;

public class MaxSumRectangleNoLargerThanK {

	public int maxSumSubmatrix(int[][] matrix, int k) {
		int raw = matrix.length;
		int col = matrix[0].length;

		return help(matrix, raw, col, k);

	}

	private int help(int[][] matrix, int raw, int col, int k) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < raw; i++) {
			int[] temp = new int[col];
			for (int j = i; j < raw; j++) {
				for (int m = 0; m < col; m++)
					temp[m] += matrix[j][m];
				max = Math.max(max, find(temp, k));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new MaxSumRectangleNoLargerThanK().maxSumSubmatrix(new int[][] { { 2, 2, -1 } }, 0));
	}

	private int find(int[] sum, int k) {
		int result = Integer.MIN_VALUE;
		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);
		int current = 0;
		for (int i = 0; i < sum.length; i++) {
			current += sum[i];

			Integer target = set.ceiling(current - k);

			if (target != null) {
				result = Math.max(result, current - target);
			}
			set.add(current);
		}

		return result;
	}
}
