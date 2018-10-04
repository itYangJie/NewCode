package com.xmu.interviewgold;

import java.util.LinkedList;
import java.util.Queue;

public class Flood {
	
	public int floodFill(int[][] map, int n, int m) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		Queue<Integer> times = new LinkedList<>();
		boolean[][] isVisited = new boolean[n][m];
		
		qx.add(0);
		qy.add(0);
		times.add(0);
		isVisited[0][0] = true;
		
		while(!qx.isEmpty()) {
			int x = qx.remove();
			int y = qy.remove();
			int time = times.remove();
			
			if(x==n-1 && y==m-1)
				return time;
			
			if(x-1>=0 && map[x-1][y]==0 && (!isVisited[x-1][y])) {
				isVisited[x-1][y] = true;
				qx.add(x-1);
				qy.add(y);
				times.add(time+1);
			}
			if(x+1<n && map[x+1][y]==0 && (!isVisited[x+1][y])) {
				isVisited[x+1][y] = true;
				qx.add(x+1);
				qy.add(y);
				times.add(time+1);
			}
			if(y-1>=0 && map[x][y-1]==0 && (!isVisited[x][y-1])) {
				isVisited[x][y-1] = true;
				qx.add(x);
				qy.add(y-1);
				times.add(time+1);
			}
			if(y+1<m && map[x][y+1]==0 && (!isVisited[x][y+1])) {
				isVisited[x][y+1] = true;
				qx.add(x);
				qy.add(y+1);
				times.add(time+1);
			}
		}
		return 0;
	}
}
