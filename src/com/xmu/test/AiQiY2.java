package com.xmu.test;

import java.util.Arrays;
import java.util.Scanner;

public class AiQiY2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int a[] = new int[n];
			int max = Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				a[i] = in.nextInt();
				max = Math.max(max, a[i]);
			}
			int res = solve(a,n,m,max);
			System.out.println(res);
		}

	}
	private static int  solve(int[] a, int n, int m,int max) {
		Arrays.sort(a);
		
		int low = 1;
		int high = max;
		while(low<high-1) {
			int mid = (low+high)/2;
			if(cacl(a,n,mid,m))
				low = mid;
			else
				high = mid-1;
		}
		if(cacl(a,n,high,m))
			return high;
		else
			return low;
	}

	private static boolean cacl(int[] a, int n, int juHigh,int m) {
		int sum = 0;
		for(int i=n-1;i>=0;i--) {
			if(a[i]<=juHigh)
				break;
			sum+=(a[i]-juHigh);
			if(sum>=m)
				return true;
		}
		return false;
	}

}
