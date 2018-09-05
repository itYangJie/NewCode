package com.xmu.xz2017;

import java.util.Arrays;
import java.util.Scanner;

public class PairOfPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean[] isComposite = new boolean[n+1];
		// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
		isComposite[1] = true;
		for(int i=2;i<=n;i++) {
			if(isComposite[i])
				continue;
			for(int j=2;j*i<=n;j++)
				isComposite[j*i] = true;
		}
		int count = 0;
		for(int i=2;i<=n/2;i++) {
			if(isComposite[i]==false&&isComposite[n-i]==false)
				count++;
		}
		System.out.println(count);
	}

}
