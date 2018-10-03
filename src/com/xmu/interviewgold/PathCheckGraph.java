package com.xmu.interviewgold;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PathCheckGraph {
	public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
		return solve(a,b)||solve(b,a);
	}

	private boolean solve(UndirectedGraphNode a, UndirectedGraphNode b) {
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		Set<UndirectedGraphNode> set = new HashSet<>();
		
		q.add(a);
		set.add(a);
		while(!q.isEmpty()) {
			UndirectedGraphNode cur = q.remove();
			if(cur==b)
				return true;
			ArrayList<UndirectedGraphNode> neighbors = cur.neighbors;
			for(UndirectedGraphNode node:neighbors) {
				if(!set.contains(node)) {
					q.add(node);
					set.add(node);
				}
			}
		}
		return false;
	}
}

class UndirectedGraphNode {
	int label = 0;
	UndirectedGraphNode left = null;
	UndirectedGraphNode right = null;
	ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

	public UndirectedGraphNode(int label) {
        this.label = label;
    }
}
