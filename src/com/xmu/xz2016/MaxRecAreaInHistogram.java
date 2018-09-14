package com.xmu.xz2016;

import java.util.Stack;

public class MaxRecAreaInHistogram {

	public static void main(String[] args) {
		int[] A = new int[] {2,7,9,4,1};
		System.out.println(countArea(A, A.length));
	}
	public static int countArea(int[] A, int n) {
		if(n==1)
			return A[0];
		
		int[] left = new int[n];
		int[] right = new int[n];
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<n;i++) {
			while(!s.isEmpty() && A[i]<=A[s.peek()])
				s.pop();
			int ind=-1;
			if(!s.isEmpty())
				ind = s.peek();
			left[i] = ind;
			s.push(i);
		}
		s.clear();
		for(int i=n-1;i>=0;i--) {
			while(!s.isEmpty() && A[i]<=A[s.peek()])
				s.pop();
			int ind=n;
			if(!s.isEmpty())
				ind = s.peek();
			right[i] = ind;
			s.push(i);
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			max = Math.max(max, A[i]*(right[i]-left[i]-1));
		}
		return max;
    }
}
