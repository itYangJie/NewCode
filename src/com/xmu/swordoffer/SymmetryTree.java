package com.xmu.swordoffer;

public class SymmetryTree {
	
	boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot==null)
			return true;
		return solve(pRoot.left,pRoot.right);
	}

	private boolean solve(TreeNode left, TreeNode right) {
		if(left==null && right==null)
			return true;
		if(left==null || right==null)
			return false;
		if(left.val!=right.val)
			return false;
		return solve(left.left,right.right)&&solve(left.right,right.left);
	}
}
