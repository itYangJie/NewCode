package com.xmu.swordoffer;

public class HasPathInMat {

	public static void main(String[] args) {
		System.out.println(new HasPathInMat().hasPath(new char[] {'a','b','c','e','s','f','c','s','a',
				'd','e','e'},
				3, 4, new char[] {'b','c','c','e','m'}));
	}
	/*a b c e
	  s f c s
	  a d e e*/
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
		char[][] mat = new char[rows][cols];
		int ind = 0;
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++) {
				mat[i][j] = matrix[ind++];
			}
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++) {
				boolean isVisited[][] = new boolean[rows][cols];
				if(solve(mat,i,j,rows,cols,str,0,isVisited))
					return true;
			}
		return false;
    }
	private boolean solve(char[][] matrix,int i, int j, int rows, int cols, char[] str, int ind, boolean[][] isVisited) {
		
		if(ind==str.length)
			return true;
		if(i<0 || i>=rows || j<0 || j>=cols || str[ind]!=matrix[i][j] || isVisited[i][j])
			return false;
		
		isVisited[i][j] = true;
		if(solve(matrix, i+1, j, rows, cols, str, ind+1, isVisited) || solve(matrix, i-1, j, rows, cols, str, ind+1, isVisited)
				|| solve(matrix, i, j+1, rows, cols, str, ind+1, isVisited) || solve(matrix, i, j-1, rows, cols, str, ind+1, isVisited))
			return true;
		isVisited[i][j] = false;
		return false;
	}
}
