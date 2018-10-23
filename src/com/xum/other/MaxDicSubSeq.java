package com.xum.other;

import java.util.Scanner;

public class MaxDicSubSeq {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		//test
		int n = s.length();
		int dp[] = new int[n];
		
		dp[n-1] = n-1;
		for(int i=n-2;i>=0;i--) {
			if(s.charAt(i)>=s.charAt(dp[i+1])) {
				dp[i] = i;
			}else
				dp[i] = dp[i+1];
		}
		int ind = 0;
		StringBuffer sb = new StringBuffer();
		while(ind<n) {
			ind = dp[ind];
			sb.append(s.charAt(ind));
			ind++;
		}
		System.out.println(sb.toString());
	}

}
