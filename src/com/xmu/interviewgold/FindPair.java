package com.xmu.interviewgold;

import java.util.Arrays;

public class FindPair {
	public int countPairs(int[] A, int n, int sum) {

		int size = A.length;
		if (size == 0 || n <= 0) {
			return 0;
		} // if
			// 排序
		Arrays.sort(A);
		//
		int count = 0;
		for (int i = 0, j = n - 1; i < j;) {
			int s = A[i] + A[j];
			if (s == sum) {
				// 3 3 3这种情况
				if (A[i] == A[j]) {
					int x = j - i + 1;
					count += x * (x - 1) / 2;
					break;
				} // if
					// 2 2 3 4 4 4这种情况
				else {
					int k = i + 1;
					while (k <= j && A[i] == A[k]) {
						++k;
					} // while
					int k2 = j - 1;
					while (k2 >= i && A[j] == A[k2]) {
						--k2;
					} // while
					count += (k - i) * (j - k2);
					i = k;
					j = k2;
				} // else
			} // if
			else if (s < sum) {
				++i;
			} // else
			else {
				--j;
			} // else
		} // for
		return count;
	}
}
