package com.xmu.swordoffer;

public class DepthOfTree {
	
	public int TreeDepth(TreeNode root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		return 1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
	}
}
