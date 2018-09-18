package com.xmu.xz2016;

import java.util.Scanner;

public class AvgAge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int W = in.nextInt();
		double Y = in.nextInt();
		double x = in.nextDouble();
		int N = in.nextInt();
		for(int i=1;i<=N;i++) {
			Y = (Y+1)*(1-x)+21*x;
		}
		System.out.println((int)Math.ceil(Y));
	}

}
