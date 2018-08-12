package com.xmu.xz2017;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int f1 = 0,f2 = 1;
		while(f2<N) {
			int temp = f1+f2;
			f1 = f2;
			f2 = temp;
		}
		System.out.println(Math.min(Math.abs(f1-N), Math.abs(f2-N)));
	}

}
