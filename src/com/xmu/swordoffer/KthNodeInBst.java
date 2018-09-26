package com.xmu.swordoffer;

public class KthNodeInBst {
	private int cur;
	TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot==null || k<=0)
			return null;
		cur = 0;
		return solve(pRoot,k);
	}
	private TreeNode solve(TreeNode pRoot, int k) {
		if(pRoot.left!=null) {
			TreeNode temp = solve(pRoot.left,k);
			if(temp!=null)
				return temp;
		}
		cur++;
		if(cur==k)
			return pRoot;
		if(pRoot.right!=null) {
			TreeNode temp =solve(pRoot.right,k);
			if(temp!=null)
				return temp;
		}
		return null;
	}
}
