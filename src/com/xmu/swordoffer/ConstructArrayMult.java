package com.xmu.swordoffer;

public class ConstructArrayMult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] multiply(int[] A) {
		int len = A.length;
		int[] leftMult = new int[len];
		int[] rightMult = new int[len];
		leftMult[0] = A[0];
		for (int i = 1; i < len; i++) {
			leftMult[i] = leftMult[i - 1] * A[i];
		}

		rightMult[len - 1] = A[len - 1];
		for (int i = len - 2; i >= 0; i--)
			rightMult[i] = rightMult[i + 1] * A[i];

		int[] B = new int[len];
		B[0] = rightMult[1];
		B[len - 1] = leftMult[len - 2];
		for (int i = 1; i < len - 1; i++)
			B[i] = leftMult[i - 1] * rightMult[i + 1];
		return B;
	}
}
