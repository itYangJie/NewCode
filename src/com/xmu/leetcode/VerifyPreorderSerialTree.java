package com.xmu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class VerifyPreorderSerialTree {
	public boolean isValidSerialization(String preorder) {
		
		Queue<String> q = new LinkedList<>();
		for(String s:preorder.split(","))
			q.add(s);
		if(!solve(q)||!q.isEmpty())
			return false;
		return true;
	}
	//"9,3,4,#,#,1,#,#,2,#,6,#,#"
	private boolean solve(Queue<String> q) {
		if(q.isEmpty())
			return false;
		String s = q.remove();
		if(!s.equals("#")) {
			if(!solve(q))
				return false;
			if(!solve(q))
				return false;
		}
		return true;
	}
}
