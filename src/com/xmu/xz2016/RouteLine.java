package com.xmu.xz2016;

import java.util.Arrays;
import java.util.Scanner;

public class RouteLine {
	public static int[] dijkstra(int[][] road, int[][] forbidStart,
			int[][] forbidEnd,int s, int n) {
		int[] dist = new int[n];
		boolean[] isVisited = new boolean[n];
		dist[s] = 1;
		isVisited[s] = true;
		for (int i = 0; i < n; i++) {
			if(i==s)
				continue;
			if(!isAllowPass(dist[s],dist[s]+road[s][i]-1, forbidStart[s][i],forbidEnd[s][i]))
				dist[i] = 1+forbidEnd[s][i]+road[s][i];
			else
				dist[i] = road[s][i]+dist[s];
		}
		for (int i = 0; i < n; i++) {
			if(i==s)
				continue;
			int minDist = Integer.MAX_VALUE/2;
			int v = -1;
			for (int j = 0; j < n; j++) {
				if (!isVisited[j] && dist[j] < minDist) {
					minDist = dist[j];
					v = j;
				}
			}
			if(v==-1)
				break;
			isVisited[v] = true;
			for (int j = 0; j < n; j++) {
				if (!isVisited[j] && road[v][j] < Integer.MAX_VALUE/2) {
					int temp = dist[v] + road[v][j];
					if(!isAllowPass(dist[v],dist[v]+road[v][j]-1,
							forbidStart[v][j],forbidEnd[v][j]))
						temp = forbidEnd[v][j]+1+road[v][j];
					if(temp<dist[j]);
						dist[j] = temp;
				}
			}
		}
		return dist;
	}
	private static boolean isAllowPass(int start1, int end1, int start2, int end2) {
		if (end1 < start2 || end2 < start1)
	        return true;
	    else
	        return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			int[][] path = new int[N][N];
			int[][] forbidStart = new int[N][N];
			int[][] forbidEnd = new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(path[i], Integer.MAX_VALUE/2);
			}
			for(int i=0;i<M;i++) {
				int n1 = in.nextInt();
				int n2 = in.nextInt();
				int k = in.nextInt();
				int fs = in.nextInt();
				int fe = in.nextInt();
				path[n1-1][n2-1] = k;
				path[n2-1][n1-1] = k;
				forbidStart[n1-1][n2-1] = fs;
				forbidStart[n2-1][n1-1] = fs;
				forbidEnd[n1-1][n2-1] = fe;
				forbidEnd[n2-1][n1-1] = fe;
			}
			int[] dis = dijkstra(path, forbidStart, forbidEnd, 0, N);
			System.out.println(dis[N-1]);
		}

	}

}
