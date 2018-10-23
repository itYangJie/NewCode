package com.xmu.xz2016;

public class FindKNum {

	public int findKthNum(int[] arr1, int[] arr2, int kth) {
		return getkth(arr1, 0, arr2, 0, kth);
	}

	public int getkth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart > A.length - 1)
			return B[bStart + k - 1];
		if (bStart > B.length - 1)
			return A[aStart + k - 1];
		if (k == 1)
			return Math.min(A[aStart], B[bStart]);

		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (aStart + k / 2 - 1 < A.length)
			aMid = A[aStart + k / 2 - 1];
		if (bStart + k / 2 - 1 < B.length)
			bMid = B[bStart + k / 2 - 1];

		if (aMid < bMid)
			return getkth(A, aStart + k / 2, B, bStart, k - k / 2);
		else
			return getkth(A, aStart, B, bStart + k / 2, k - k / 2);
	}
}
