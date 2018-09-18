package com.xmu.xz2016;

import java.util.Scanner;

public class MushroomArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 0 0
		// 1 0
		while(in.hasNext()) {
			int n = in.nextInt(),m = in.nextInt(),k = in.nextInt();
			boolean isMushroom[][] = new boolean[n][m];
			for(int i=0;i<k;i++) {
				isMushroom[in.nextInt()-1][in.nextInt()-1]=true;
			}
			double dp[][] = new double[n][m];
			dp[0][0] = 1;
			for(int i=1;i<n;i++) {
				if(isMushroom[i][0])
					dp[i][0] = 0;
				else {
					if(1<m)
						dp[i][0] = 0.5*dp[i-1][0];
					else
						dp[i][0] = dp[i-1][0];
				}
			}
			for(int i=1;i<m;i++) {
				if(isMushroom[0][i])
					dp[0][i] = 0;
				else {
					if(1<n)
						dp[0][i] = 0.5*dp[0][i-1];
					else
						dp[0][i] = dp[0][i-1];
				}
			}
			for(int i=1;i<n;i++) {
				for(int j=1;j<m;j++) {
					if(isMushroom[i][j])
						dp[i][j] = 0;
					else {
						double p1,p2;
						if(i<n-1)
							p1=0.5;
						else
							p1=1.0;
						if(j<m-1)
							p2=0.5;
						else
							p2=1.0;
						dp[i][j] = p1*dp[i][j-1]+p2*dp[i-1][j];
					}
				}
			}
			System.out.printf("%.2f\n",dp[n-1][m-1]);
		}
	}

}
