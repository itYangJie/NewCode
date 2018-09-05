package com.xmu.xz2017;

import java.util.Scanner;

public class PieceOfDenomination {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long[] dp = new long[N+1];
		dp[0] = 1;
		char a[]={1,5,10,20,50,100};
		for(int i=0;i<6;i++)
	        for(int j=1;j<=N;j++)
	            if(j>=a[i])
	                dp[j]=dp[j]+dp[j-a[i]];
		System.out.println(dp[N]);
	}

}
