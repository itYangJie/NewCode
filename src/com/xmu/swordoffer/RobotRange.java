package com.xmu.swordoffer;

public class RobotRange {

	public static void main(String[] args) {

	}

	public int movingCount(int threshold, int rows, int cols) {
		
		boolean [][] isVisited = new boolean[rows][cols];
		return solve(0,0,threshold,rows,cols,isVisited);
	}

	private int solve(int i, int j, int threshold, int rows, int cols, boolean[][] isVisited) {
		if(i<0 || i>=rows || j<0 || j>=cols || numSum(i)+numSum(j)>threshold || isVisited[i][j])
			return 0;
		isVisited[i][j] = true;
		return 1+solve(i,j+1,threshold,rows,cols,isVisited)+solve(i,j-1,threshold,rows,cols,isVisited)
			+solve(i+1,j,threshold,rows,cols,isVisited)+solve(i-1,j,threshold,rows,cols,isVisited);
	}

	private int numSum(int i) {
		int sum = 0;
		do {
			sum += i % 10;
		} while ((i = i / 10) > 0);
		return sum;
	}

}
