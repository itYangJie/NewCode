package com.xmu.xz2016;

import java.util.ArrayList;

public class HanoiTower {

	public static void main(String[] args) {
		ArrayList<String> res = new HanoiTower().getSolution(3);
		for(String str:res)
			System.out.println(str);
	}

	public ArrayList<String> getSolution(int n) {
		ArrayList<String> res = new ArrayList();
		solve(n,res,"left","mid","right");
		return res;
	}

	private void solve(int n, ArrayList<String> res, 
			String source, String aid,String target) {
		if(n==1) {
			res.add("move from "+source+" to "+target);
			return;
		}
		solve(n-1,res,source,target,aid);
		res.add("move from "+source+" to "+target);
		solve(n-1,res,aid,source,target);
	}

	
}
