package com.xmu.swordoffer;

import com.xmu.swordoffer.SubStructureOfTree.TreeNode;

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

	class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}
}
