package com.xmu.test;

public class DicTree {
	
	class DicNode{
		int count;
		boolean isEnd;
		DicNode[] nodes = new DicNode[26];
		public DicNode(int count,boolean isEnd) {
			this.isEnd = isEnd;
			this.count = count;
		}
	}
	private DicNode root;
	public DicTree() {
		root = new DicNode(0,false);
	}
	public void add(String str) {
		DicNode cur = root;
		for (int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(cur.nodes[c-'a']==null)
				cur.nodes[c-'a'] = new DicNode(0,false);
			cur = cur.nodes[c-'a'];
			cur.count = cur.count+1;
			if(i==str.length()-1)
				cur.isEnd = true;
		}
	}
	public void query(String str) {
		DicNode cur = root;
		for (int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(cur.nodes[c-'a']==null) {
				System.out.println("Not exist");
				return;
			}
			cur = cur.nodes[c-'a'];
		}
		if(cur.isEnd)
			System.out.println("full exist,count="+cur.count);
		else
			System.out.println("prefix exist,count="+cur.count);
	}
	public static void main(String[] args) {
		DicTree tree = new DicTree();
		tree.add("abab");
		tree.add("ababcd");
		tree.add("aebab");
		tree.add("abab");
		tree.add("fbab");
		tree.add("fbeab");
		tree.add("gbeab");
		tree.add("cd");
		tree.add("cde");
		tree.add("c");
		
		tree.query("abab");
		tree.query("c");
		tree.query("ababc");
		tree.query("mabab");
		tree.query("ababk");
	}

}
