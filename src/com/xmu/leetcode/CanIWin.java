package com.xmu.leetcode;

import java.util.TreeSet;

public class CanIWin {
	public static void main(String[] args) {
		canIWin(18, 79);
	}
	/*public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
			return false;
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=1;i<=maxChoosableInteger;i++)
			set.add(i);
		
		int curInd = 0;
		boolean canWin = false;
		int curSum = 0;
		for(;curInd<maxChoosableInteger;curInd++) {
			if(set.ceiling(desiredTotal-curSum)!=null) {
				canWin = true;
				break;
			}
			Integer max = set.descendingIterator().next();
			Integer choice = set.floor(desiredTotal-curSum-max-1);
			if(choice==null) {
				canWin = false;
				break;
			}
			set.remove(choice);
			curSum += choice;
		}
		return (curInd % 2==0 && canWin) || (curInd % 2==1 && !canWin);
	}*/
	public static boolean canIWin(int n, int target) {
		if (n * (n + 1) / 2 < target)
			return false;
		// 4 xxxx
		int[] dp = new int[1<<n];
		return target<2?true:dfs(dp,n,target,0);
	}
	private static boolean dfs(int[] dp, int n,int target, int state) {
		if(target<=0)
			return false;
		if(dp[state]!=0)
			return dp[state]==1;
		for(int i=1;i<=n;i++) {
			if((state &(1<<(i-1)))==0 && !dfs(dp,n,target-i,(state | (1<<(i-1))))) {
				dp[state] = 1;
				return true;
			}
		}
		dp[state]=-1;
		return false;
	}
}
