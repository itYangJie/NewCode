package com.xmu.test;

import java.util.Scanner;

public class AiQiY1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			int[] dp = new int[n+1];
			
			int sum = 0;
			for(int i=1;i<=n;i++) {
				int temp = 1;
				for(int j=i-2;j>=1;j--) {
					temp += dp[j];
				}
				dp[i] = temp;
				sum += dp[i];
			}
			System.out.println(1+sum);
		}

	}
}
