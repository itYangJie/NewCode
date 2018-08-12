package com.xmu.xz2017;

import java.util.Arrays;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n];
		for(int i=0;i<n;i++)
			x[i] = in.nextInt();
		Arrays.sort(x);
		if(x[0]!=1) {
			System.out.println(1);
			return;
		}
		if(x.length==1) {
			System.out.println(2);
			return;
		}
		int maxCom = 1;
		for(int i=1;i<n;i++) {
			if(x[i]>maxCom+1)
				break;
			else
				maxCom = maxCom+x[i];
		}
		System.out.println(maxCom+1);
		/*int need = 1;
		while(true) {
			if(!dfs(0,0,need,x))
				break;
			need++;
		}
		System.out.println(need);*/
	}
	/*public static boolean dfs(int pos,int sum,int need,int[] x) {
		int temp = sum;
		for(int i=pos;i<x.length;i++) {
			temp = temp+x[i];
			if(temp==need)
				return true;
			else if(temp>need) {
				return false;
			}else {
				if(dfs(i+1,temp,need,x))
					return true;
				else
					temp = temp-x[i];
			}	
		}
		return false;
	}*/
}
