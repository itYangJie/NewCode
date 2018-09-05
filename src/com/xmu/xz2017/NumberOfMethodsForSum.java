package com.xmu.xz2017;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfMethodsForSum {
	
	/*private static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = in.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++)
			A[i] = in.nextInt();
		
		Arrays.sort(A);
		
		dfs(A,0,0,sum);
		System.out.println(count);
	}
	private static void dfs(int[] A, int index, int curSum,int sum) {
		if(curSum>sum)
			return;
		if(curSum==sum) {
			count++;
			return;
		}
		if(index>=A.length)
			return;
		for(int i=index;i<A.length;i++) {
			if(curSum+A[i]>sum)
				break;
			dfs(A,i+1,curSum+A[i],sum);
		}
		
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = in.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++)
			A[i] = in.nextInt();
		
		long dp[][] = new long[n][sum+1];
		for(int i=0;i<n;i++) { 
			dp[i][0] = 1;
			for(int j=1;j<=sum;j++)
				dp[i][j] = 0;
		}
		if(A[0]>=1 && A[0]<=sum)
			dp[0][A[0]] = 1;
		for(int i=1;i<n;i++)
			for(int j=1;j<=sum;j++) {
				if(j-A[i]>=0)
					dp[i][j] = dp[i-1][j]+dp[i-1][j-A[i]];
				else
					dp[i][j] = dp[i-1][j];
			}
		System.out.println(dp[n-1][sum]);
	}
}
