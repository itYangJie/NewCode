package com.xmu.interviewgold;

public class MagicIndex {

	public boolean findMagicIndex1(int[] A, int n) {
		if (n < 1)
			return false;
		if (A[0] == 0)
			return true;
		int left = 0;
		int right = n - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (mid == A[mid])
				return true;
			if (mid > A[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return A[left] == left;
	}

	public boolean findMagicIndex2(int[] A, int n) {
		if (n < 1)
			return false;
		if (A[0] == 0)
			return true;
		return solve(A,0,n-1);
	}

	public  boolean solve(int[] A, int low, int high) {
		if (low > high) { // ˵��û���ҵ�ħ������������false
			return false;
		}
		int mid = (low + high + 1) / 2;
		if (A[mid] == mid) {
			return true;
		}
		// �������ж��п�����ħ������
		else {
			return solve(A, low, mid - 1) || solve(A, mid + 1, high);
		}
	}
}
