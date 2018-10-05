package com.xmu.interviewgold;

public class MaintenanceRank {

	class Node {
		Node left;
		Node right;
		int val;
		int size;

		public Node(int val, int size) {
			this.val = val;
			this.size = size;
		}
	}

	public int[] getRankOfNumber(int[] A, int n) {

		if (n == 0)
			return new int[] {};

		int[] res = new int[n];
		res[0] = 0;
		if (n == 1)
			return res;

		Node root = new Node(A[0], 1);
		for (int i = 1; i < n; i++) {
			res[i] = insert(root, A[i]);
		}
		return res;
	}

	private int insert(Node root, int val) {

		root.size++;
		if (val <= root.val) {
			if (root.left == null) {
				root.left = new Node(val, 1);
				if(val<root.val)
					return 0;
				else
					return 1;
			} else {
				int res = insert(root.left, val);
				if (val == root.val)
					return 1 + res;
				else
					return res;
			}
		} else {
			if (root.right == null) {
				root.right = new Node(val, 1);
				if (root.left != null)
					return 1 + root.left.size;
				else
					return 1;
			} else {
				int res = insert(root.right, val);
				if (root.left != null)
					return 1 + root.left.size+res;
				else
					return 1+res;
			}
		}
	}
}
