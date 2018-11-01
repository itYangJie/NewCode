package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
	public static void main(String[] args) {
		new MinimumHeightTrees().findMinHeightTrees(3, new int[][] {{0,1},{0,2}});
	}
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res = new ArrayList<Integer>();
		
		if(n==0)
			return res;
		
		HashSet<Integer> [] table = new HashSet[n];
		for(int i=0;i<n;i++)
			table[i] = new HashSet<>();
		
		for(int i=0;i<edges.length;i++) {
			table[edges[i][0]].add(edges[i][1]);
			table[edges[i][1]].add(edges[i][0]);
		}
		
		Queue<Integer>[] qs = new LinkedList[2];
		qs[0] = new LinkedList<>();
		qs[1] = new LinkedList<>();
		int ind = 0;
		
		for(int i=0;i<n;i++)
			if(table[i].size()==1)
				qs[ind].add(i);
		
		while(n>2) {
			n -= qs[ind].size();
			while(!qs[ind].isEmpty()) {
				int cur = qs[ind].remove();
				int parent = table[cur].iterator().next();
				table[parent].remove(cur);
				if(table[parent].size()==1)
					qs[1-ind].add(parent);
			}
			ind = 1-ind;
		}
		
		while(!qs[ind].isEmpty())
			res.add(qs[ind].remove());
		return res;
	}

	
}
