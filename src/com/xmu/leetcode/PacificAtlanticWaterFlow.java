package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<int[]>();
		
		int m = matrix.length,n = matrix[0].length;
		
		boolean canReachPaci[][] = new boolean[m][n];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<m;i++) {
			q.add(new int[] {i,0});
			canReachPaci[i][0] = true;
		}
		for(int i=1;i<n;i++) {
			q.add(new int[] {0,i});
			canReachPaci[0][i] = true;
		}
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			
			// cur[0]+-1 cur[1]+-1
			if(cur[0]-1>=0 && canReachPaci[cur[0]-1][cur[1]]==false && 
					matrix[cur[0]-1][cur[1]]>=matrix[cur[0]][cur[1]]) {
				q.add(new int[] {cur[0]-1,cur[1]});
				canReachPaci[cur[0]-1][cur[1]]=true;
			}
			if(cur[1]-1>=0 && canReachPaci[cur[0]][cur[1]-1]==false && 
					matrix[cur[0]][cur[1]-1]>=matrix[cur[0]][cur[1]]) {
				q.add(new int[] {cur[0],cur[1]-1});
				canReachPaci[cur[0]][cur[1]-1]=true;
			}
			if(cur[0]+1<m && canReachPaci[cur[0]+1][cur[1]]==false && 
					matrix[cur[0]+1][cur[1]]>=matrix[cur[0]][cur[1]]) {
				q.add(new int[] {cur[0]+1,cur[1]});
				canReachPaci[cur[0]+1][cur[1]]=true;
			}
			if(cur[1]+1<n && canReachPaci[cur[0]][cur[1]+1]==false && 
					matrix[cur[0]][cur[1]+1]>=matrix[cur[0]][cur[1]]) {
				q.add(new int[] {cur[0],cur[1]+1});
				canReachPaci[cur[0]][cur[1]+1]=true;
			}
		}
		
		boolean canReachAtlan[][] = new boolean[m][n];
		q.clear();
		for(int i=0;i<m;i++) {
			q.add(new int[] {i,n-1});
			canReachAtlan[i][n-1] = true;
		}
		for(int i=0;i<n-1;i++) {
			q.add(new int[] {m-1,i});
			canReachAtlan[m-1][i] = true;
		}
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			
			// cur[0]+-1 cur[1]+-1
			if(cur[0]-1>=0 && canReachAtlan[cur[0]-1][cur[1]]==false && 
					matrix[cur[0]-1][cur[1]]>=matrix[cur[0]][cur[1]]) {
				q.add(new int[] {cur[0]-1,cur[1]});
				canReachAtlan[cur[0]-1][cur[1]]=true;
			}
			if(cur[1]-1>=0 && canReachAtlan[cur[0]][cur[1]-1]==false && 
					matrix[cur[0]][cur[1]-1]>=matrix[cur[0]][cur[1]]) {
				q.add(new int[] {cur[0],cur[1]-1});
				canReachAtlan[cur[0]][cur[1]-1]=true;
			}
			if(cur[0]+1<m && canReachAtlan[cur[0]+1][cur[1]]==false && 
					matrix[cur[0]+1][cur[1]]>=matrix[cur[0]][cur[1]]) {
				q.add(new int[] {cur[0]+1,cur[1]});
				canReachAtlan[cur[0]+1][cur[1]]=true;
			}
			if(cur[1]+1<n && canReachAtlan[cur[0]][cur[1]+1]==false && 
					matrix[cur[0]][cur[1]+1]>=matrix[cur[0]][cur[1]]) {
				q.add(new int[] {cur[0],cur[1]+1});
				canReachAtlan[cur[0]][cur[1]+1]=true;
			}
		}
		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(canReachAtlan[i][j] && canReachPaci[i][j])
					res.add(new int[] {i,j});
		return res;
	}
}
