package com.xmu.interviewgold;

import java.util.Stack;

public class NextBiggerNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findNext(int[] A, int n) {

		int res[] = new int[n];
		Stack<Integer> s = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			int ind = -1;
			while (!s.isEmpty() && A[i] >= A[s.peek()])
				s.pop();
			if (!s.isEmpty())
				ind = s.peek();
			if (ind == -1)
				res[i] = -1;
			else
				res[i] = A[ind];
			s.push(i);
		}
		return res;
	}

	public int[] findNext2(int[] A, int n) {

		int res[] = new int[n];
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			int ind = -1;
			while (!s1.isEmpty() && A[i] >= A[s1.peek()])
				s2.push(s1.pop());
			if (!s1.isEmpty())
				ind = s1.peek();
			if (ind == -1)
				res[i] = -1;
			else
				res[i] = A[ind];
			s1.push(i);
			while (!s2.empty()) {
				s1.push(s2.pop());
			}
		}
		return res;
	}
}
