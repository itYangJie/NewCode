package com.xmu.leetcode;

public class WildcardMatching {
	public static void main(String[] args) {
		System.out.println(isMatch2("cd","?a"));
	}
	public static boolean isMatch(String s, String p) {
		int ns = s.length();
		int np = p.length();
		if(ns==0 && np==0)
			return true;
		if(np==0)
			return false;
		
		int indS = 0,indP = 0;
		while(indS<ns && indP<np) {
			if(p.charAt(indP)=='*') {
				return isMatch(s.substring(indS), p.substring(indP+1))||isMatch(s.substring(indS+1), p.substring(indP));
			}else {
				if(p.charAt(indP)!=s.charAt(indS) && p.charAt(indP)!='?')
					return false;
			}
			indS++;
			indP++;
		}
		if((indS>=ns && indP>=np))
			return true;
		if(indS<ns)
			return false;
		for(;indP<np;indP++) {
			if(p.charAt(indP)!='*')
				return false;
		}
		return true;
	}
	public static boolean isMatch2(String s, String p) {
		int ns = s.length();
		int np = p.length();
		
		boolean [][] dp = new boolean[ns+1][np+1];
		dp[0][0] = true;
		for(int i=1;i<=ns;i++)
			dp[i][0] = false;
		
		for(int j=1;j<=np;j++) {
			if(p.charAt(j-1)!='*')
				dp[0][j] = false;
			else
				dp[0][j] = dp[0][j-1];
		}
		
		for(int i=1;i<=ns;i++) {
			for(int j=1;j<=np;j++) {
				if(p.charAt(j-1)!='*') {
					if(p.charAt(j-1)=='?')
						dp[i][j] = dp[i-1][j-1];
					else
						dp[i][j] = (p.charAt(j-1)!=s.charAt(i-1)?false:dp[i-1][j-1]);
				}else {
					dp[i][j] = dp[i][j-1] || dp[i-1][j];
				}
			}
		}
		return dp[ns][np];
	}
}
