package com.xmu.xz2017;

import java.util.Scanner;

public class NumOfEndZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int numOfTwo = 0,numOfFive = 0;
		
		for(int num=1;num<=n;num++) {
			int cur = num;
			while(cur%2==0) {
				cur = cur/2;
				numOfTwo++;
			}
			while(cur%5==0) {
				cur = cur/5;
				numOfFive++;
			}
		}
		System.out.println(Math.min(numOfTwo, numOfFive));
	}

}
