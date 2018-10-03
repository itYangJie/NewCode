package com.xmu.interviewgold;

public class PixReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 1 2 3
    // 4 5 6
    // 7 8 9
    
	// 7 8 9
	// 4 5 6
	// 1 2 3
	
    // 7 4 1
    // 8 5 2
    // 9 6 3
    public int[][] transformImage(int[][] mat, int n) {
        if(n==1)
        	return mat;
        for(int i=0;i<n/2;i++) {
        	for(int j=0;j<n;j++) {
        		int temp = mat[n-1-i][j];
        		mat[n-1-i][j] = mat[i][j];
        		mat[i][j] = temp;
        	}
        }
        for(int i=1;i<n;i++)
        	for(int j=0;j<i;j++) {
        		int temp = mat[i][j];
        		mat[i][j] = mat[j][i];
        		mat[j][i] = temp;
        	}
        return mat;
    }
}
