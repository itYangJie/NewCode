package com.xmu.swordoffer;


public class MirrorTree {
	public void Mirror(TreeNode root) {
		if(root==null)
			return;
		Mirror(root.left);
		Mirror(root.right);
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return;
	}

}
