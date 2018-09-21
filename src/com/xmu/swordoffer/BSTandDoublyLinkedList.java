package com.xmu.swordoffer;

public class BSTandDoublyLinkedList {

	public TreeNode Convert(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		TreeNode left = Convert(root.left);
		TreeNode p = left;
		while (p != null && p.right != null) {
			p = p.right;
		}
		if (left != null) {
			p.right = root;
			root.left = p;
		}
		TreeNode right = Convert(root.right);
		if (right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left : root;
	}
}
