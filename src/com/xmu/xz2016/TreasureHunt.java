package com.xmu.xz2016;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TreasureHunt {

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

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			Edge[] edges = new Edge[m];
			for (int i = 0; i < m; i++) {
				edges[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
			}
			Arrays.sort(edges, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					return o1.weight-o2.weight;
				}
			});
			int a[] = new int[n+1];
			for(int i=1;i<=n;i++)
				a[i] = -1;
			
			int res = Integer.MIN_VALUE;
			for(int i=0;i<m;i++) {
				Edge cur = edges[i];
				int xance = ancestor(a,cur.x);
				int yance = ancestor(a,cur.y);
				if(xance!=yance) {
					unite(a,cur.x,cur.y);
					res = Math.max(res, cur.weight);
				}
			}
			System.out.println(res);
		}

	}

	private static int ancestor(int[] a, int ind) {
		while(a[ind]!=-1)
			ind = a[ind];
		return ind;
	}

	private static void unite(int[] a, int x, int y) {
		int anx = ancestor(a, x);
		int any = ancestor(a, y);
		if(x<y)
			a[any] = anx;
		else
			a[anx] = any;
	}

}
