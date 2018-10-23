package com.xmu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode {

	public void connect(TreeLinkNode root) {
		if(root==null)
			return;
		Queue<TreeLinkNode>[] qs = new Queue[2];
		qs[0] = new LinkedList<>();
		qs[1] = new LinkedList<>();

		int ind = 0;
		qs[ind].add(root);
		while (!qs[ind].isEmpty()) {
			TreeLinkNode last = null;
			while (!qs[ind].isEmpty()) {
				TreeLinkNode cur = qs[ind].remove();
				if (cur.left != null) {
					qs[1 - ind].add(cur.left);
				}
				if (cur.right != null) {
					qs[1 - ind].add(cur.right);
				}
				if(last!=null)
					last.next = cur;
				last = cur;
			}
			if(last!=null)
				last.next = null;
			ind = 1-ind;
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
