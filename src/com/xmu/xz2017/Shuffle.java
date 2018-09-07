package com.xmu.xz2017;

import java.util.Scanner;

public class Shuffle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0;i<T;i++) {
			int n = in.nextInt(),k = in.nextInt();
			int[][] a = new int[2][2*n];
			for(int j=0;j<2*n;j++)
				a[0][j] = in.nextInt();
			for(int j=0;j<k;j++) {
				for(int m=0;m<n;m++)
					 a[(j+1)%2][2*m] = a[j%2][m];
				for(int m=n;m<2*n;m++)
					 a[(j+1)%2][2*(m-n)+1] = a[j%2][m];
			}
			for(int j=0;j<2*n-1;j++)
				System.out.print(a[k%2][j]+" ");
			System.out.print(a[k%2][2*n-1]);
			if(i<T-1)
				System.out.println();
		}
	}

}
