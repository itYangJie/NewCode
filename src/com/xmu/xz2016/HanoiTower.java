package com.xmu.xz2016;

import java.util.ArrayList;

public class HanoiTower {

	public static void main(String[] args) {
		ArrayList<String> res = new HanoiTower().getSolution(2);
		for (String str : res)
			System.out.println(str);
		
	}

	public ArrayList<String> getSolution(int n) {
		ArrayList<String> res = new ArrayList();
		solve(n, res, "left", "mid", "right");
		return res;
	}

	private void solve(int n, ArrayList<String> res, String source, String aid, String target) {
		if (n == 1) {
			res.add("move from " + source + " to " + target);
			return;
		}
		solve(n - 1, res, source, target, aid);
		res.add("move from " + source + " to " + target);
		solve(n - 1, res, aid, source, target);
	}

	public int chkStep(int[] arr, int n) {
		
		return help(arr,n-1,1,2,3);
	}

	private int help(int[] arr, int ind, int from, int mid, int to) {
		if(ind==-1)
			return 0;
		if(arr[ind]==mid)
			return -1;
		if(arr[ind]==from)
			return help(arr,ind-1,from,to,mid);
		else {
			int tmp = help(arr,ind-1,mid,from,to);
			if(tmp==-1)
				return -1;
			return (int) (tmp+Math.pow(2, ind));
		}
	}

}
