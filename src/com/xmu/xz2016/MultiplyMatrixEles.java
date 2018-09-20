package com.xmu.xz2016;

import java.util.Scanner;

public class MultiplyMatrixEles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt(),m = in.nextInt();
			int[][] a = new int[n][m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					a[i][j] = in.nextInt();
			long multiByLandscape[] = new long[n];
			for(int i=0;i<n;i++) {
				long temp = 1;
				for(int j=0;j<m;j++)
					temp *= a[i][j];
				multiByLandscape[i] = temp;
			}
			
			long multiByPortrait[] = new long[m];
			for(int j=0;j<m;j++) {
				long temp = 1;
				for(int i=0;i<n;i++)
					temp *= a[i][j];
				multiByPortrait[j] = temp;
			}
			
			long max = Long.MIN_VALUE;
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					max = Math.max(max, multiByLandscape[i]*multiByPortrait[j]/a[i][j]/a[i][j]);
			System.out.println(max);
		}
	}

}
