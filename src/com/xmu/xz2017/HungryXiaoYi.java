package com.xmu.xz2017;

import java.util.Scanner;

public class HungryXiaoYi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long x0 = in.nextLong();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<=2;i++) {
			long temp = x0;
			int j=0;
			for(;j<100000;j++) {
				temp = (8*temp+7)%1000000007;
				if(temp==0)
					break;
			}
			min = Math.min(min, j+1+i);
			x0 = 4*x0+3;
		}
		if(min<=100000)
			System.out.println(min);
		else
			System.out.println(-1);
	}
}
