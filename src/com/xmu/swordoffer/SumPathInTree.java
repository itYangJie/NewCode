package com.xmu.swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SumPathInTree {
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root==null)
			return res;
		
		ArrayList<Integer> curList = new ArrayList<>();
		dfs(res,root,target,0,curList);
		Collections.sort(res,new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o2.size()-o1.size();
			}
		});
		return res;
	}

	private void dfs(ArrayList<ArrayList<Integer>> res,
			TreeNode root, int target, int curSum, 
			ArrayList<Integer> curList) {
		if(root.left==null && root.right==null) {
			if(curSum+root.val==target) {
				curList.add(root.val);
				//¿½±´curList
				ArrayList<Integer> list = new ArrayList<>();
				for(int i=0;i<curList.size();i++)
					list.add(curList.get(i));
				res.add(list);
				curList.remove(curList.size()-1);
			}
		}
		if(root.left!=null) {
			curList.add(root.val);
			dfs(res,root.left,target,curSum+root.val,curList);
			curList.remove(curList.size()-1);
		}
		if(root.right!=null) {
			curList.add(root.val);
			dfs(res,root.right,target,curSum+root.val,curList);
			curList.remove(curList.size()-1);
		}
	}
}
