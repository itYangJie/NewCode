package com.xmu.swordoffer;

public class SerachTree {
	public boolean IsSearch_Solution(TreeNode root) {
		if(root==null || (root.left==null && root.right==null))
			return true;
		if(!IsSearch_Solution(root.left) || (!IsSearch_Solution(root.right)))
			return false;
		return (root.left==null || root.val>root.left.val) &&
				(root.right==null || root.val<root.right.val);
	}
}
