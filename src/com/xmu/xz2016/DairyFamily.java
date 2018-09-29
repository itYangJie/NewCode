package com.xmu.xz2016;

public class DairyFamily {

	public static void main(String[] args) {
		System.out.println(new DairyFamily().countSum(6));
	}

/*	public int countSum(int n) {
		if (n <= 3)
			return n;

		int[][] res = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		int[][] cur = new int[][] { { 1, 0, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };

		n = n - 3;
		for (int i = 0; i <= 31; i++) {
			if (((n >> i) & 1) == 1) {
				mult(res, cur);
			}
			mult(cur, cur);
		}
		return ((3 * res[0][0] % 1000000007) + (2 * res[0][1] % 1000000007) + (res[0][2] % 1000000007)) % 1000000007;
	}

	private void mult(int[][] mat1, int[][] mat2) {
		int[][] temp = new int[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				temp[i][j] = ((mat1[i][0] * mat2[0][j] % 1000000007) + (mat1[i][1] * mat2[1][j] % 1000000007)
						+ (mat1[i][2] * mat2[2][j] % 1000000007)) % 1000000007;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				mat1[i][j] = temp[i][j];
	}*/

	public int countSum(int n) {
		if (n < 4)
			return n;
		long[][] res = new long[][] { { 3, 2, 1 } };
		long[][] base = new long[][] { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		n -= 3;
		while (n > 0) {
			if ((n & 1) > 0) {
				res = multiply(res, base);
			}
			base = multiply(base, base);
			n = n >> 1;
		}
		return (int) res[0][0] % 1000000007;
	}

	public long[][] multiply(long[][] a, long[][] b) {
		int L1 = a.length;
		int L2 = a[0].length;
		int L3 = b[0].length;
		long[][] res = new long[L1][L3];
		for (int i = 0; i < L1; i++)
			for (int j = 0; j < L3; j++)
				for (int k = 0; k < L2; k++) {
					res[i][j] += a[i][k] * b[k][j] % 1000000007;
					res[i][j] %= 1000000007;
				}
		return res;
	}
}
