package com.xmu.swordoffer;

import java.util.ArrayList;
import java.util.Stack;
public class PrintTreeZ {
	
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(pRoot==null)
			return res;
		Stack<TreeNode> [] stacks = new Stack[2];
		stacks[0] = new Stack<TreeNode>();
		stacks[1] = new Stack<TreeNode>();
		int i=0;
		stacks[i].push(pRoot);
		
		while(!stacks[i].isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<>();
			while(!stacks[i].isEmpty()) {
				TreeNode cur = stacks[i].pop();
				temp.add(cur.val);
				if(i==0) {
					if(cur.left!=null)
						stacks[1-i].push(cur.left);
					if(cur.right!=null)
						stacks[1-i].push(cur.right);
				}else {
					if(cur.right!=null)
						stacks[1-i].push(cur.right);
					if(cur.left!=null)
						stacks[1-i].push(cur.left);
				}
			}
			res.add(temp);
			i = 1-i;
		}
		return res;
	}
}
