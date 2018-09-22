package com.xmu.xz2016;

import java.util.Scanner;

public class ThrowOddPos {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			n++;
			
			int res = 1;
			while(res*2<=n)
				res *= 2;
			System.out.println(res-1);
		}

	}

}
