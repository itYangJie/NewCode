package com.xmu.xz2017;

import java.util.Scanner;

public class DivideField {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),m = in.nextInt();
		int[][] field = new int[n][m];
		for(int i=0;i<n;i++) 
			for(int j=0;j<m;j++) 
				field[i][j] = in.nextInt();
		
	}

}
