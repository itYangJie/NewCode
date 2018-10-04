package com.xmu.interviewgold;

public class ClosestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getNum(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}

	public int[] getCloseNumber(int x) {
		// write code here
		int[] arr = new int[2];
		int num = getNum(x);
		int i;
		for (i = x - 1; getNum(i) != num; i--)
			;
		arr[0] = i;
		for (i = x + 1; getNum(i) != num; i++)
			;
		arr[1] = i;
		return arr;
	}
}
