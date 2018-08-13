package com.xmu.xz2017;

import java.util.Scanner;

public class JumpingSlab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		int[] dp = new int[M-N+1];
		for(int i=0;i<M-N+1;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		for(int num=N;num<=M;num++) {
			if(dp[num-N]==Integer.MAX_VALUE)
				continue;
			for(int j=2;j*j<=num;j++) {
				if(num%j ==0) {
					if(num+j<M+1)
						dp[num-N+j] = Math.min(dp[num-N+j], 1+dp[num-N]);
					if(num+num/j<M+1)
						dp[num-N+num/j] = Math.min(dp[num-N+num/j], 1+dp[num-N]);
				}
			}
		}
		if(dp[M-N]==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[M-N]);
	}

}
