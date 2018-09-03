package com.xmu.xz2017;

import java.util.Scanner;

public class DecimalMean {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int A = in.nextInt();
			int sum = 0;
			for(int N=2;N<A;N++) {
				int temp = A;
				while(temp>=N) {
					sum = sum+temp%N;
					temp = temp/N;
				}
				sum = sum+temp;
			}
			int common = maxCommonDivisor(sum,A-2);
			System.out.println((sum/common)+"/"+((A-2)/common));
		}
	}
	private static int maxCommonDivisor(int a, int b) {
		if(b>a) {
			int temp = a;
			a = b;
			b = temp;
		}
		int r = a%b;
		while(r!=0) {
			a = b;
			b = r;
			r = a%b;
		}
		return b;
	}

}
