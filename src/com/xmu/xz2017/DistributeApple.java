package com.xmu.xz2017;

import java.util.Scanner;

public class DistributeApple {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ai = new int[n];
		int numTotalApple = 0;
		for(int i=0; i<n; i++) {
			ai[i] = in.nextInt();
			numTotalApple += ai[i];
		}
		if(numTotalApple % n !=0) {
			System.out.println(-1);
			return ;
		}
		int numApplePerCow = numTotalApple/n;
		int times = 0;
		for(int i=0; i<n; i++) {
			int diff = Math.abs(ai[i]-numApplePerCow);
			if(diff%2!=0) {
				System.out.println(-1);
				return ;
			}
			times = times+ diff/2;
		}
		if(times%2!=0)
			System.out.println(-1);
		else
			System.out.println(times/2);
	}

}
