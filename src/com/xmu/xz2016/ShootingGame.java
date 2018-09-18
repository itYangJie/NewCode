package com.xmu.xz2016;

import java.util.Scanner;

public class ShootingGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int p = in.nextInt(),n = in.nextInt();
			if(n==0) {
				System.out.println(-1);
				break;
			}
			int[] x = new int[n];
			for(int i=0;i<n;i++)
				x[i] = in.nextInt();
			boolean[] isVisited = new boolean[p];
			int ind = -1;
			for(int i=0;i<n;i++) {
				if(isVisited[x[i]%p]) {
					ind = i+1;
					break;
				}
				isVisited[x[i]%p] = true;
			}
			System.out.println(ind);
		}
	}

}
