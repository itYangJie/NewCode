package com.xmu.leetcode;

public class ShortestPalindrome {
	
	public String shortestPalindrome(String s) {
		if(s.length()==1)
			return s;
		StringBuffer sb = new StringBuffer();
		int len = s.length();
		for(;len>=1;len--) {
			if(isPalindrome(s,len)) {
				break;
			}
			sb.append(s.charAt(len-1));
		}
		sb.append(s);
		return sb.toString();
	}

	private boolean isPalindrome(String s,int len) {
		for(int i=0;i<len/2;i++) {
			if(s.charAt(i)!=s.charAt(len-1-i))
				return false;
		}
		return true;
	}
}
