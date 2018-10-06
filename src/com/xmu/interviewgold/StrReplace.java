package com.xmu.interviewgold;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class StrReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Node{
		String s;
		int dis;
		public Node(String s, int dis) {
			super();
			this.s = s;
			this.dis = dis;
		}
		
	}
	public int countChanges(String[] dic, int n, String s, String t) {
		
		LinkedList<String> list = new LinkedList<>();
		for(String str:dic) {
			if(!s.equals(str) && !t.equals(str))
				list.add(str);
		}
		list.add(t);
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(s,0));
		while(!q.isEmpty()) {
			Node node = q.remove();
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext()) {
				String next = iterator.next();
				if(canReach(node.s,next)) {
					if(t.equals(next))
						return 1+node.dis;
					else {
						q.add(new Node(next,1+node.dis));
						iterator.remove();
					}
				}
			}
		}
		return -1;
	}
	private boolean canReach(String s, String t) {
		if(s.length()!=t.length())
			return false;
		int count = 0;
		for(int i=s.length()-1;i>=0;i--) {
			if(s.charAt(i)!=t.charAt(i))
				count++;
		}
		return count==1;
	}
}
