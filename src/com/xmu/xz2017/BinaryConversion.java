package com.xmu.xz2017;

import java.util.Scanner;

public class BinaryConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int M = in.nextInt(),N = in.nextInt();
		char map[] = new char[]{'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F'};
		StringBuffer sb = new StringBuffer();
		boolean isNeg = false;
		if(M<0) {
			M = -M;
			isNeg = true;
		}
		while(M>=N) {
			sb.append(map[M%N]);
			M = M/N;
		}
		sb.append(M);
		System.out.println((isNeg?"-":"")+sb.reverse().toString());
	}

}
