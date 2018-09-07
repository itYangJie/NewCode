package com.xmu.xz2017;

import java.util.Scanner;

public class GemstoneNecklace {
	
	public static int dict(char c) {
		switch(c){
	        case 'A': return 1;
	        case 'B': return 0b10;
	        case 'C': return 0b100;
	        case 'D': return 0b1000;
	        case 'E': return 0b10000;
	        default: return 0;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String str = in.nextLine();
			System.out.println(solve(str));
		}
	}
	private static int solve(String str) {
		int len = str.length();
		int[][] dp = new int[len][len];
		for(int i=0;i<len;i++)
			dp[i][0] = dict(str.charAt(i));
		for(int j=1;j<len;j++) {
			for(int i=0;i<len;i++) {
				dp[i][j] = (dp[i][j-1]|dp[(i+j)%len][0]);
				if(dp[i][j]==0b11111) {
					return len-j-1;
				}
			}
		}
		return 0;
	}

}
