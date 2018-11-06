package com.xmu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinGeneMuta {
	class Node{
		String s;
		int count;
		Node(String s,int count){
			this.s = s;
			this.count = count;
		}
	}
	public int minMutation(String start, String end, String[] bank) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start,0));
		boolean[] isVisited = new boolean[bank.length];
		for(int i=0;i<bank.length;i++) {
			if(bank[i].equals(start))
				isVisited[i] = true;
		}
		while(!q.isEmpty()) {
			Node cur = q.remove();
			if(end.equals(cur.s))
				return cur.count;
			for(int i=0;i<bank.length;i++) {
				if(!isVisited[i] && canReach(cur.s,bank[i])) {
					q.add(new Node(bank[i],1+cur.count));
					isVisited[i] = true;
				}
			}
		}
		return -1;
	}
	private boolean canReach(String s, String t) {
		if(s.length()!=t.length())
			return false;
		int count = 0;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)!=t.charAt(i))
				count++;
		return count==1;
	}
}
