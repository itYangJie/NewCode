package com.xmu.xz2016;

import java.util.Arrays;

public class Stones {
	// 65 7 40
	// 7 12 4 15
	public static int[] result(int A, int B, int n, int[] e, int[] a) {
        if(n==1)
        	return new int[] {a[0]};
		int f[][] = new int[n][101];
		int s[][] = new int[n][101];
		
		for(int i=0;i<101;i++) {
			f[n-1][i] = a[n-1];
			s[n-1][i] = 0;
		}
		f[n-1][0]=a[n-1];
		f[n-2][0]=a[n-2];
		s[n-1][0]=0;
		s[n-2][0]=a[n-1];
		for(int i=n-3;i>=0;i--) {
			f[i][0] = a[i]+f[i+2][0];
			s[i][0] = a[i+1]+s[i+2][0];
		}
		
		for(int i=n-2;i>=0;i--) {
			for(int j=1;j<=100;j++) {
				f[i][j] = Math.max(s[i][j-1], s[i+1][j]+a[i]);
				s[i][j] = Math.min(f[i][j], f[i+1][j]);
			}
		}
		return new int[] {f[0][A],s[0][B]};
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(result(9,0,7,new int[] {66,2,6,2,8,4,3},
				new int[] {7,12,65,7,4,40,15})));
	}
}
