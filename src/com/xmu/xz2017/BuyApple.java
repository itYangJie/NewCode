package com.xmu.xz2017;

import java.util.Scanner;

public class BuyApple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//6*x+8*y=n
		int minBagCount = Integer.MAX_VALUE;
		for(int i=0;i<=100/6;i++)
			for(int j=0;j<=100/8;j++)
				if(i*6+8*j==n)
					minBagCount = Integer.min(minBagCount, i+j);
		System.out.println(minBagCount==Integer.MAX_VALUE?-1:minBagCount);
	}

}
