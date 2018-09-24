package com.xmu.xz2016;

import com.xmu.swordoffer.TreeNode;

public class TopologicallyIdenticalSubtree {
	public boolean chkIdentical(TreeNode root1, TreeNode root2) {
		if (root2 == null || root1 == null)
			return false;
		if (root1.val == root2.val && solve(root1, root2))
			return true;
		return chkIdentical(root1.left, root2) || chkIdentical(root1.right, root2);
	}

	private boolean solve(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return solve(root1.left, root2.left) && solve(root1.right, root2.right);
	}
}
