package com.xum.other;

import java.util.Scanner;

public class SumInt {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			System.out.println(solve(1,0,n,m));
		}

	}

	private static int solve(int ind, int curSum, 
			int n, int m) {
		if(curSum>m)
			return 0;
		if(curSum==m)
			return 1;
		int count = 0;
		for(int i=ind;i<=n;i++) {
			if(curSum+i>m)
				break;
			int temp = solve(i+1,curSum+i,n,m);
			count += temp;
		}
		return count;
	}

}
