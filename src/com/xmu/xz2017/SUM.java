package com.xmu.xz2017;

import java.util.Scanner;

public class SUM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		dfs(1,0,"",m,n);
	}

	private static void dfs(int index, int curSum, String res, int m,int n) {
		if(curSum>m)
			return;
		if(curSum==m) {
			System.out.println(res.trim());
			return;
		}
		for(int i=index;i<=n;i++) {
			dfs(i+1,curSum+i,res+i+" ",m,n);
		}
		
	}
	
	
}
