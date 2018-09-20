package com.xmu.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if(root==null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		TreeNode cur = null;
		while(!q.isEmpty()) {
			cur = q.remove();
			res.add(cur.val);
			if(cur.left!=null)
				q.add(cur.left);
			if(cur.right!=null)
				q.add(cur.right);
		}
		return res;
	}
}
