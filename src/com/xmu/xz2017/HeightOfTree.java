package com.xmu.xz2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HeightOfTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n==1 || n==2) {
			System.out.println(n);
			return;
		}
		HashMap<Integer,ArrayList<Integer>> nodes = new HashMap<>();
		boolean[] isNotRoot = new boolean[n];
		for(int i=0;i<n;i++) {
			nodes.put(i, new ArrayList<>());
		}
		for(int i=0;i<n-1;i++) {
			int start = in.nextInt(),end = in.nextInt();
			isNotRoot[end] = true;
			if(nodes.get(start).size()<2)
				nodes.get(start).add(end);
		}
		int rootIndex = 0;
		while(isNotRoot[rootIndex])
			rootIndex++;
		int height = dfs(rootIndex,nodes);
		System.out.println(height);
	}

	private static int dfs(int rootIndex, HashMap<Integer,ArrayList<Integer>> nodes) {
		if(nodes.get(rootIndex).size()==0)
			return 1;
		int height = Integer.MIN_VALUE;
		for(int child:nodes.get(rootIndex))
			height = Math.max(height, dfs(child,nodes));
		return 1+height;
	}

}
