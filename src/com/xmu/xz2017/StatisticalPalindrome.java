package com.xmu.xz2017;

import java.util.Scanner;

public class StatisticalPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String A = in.nextLine();
		String B = in.nextLine();
		int Alen = A.length();
		int count = 0;
		for(int i=0;i<=Alen;i++) {
			String start = A.substring(0, i);
			String end = A.substring(i);
			StringBuffer sb =new StringBuffer(start+B+end);
			String s1 = sb.toString();
			String s2 = sb.reverse().toString();
			if (s1.equals(s2))
				count++;
		}
		System.out.println(count);
	}

}
