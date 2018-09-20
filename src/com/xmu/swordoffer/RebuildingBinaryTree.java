package com.xmu.swordoffer;

public class RebuildingBinaryTree {

	public static void main(String[] args) {

	}
	public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
		return solve(pre,0,pre.length-1,in,0,in.length-1);
    }
	  private TreeNode solve(int[] pre, int preL, int preR, 
			  int[] in, int inL, int inR) {
		  if(preL>preR || preR>inR)
			  return null;
		  TreeNode node = new TreeNode(pre[preL]);
		  int i;
		  for(i=inL;i<=inR;i++)
			  if(in[i]==pre[preL])
				  break;
		  int leftNum = i-inL,rightNum=inR-i;
		  
		  node.left = solve(pre,preL+1,preL+leftNum,in,inL ,inL+leftNum-1);
		  node.right = solve(pre,preL+leftNum+1,preR,in,inL+leftNum+1 ,inR);
		  return node;
	}
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
}
