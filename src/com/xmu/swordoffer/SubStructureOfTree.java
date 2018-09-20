package com.xmu.swordoffer;

public class SubStructureOfTree {
	
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if(root2==null || root1==null)
			return false;
		if(root1.val==root2.val && solve(root1,root2)) 
			return true;
		return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
	}
	private boolean solve(TreeNode root1, TreeNode root2) {
		if(root2==null)
			return true;
		if(root1==null)
			return false;
		if(root1.val!=root2.val)
			return false;
		return solve(root1.left,root2.left) && solve(root1.right,root2.right);
	}
}
