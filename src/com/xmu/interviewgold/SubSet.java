package com.xmu.interviewgold;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSet {

	public static void main(String[] args) {
		System.out.println(new SubSet().getSubsets2(new int[] {123,456,789}, 3));
	}

	public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		Arrays.sort(A);
		
		ArrayList<Integer> cache = new ArrayList<>();
		solve(A,res,cache,0,n);
		return res;
	}

	private void solve(int[] A, ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> cache, int ind, int n) {
		if(ind>=n)
			return;
		
		for(int i=ind;i<n;i++) {
			cache.add(A[i]);
			ArrayList<Integer> temp = new ArrayList<>();
			for(Integer num:cache)
				temp.add(num);
			res.add(temp);
			solve(A,res,cache,i+1,n);
			cache.remove(cache.size()-1);
		}
		
	}
	public ArrayList<ArrayList<Integer>> getSubsets2(int[] A, int n) {
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		Arrays.sort(A);
		
		int max = (int) (Math.pow(2,n)-1);
		for(int num=max;num>=1;num--) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i=n-1;i>=0;i--) {
				if(((num>>i)&1)==1)
					temp.add(A[i]);
			}
			res.add(temp);
		}
		return res;
	}
}
