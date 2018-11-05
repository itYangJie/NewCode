package com.xmu.leetcode;

public class BattleshipsInBoard {
	public int countBattleships(char[][] board) {
		int m = board.length;
		if(m==0)
			return 0;
		int n = board[0].length;
		
		int count = 0;
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++) {
				if(board[i][j]=='.')
					continue;
				count++;
				int temp = i+1;
				while(temp<m && board[temp][j]=='X') {
					board[temp][j] = '.';
					temp++;
				}
				temp = j+1;
				while(temp<n && board[i][temp]=='X') {
					board[i][temp] = '.';
					temp++;
				}
				board[i][j] = '.';
			}
		return count;
	}
}
