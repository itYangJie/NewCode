package com.xmu.xz2016;

import java.util.Arrays;
import java.util.Stack;

public class BuildMaxTree {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				new BuildMaxTree().buildMaxTree(new int[] {3, 1,4,2},4)));
	}
	/**
	 *   ‰»Î£∫[3,1,4,2],4
		∑µªÿ£∫[2,0,-1,2]
	 * @param A
	 * @param n
	 * @return
	 */
	public int[] buildMaxTree(int[] A, int n) {
		Stack<Integer> stack = new Stack<>();
		int[] left = new int[n];
		for(int i=0;i<n;i++) {
			while(!stack.isEmpty() && A[i]>=A[stack.peek()])
				stack.pop();
			int ind = -1;
			if(!stack.isEmpty())
				ind = stack.peek();
			left[i] = ind;
			stack.push(i);
		}
       
		stack.clear();
		int[] right = new int[n];
		for(int i=n-1;i>=0;i--) {
			while(!stack.isEmpty() && A[i]>=A[stack.peek()])
				stack.pop();
			int ind = n;
			if(!stack.isEmpty())
				ind = stack.peek();
			right[i] = ind;
			stack.push(i);
		}
		
		int[] res = new int[n];
		for(int i=0;i<n;i++) {
			if(left[i]==-1 && right[i]==n)
				res[i] = -1;
			else if(left[i]==-1) {
				res[i] = right[i];
			}else if(right[i]==n) {
				res[i] = left[i];
			}else {
				res[i] = ((A[left[i]]<A[right[i]])?left[i]:right[i]);
			}
		}
		return res;
    }
}
