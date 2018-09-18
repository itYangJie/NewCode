package com.xmu.xz2016;

import java.util.Scanner;

public class CriminalTransfer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int t = in.nextInt();
		int c = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i] = in.nextInt();
		int count = 0;
		int sum = 0;
		for(int i=0;i<c;i++)
			sum += a[i];
		if(sum<=t)
			count++;
		for(int ind = c;ind<n;ind++) {
			sum = sum+a[ind]-a[ind-c];
			if(sum<=t)
				count++;
		}
		System.out.println(count);
	}
	

}
