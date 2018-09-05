package com.xmu.xz2017;

import java.util.Scanner;

public class RevNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		System.out.println( rev(rev(x)+rev(y)) );
	}
	public static int rev(int x) {
		String str = new StringBuffer(String.valueOf(x)).reverse().toString();
		int index = 0;
		while(str.charAt(index)=='0')
			index++;
		return Integer.parseInt(str.substring(index));
	}

}
