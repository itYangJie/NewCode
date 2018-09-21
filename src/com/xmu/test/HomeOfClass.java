package com.xmu.test;

import java.util.Arrays;

public class HomeOfClass {

	public static void main(String[] args) {
		System.out.println(miHomeGiftBag(new int[] {99},992));
	}
	
	public static boolean miHomeGiftBag(int[] p,int M) {
		Arrays.sort(p);
		return dfs(p,M,p.length-1,0);
	}

	private static boolean dfs(int[] p, int need, int ind, int curSum) {
		if(curSum==need)
			return true;
		if(curSum>need)
			return false;
		for(int i=ind;i>=0;i--) {
			if(dfs(p,need,i-1,curSum+p[i]))
				return true;
		}
		return false;
	}
}
