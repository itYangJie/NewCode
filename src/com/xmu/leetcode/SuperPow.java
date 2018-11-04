package com.xmu.leetcode;

public class SuperPow {
	
	int base = 1337;
	public int superPow(int a, int[] b) {
		
		return solve(a,b,b.length-1);
	}
	private int solve(int a, int[] b, int ind) {
		if(ind==0)
			return cacl(a,b[ind]);
		return ((cacl(solve(a,b,ind-1),10)%base)*(cacl(a,b[ind])))%base;
	}
	private int cacl(int a, int i) {
		if(i==0)
			return 1;
		int res = a%base;
		for(int j=1;j<i;j++) {
			res = (res*(a%base))%base;
		}
		return res;
	}
}
