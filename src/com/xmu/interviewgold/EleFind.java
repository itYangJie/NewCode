package com.xmu.interviewgold;

public class EleFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findElement(int[] A, int n, int x) {

		int i = 0, j = n - 1, mid;
		while (i <= j) {
			mid = (i + j) / 2;
			if (A[mid] == x)
				return mid;
			if (A[mid] < x) {
				if (A[mid] < A[i] && x > A[j])
					j = mid - 1;
				else
					i = mid + 1;
			} else {
				if (A[mid] > A[i] && x < A[i])
					i = mid + 1;
				else
					j = mid - 1;
			}
		}
		return -1;
	}

	public int findString(String[] str, int n, String x) {
		int l = 0, r = n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (str[mid].equals(x))
				return mid;
			if ("".equals(str[mid])) {
				if (str[l].equals(x))
					return l;
				else
					l++;
			} else {
				if (str[mid].compareTo(x) > 0)
					r = mid - 1;
				else
					l = mid + 1;
			}
		}
		return -1;
	}

	public int[] findElementInMat(int[][] mat, int n, 
			int m, int x) {
		int i = n-1,j = 0;
		while(mat[i][j]!=x) {
			if(mat[i][j]>x)
				i--;
			else
				j++;
		}
		return new int[] {i,j};
	}
}
