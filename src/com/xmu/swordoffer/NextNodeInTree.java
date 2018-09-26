package com.xmu.swordoffer;


public class NextNodeInTree {
	static class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
    	TreeLinkNode root = pNode;
    	while(root.next!=null)
    		root = root.next;
    	return solve(root,pNode);
    }
	private TreeLinkNode solve(TreeLinkNode root, TreeLinkNode pNode) {
		if(root==null)
			return null;
		if(root==pNode) {
			return getFirstNode(root.right);
		}
		if(isChild(root.left,pNode)) {
			if(getLastNode(root.left)==pNode) {
				return root;
			}else
				return solve(root.left,pNode);
		}
		return solve(root.right,pNode);
	}
	private TreeLinkNode getLastNode(TreeLinkNode root) {
		if(root==null)
			return null;
		if(root.right==null)
			return root;
		return getLastNode(root.right);
	}
	private TreeLinkNode getFirstNode(TreeLinkNode root) {
		if(root==null)
			return null;
		if(root.left==null)
			return root;
		return getFirstNode(root.left);
	}
	private boolean isChild(TreeLinkNode root,
			TreeLinkNode pNode) {
		if(root==null)
			return false;
		TreeLinkNode cur = pNode;
		while(cur!=null && cur!=root)
			cur = cur.next;
		if(cur==null)
			return false;
		return true;
	}
}