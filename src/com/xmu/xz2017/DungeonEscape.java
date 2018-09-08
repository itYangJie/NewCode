package com.xmu.xz2017;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DungeonEscape {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),m = in.nextInt();
		char[][] map = new char[n][m];
		boolean[][] isVisited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String strs = in.next();
			map[i] = strs.toCharArray();
		}
		int startX = in.nextInt(),startY = in.nextInt();
		int k = in.nextInt();
		int[][] moves = new int[k][2];
		for(int i=0;i<k;i++) {
			moves[i][0] = in.nextInt();
			moves[i][1] = in.nextInt();
		}
		
		System.out.println(solve(startX,startY,moves,map,isVisited));
	}
	
	static class Point {
		int X, Y,step;
		public Point(int X,int Y,int step) {
			this.X = X;
			this.Y = Y;
			this.step = step;
		}
	}
	private static int solve(int startX, int startY, int[][] moves, char[][] map, boolean[][] isVisited) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(startX,startY,0));
		isVisited[startX][startY] = true;
		
		int max = Integer.MIN_VALUE,endX,endY;
		while(!q.isEmpty()) {
			Point cur = q.remove();
			for(int i=moves.length-1;i>=0;i--) {
				endX = cur.X+moves[i][0];
				endY = cur.Y+moves[i][1];
				if(endX>=0 && endX<map.length && endY>=0 && endY<map[0].length 
						&& map[endX][endY]=='.' && isVisited[endX][endY]==false) {
					q.add(new Point(endX, endY, 1+cur.step));
					isVisited[endX][endY]=true;
				}
			}
			max = Math.max(max, cur.step);
		}
		for(int i=0;i<isVisited.length;i++)
			for(int j=0;j<isVisited[0].length;j++)
				if(isVisited[i][j]==false && map[i][j]=='.')
					return -1;
		return max;
	}

	/*private static boolean canEscape(int startX, int startY, int[][] moves, char[][] map) {
		int endX,endY;
		for(int i=moves.length-1;i>=0;i--) {
			endX = startX+moves[i][0];
			endY = startY+moves[i][1];
			if(endX>=0 && endX<map.length && endY>=0 && endY<map[0].length && map[endX][endY]=='.')
				return true;
		}
		return false;
	}*/

}
