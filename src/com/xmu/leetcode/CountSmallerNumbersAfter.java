package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfter {
	public static void main(String[] args) {
		new CountSmallerNumbersAfter().countSmaller(new int[] {5,2,6,1});
	}
	class Node{
		int val;
		int count;
		Node left,right;
		Node(int val,int count){
			this.val = val;
			this.count = count;
		}
	}
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList();
		
		int len = nums.length;
		if(nums==null || len==0)
			return res;
		int[] coll = new int[len];
		
		Node root = new Node(nums[len-1],1);
		for(int i=len-2;i>=0;i--) {
			coll[i] = query(root,nums[i]);
			insert(root,nums[i]);
		}
		for(int i=0;i<len;i++)
			res.add(coll[i]);
		return res;
	}
	private void insert(Node root, int val) {
		Node cur = root;
		while(cur!=null) {
			cur.count++;
			if(val<=cur.val) {
				if(cur.left==null) {
					cur.left = new Node(val,1);
					break;
				}else {
					cur = cur.left;
				}
			}else {
				if(cur.right==null) {
					cur.right = new Node(val,1);
					break;
				}else {
					cur = cur.right;
				}
			}
		}
	}
	private int query(Node root, int val) {
		if(root==null)
			return 0;
		if(root.val>=val)
			return query(root.left,val);
		return 1+(root.left==null?0:root.left.count)+query(root.right,val);
	}
}
