package com.xmu.interviewgold;

import com.xmu.swordoffer.ListNode;
import com.xmu.swordoffer.TreeNode;

public class OutSingleLayerNode {
	
	public ListNode getTreeLevel(TreeNode root, int dep) {
		
		if(root==null || dep<=0)
			return null;
		if(dep==1)
			return new ListNode(root.val);
		ListNode left = getTreeLevel(root.left, dep-1);
		ListNode right = getTreeLevel(root.right, dep-1);
		if(left==null)
			return right;
		ListNode cur = left;
		while(cur.next!=null)
			cur = cur.next;
		cur.next = right;
		return left;
	}
}
