package com.xmu.xz2017;

import java.util.Scanner;

public class JumpRiver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] jumps = new int[N];
		int[] dp = new int[N];
		for(int i=0;i<N;i++) {
			jumps[i] = in.nextInt();
			dp[i] = -1;
		}
		if(jumps[N-1]!=0)
			dp[N-1] = 1;
		for(int i=N-2;i>=0;i--) {
			if(jumps[i]==0)
				continue;
			int min = Integer.MAX_VALUE;
			for(int j=jumps[i];j>=1;j--) {
				if(i+j>=N) {
					min = 1;
					break;
				}
				if(dp[i+j]!=-1)
					min = Math.min(min, 1+dp[i+j]);
			}
			if(min!=Integer.MAX_VALUE)
				dp[i] = min;
		}
		System.out.print(dp[0]);
	}

}
