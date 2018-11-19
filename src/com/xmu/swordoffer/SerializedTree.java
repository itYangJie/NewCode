package com.xmu.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

public class SerializedTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;root.right = right;
		SerializedTree st = new SerializedTree();
		String data = st.serialize(root);
		st.deserialize(data);
	}

	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		String s = solve(root);
		return s.substring(0, s.length() - 1);
	}

	private String solve(TreeNode root) {
		if (root == null)
			return "#,";
		String s = root.val + "," + solve(root.left) + solve(root.right);
		return s;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if ("".equals(data))
			return null;
		Queue<String> q = new LinkedList();
		for (String str : data.split(","))
			q.add(str);
		return construct(q);
	}

	private TreeNode construct(Queue<String> q) {
		if (q.isEmpty())
			return null;
		String cur = q.remove();
		if ("#".equals(cur))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(cur));
		root.left = construct(q);
		root.right = construct(q);
		return root;

	}
	/*
	 * public int index = -1;
	 * 
	 * String Serialize(TreeNode root) { StringBuffer sb = new StringBuffer(); if
	 * (root == null) { sb.append("#,"); return sb.toString(); } sb.append(root.val
	 * + ","); sb.append(Serialize(root.left)); sb.append(Serialize(root.right));
	 * return sb.toString(); }
	 * 
	 * TreeNode Deserialize(String str) { index++; int len = str.length(); if (index
	 * >= len) { return null; } String[] strr = str.split(","); TreeNode node =
	 * null; if (!strr[index].equals("#")) { node = new
	 * TreeNode(Integer.valueOf(strr[index])); node.left = Deserialize(str);
	 * node.right = Deserialize(str); }
	 * 
	 * return node; }
	 */
}
