package com.xmu.xz2017;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class LuckBag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] xi = new int[n];
		for(int i=0;i<n;i++)
			xi[i] = in.nextInt();
		if (n<=1)
			System.out.println(0);
		Arrays.sort(xi);
		
		System.out.println(dfs(0,0,1,xi));
	}
	public static int dfs(int pos,long sum,long pi,int[] xi) {
		int res = 0;
		for(int i=pos;i<xi.length;i++) {
			sum = sum+xi[i];
			pi = pi*xi[i];
			if(sum>pi)
				res = res+1+dfs(i+1,sum,pi,xi);
			else if(xi[i]==1)
				res = res+dfs(i+1,sum,pi,xi);
			else
				break;
			sum = sum-xi[i];
			pi = pi/xi[i];
			while(i<xi.length-1&&xi[i+1]==xi[i])
				i++;
		}
		return res;
	}
}
