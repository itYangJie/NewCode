package com.xmu.xz2017;

import java.math.BigInteger;
import java.util.Scanner;

public class MaxOddNum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		BigInteger res = solve(N);
		System.out.println(res.toString());
		
	}
	private static BigInteger solve(int N) {
		if(N==1)
			return new BigInteger("1");
		int maxOdd = N;
		int maxEven = N;
		if(N%2==0)
			maxOdd = N-1;
		else
			maxEven = N-1;
		BigInteger res = new BigInteger(String.valueOf(maxOdd+1));
		res = res.pow(2);
		res = res.divide(new BigInteger("4"));
		res = res.add(solve(maxEven/2));
		return res;
	}
}
