package com.xmu.leetcode;

public class GameOfLife {
	public static void main(String[] args) {

	}

	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int live = solve(board, i, j);
				if (board[i][j] == 0) {
					if (live == 3)
						board[i][j] = 2;
				} else {
					if (live < 2 || live > 3)
						board[i][j] = 3;
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 2)
					board[i][j] = 1;
				if (board[i][j] == 3)
					board[i][j] = 0;
			}
		}
	}

	private int solve(int[][] board, int i, int j) {
		// 1或者3的个数
		int count = 0;
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				if (dx == 0 && dy == 0)
					continue;
				if (i + dx >= 0 && i + dx < board.length && j + dy >= 0 && j + dy < board[0].length
						&& (board[i + dx][j + dy] == 1 || board[i + dx][j + dy] == 1))
					count++;
			}
		}
		return count;
	}
}