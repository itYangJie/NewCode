package com.xmu.xz2016;

import java.util.Scanner;

public class Chat {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int p = in.nextInt(),q=in.nextInt();
			int l = in.nextInt(),r = in.nextInt();
			int[][] A = new int[p][2]; 
			int[][] B = new int[q][2]; 
			for(int i=0;i<p;i++) {
				A[i][0] = in.nextInt();
				A[i][1] = in.nextInt();
			}
			for(int i=0;i<q;i++) {
				B[i][0] = in.nextInt();
				B[i][1] = in.nextInt();
			}
			int res = 0;
			for(int t=l;t<=r;t++) {
				if(solve(A,B,p,q,t))
					res++;
			}
			System.out.println(res);
		}

	}

	private static boolean solve(int[][] A, int[][] B,int p,int q, int t) {
		int indA=0,indB=0;
		while(indA<p && indB<q) {
			if(B[indB][1]+t>=A[indA][0] && (B[indB][0]+t<=A[indA][1]))
					return true;
			if(B[indB][1]+t<A[indA][0])
				indB++;
			else
				indA++;
		}
		return false;
	}

}
