package com.xmu.xz2017;

import java.util.Scanner;

public class DarkString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n==1) {
			System.out.println(3);
			return;
		}
		if(n==2) {
			System.out.println(9);
			return;
		}
		long dp[] = new long[n];
		dp[0] = 3;
		dp[1] = 9;
		for(int i=2;i<n;i++)
			dp[i] = 2*dp[i-1]+dp[i-2];
		System.out.println(dp[n-1]);
	}

}
