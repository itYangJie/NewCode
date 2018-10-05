package com.xmu.interviewgold;

public class SubStrDecide {

	public boolean[] chkSubStr(String[] p, int n, String s) {
		// write code here
		boolean[] res = new boolean[n];
		DicTree tree = new DicTree();
		for(int i=0;i<s.length();i++)
			tree.add(s.substring(i));
		for (int i = 0; i < n; i++)
			res[i] = tree.query(p[i]);
		return res;
	}
}

class DicTree {
	class DicNode {
		DicNode[] nodes = new DicNode[26];
	}

	private DicNode root;

	public DicTree() {
		root = new DicNode();
	}

	public void add(String str) {
		DicNode cur = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (cur.nodes[c - 'a'] == null)
				cur.nodes[c - 'a'] = new DicNode();
			cur = cur.nodes[c - 'a'];
		}
	}

	public boolean query(String str) {
		DicNode cur = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (cur.nodes[c - 'a'] == null) {
				return false;
			}
			cur = cur.nodes[c - 'a'];
		}
		return true;
	}
}