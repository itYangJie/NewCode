package com.xmu.xz2017;
import java.util.Scanner;

public class Choir {

	public static void main(String[] args) {
		// Input data
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ai = new int[n];
		
		for(int i=0;i<n;i++) {
			ai[i] = in.nextInt();
		}
		int k = in.nextInt();
		int d = in.nextInt();
		
		long[][] dp = new long[n][k];
		long[][] dp2 = new long[n][k];
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++) {
				dp[i][j] = Long.MIN_VALUE;
				dp2[i][j] = Long.MAX_VALUE;
			}
		}
		for(int i=0;i<n;i++) {
			dp[i][0] = ai[i];
			dp2[i][0] = ai[i];
		}
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<k&&j<=i;j++) {
				long max = Long.MIN_VALUE;
				long min = Long.MAX_VALUE;
				for(int m=i-1; m>=0&&i-m<=d&&j-1<=m; m--) {
					max = Math.max(max, dp[m][j-1]);
					min = Math.min(min, dp2[m][j-1]);
				}
				if (ai[i]>0) {
					dp[i][j] = max*ai[i];
					dp2[i][j] = min*ai[i];
				}
				else {
					dp[i][j] = min*ai[i];
					dp2[i][j] = max*ai[i];
				}
			}
		}
		long max = Long.MIN_VALUE;
		for(int i=0;i<n;i++) {
			max = Math.max(max, dp[i][k-1]);
		}
		System.out.println(max);
	}

}
