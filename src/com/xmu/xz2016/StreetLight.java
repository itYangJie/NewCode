package com.xmu.xz2016;

import java.util.Arrays;
import java.util.Scanner;

public class StreetLight {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt(),l = in.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = in.nextInt();
			Arrays.sort(arr);
			int d = Integer.MIN_VALUE;
			for(int i=1;i<n;i++)
				d = Math.max(d, arr[i]-arr[i-1]);
			double res = 1.0*d/2;
			res = Math.max(Math.max(res, arr[0]),l-arr[n-1]);
			System.out.printf("%.2f", res);
			System.out.println();
		}
		
	}

}
