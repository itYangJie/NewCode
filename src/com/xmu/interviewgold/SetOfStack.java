package com.xmu.interviewgold;

import java.util.ArrayList;

public class SetOfStack {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
		
		int len = ope.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> cur = new ArrayList<>();
		if(len==0)
			return res;
		for(int i=0;i<len;i++) {
			int type = ope[i][0];
			int num = ope[i][1];
			if(type==1) {
				if(cur.size()==size) {
					res.add(cur);
					cur = new ArrayList<Integer>();
				}
				cur.add(num);
			}else {
				if(cur.size()==0) {
					cur = res.remove(res.size()-1);
				}
				cur.remove(cur.size()-1);
			}
		}
		if(cur.size()!=0) {
			res.add(cur);
		}
		return res;
	}
}
