package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Journey {
	/*public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while(in.hasNext()) {
		int N = in.nextInt(),M = in.nextInt();
		int[][] dp = new int[N+1][N+1];
		for(int i=1;i<=N;i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE/2);
		for(int i=1;i<=N;i++)
			dp[i][i] = in.nextInt();
		for(int i=0;i<M;i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			if(end<start) {
				int temp = start;
				start = end;
				end = temp;
			}
			dp[start][end] = dp[start][start]+dp[end][end]; 
		}
		if(dp[1][N]!=Integer.MAX_VALUE/2) {
			System.out.println(dp[1][N]);
			return;
		}
		// dp[i][j] = Math.min(dp[i][k]+dp[k][j]-dp[k][k])
		for(int k=2;k<N;k++) {
			for(int i=1;i<k;i++) {
				for(int j=k+1;j<=N;j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]-dp[k][k]);
				}
			}
		}
		System.out.println(dp[1][N]);
	}

}*/
	public static void init(int[][] road, int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				road[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	public static int dijkstra(int[][] road, int s, int n, int girl1) {
		int[] dist = new int[n + 1];
		boolean[] isVisited = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			dist[i] = road[s][i];
		}
		dist[s] = girl1;
		isVisited[s] = true;
		for (int i = 2; i < n; i++) {
			int minDist = Integer.MAX_VALUE;
			int v = 1;
			for (int j = 1; j <= n; j++) {
				if (!isVisited[j] && dist[j] < minDist) {
					minDist = dist[j];
					v = j;
				}
			}
			isVisited[v] = true;
			for (int j = 1; j <= n; j++) {
				if (!isVisited[j] && road[v][j] < Integer.MAX_VALUE) {
					int temp = dist[v] + road[v][j];
					dist[j] = dist[j] < temp ? dist[j] : temp;
				}
			}
		}
		return dist[n] + girl1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			// 表示n个汽车站内有M条公路
			int m = in.nextInt();
			int[][] road = new int[n + 1][n + 1];
			init(road, n);
			int girls[] = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				girls[i] = in.nextInt();
			}
			for (int i = 0; i < m; i++) {
				int p = in.nextInt();
				int q = in.nextInt();
				road[p][q] = girls[q];
				road[q][p] = girls[p];
			}
			System.out.println(dijkstra(road, 1, n, girls[1]));
		}
	}
}
