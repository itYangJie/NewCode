package com.xmu.xz2016;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(new Fibonacci().getNthNumber(4));
	}

	//
	public int getNthNumber(int n) {
		long[][] base = { { 1, 1 }, { 1, 0 } };
		long[][] ret = { { 1, 0 }, { 0, 1 } };
		
		for(int i=0;i<=31;i++) {
			if(((n>>i)&1)==1) {
				MultMetri(ret,base);
			}
			MultMetri(base, base);
		}
		return (int) ret[0][0];
	}

	public static long[][] MultMetri(long[][] ret, long[][] base) {
		long[][] tmp = new long[2][2];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				tmp[i][j] = (ret[i][0] * base[0][j] + ret[i][1] * base[1][j]) % 1000000007;
		for (int k = 0; k < 2; k++)
			for (int q = 0; q < 2; q++)
				ret[k][q] = tmp[k][q];
		return ret;
	}
}
