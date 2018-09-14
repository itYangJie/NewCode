package com.xmu.xz2016;

public class ChessboardFlip {

	public static void main(String[] args) {

	}
	public int[][] flipChess(int[][] A, int[][] f) {
		int n = f.length;
		for(int i=0;i<n;i++) {
			int x = f[i][0]-1,y = f[i][1]-1;
			if(x-1>=0) 
				A[x-1][y] = 1-A[x-1][y];
			if(x+1<A.length)
				A[x+1][y] = 1-A[x+1][y];
			if(y-1>=0) 
				A[x][y-1] = 1-A[x][y-1];
			if(y+1<A[0].length) 
				A[x][y+1] = 1-A[x][y+1];
		}
		return A;
    }
}
