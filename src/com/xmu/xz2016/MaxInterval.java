package com.xmu.xz2016;

import java.util.Scanner;

public class MaxInterval {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i] = in.nextInt();
			int maxDiff = Integer.MIN_VALUE;
			for(int i=1;i<n;i++)
				maxDiff = Math.max(maxDiff, a[i]-a[i-1]);
			int res = Integer.MAX_VALUE;
			for(int i=1;i<n-1;i++) {
				res = Math.min(res, Math.max(maxDiff, a[i+1]-a[i-1]));
			}
			System.out.println(res);
		}
	}

}
