package com.xmu.test;

import java.util.Scanner;

public class MinValSegmentWeight {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] A = new int[n];

			for (int i = 0; i < n; i++)
				A[i] = in.nextInt();

			int[][] state = new int[n+1][m+1];
			int i = 0, j = 0, k = 0, temp = 0, MaxInt;
			state[0][1] = 0;
			for (i = 1; i <= n; ++i) {
				state[i][1] = state[i - 1][1] + A[i-1];
			}
			for (j = 2; j <= m; ++j) {
				for (i = j; i <= n; ++i) {
					temp = Integer.MAX_VALUE;
					for (k = j; k < i; ++k) {
						MaxInt = Math.max(state[i][1] - state[k][1], state[k][j - 1]);
						if (temp > MaxInt) {
							temp = MaxInt;
						}
					}
					state[i][j] = temp;
				}
			}
			System.out.println(state[n][m]);
		}
	}

}
