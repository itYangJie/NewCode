package com.xmu.xz2017;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ContinuousMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] num = new int[n];
		for(int i=0;i<n;i++)
			num[i] = in.nextInt();
		int[] dp = new int[n];
		dp[0] = num[0];
		int max = dp[0];
		for(int i=1;i<n;i++) {
			dp[i] = Math.max(dp[i-1], 0)+num[i];
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
