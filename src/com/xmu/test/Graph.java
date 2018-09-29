package com.xmu.test;

import java.util.Arrays;
import java.util.Comparator;

public class Graph {
	public static void main(String[] args) {
		int[][] road = {
				{0,10,50,60},
				{10,0,20,30},
				{50,20,0,Integer.MAX_VALUE},
				{60,30,Integer.MAX_VALUE,0}};
		int[] dis = dijkstra(road, 0, road.length);
		System.out.println(Arrays.toString(dis));
		}
	
	public static int[] dijkstra(int[][] road, int s, int n) {
		int[] dist = new int[n];
		boolean[] isVisited = new boolean[n];
		for (int i = 0; i < n; i++) {
			dist[i] = road[s][i];
		}
		for (int i = 0; i < n; i++) {
			int minDist = Integer.MAX_VALUE;
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
				if (!isVisited[j] && road[v][j] < Integer.MAX_VALUE) {
					if(dist[v] + road[v][j]<dist[j]);
						dist[j] = dist[v]+road[v][j];
				}
			}
		}
		return dist;
	}
	private static class Edge {
		// 起点和终点
		int x, y;
		int weight;

		public Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
	public static int minSpanningTree(Edge[] edges,int n) {
		int m = edges.length;
		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		int a[] = new int[n + 1];
		for (int i = 1; i <= n; i++)
			a[i] = -1;

		int sum = 0;
		for (int i = 0; i < m; i++) {
			Edge cur = edges[i];
			int xance = ancestor(a, cur.x);
			int yance = ancestor(a, cur.y);
			if (xance != yance) {
				unite(a, cur.x, cur.y);
				sum += cur.weight;
			}
		}
		return sum;

	}
	private static int ancestor(int[] a, int ind) {
		while (a[ind] != -1)
			ind = a[ind];
		return ind;
	}

	private static void unite(int[] a, int x, int y) {
		int anx = ancestor(a, x);
		int any = ancestor(a, y);
		if (x < y)
			a[any] = anx;
		else
			a[anx] = any;
	}
}
