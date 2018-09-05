package com.xmu.xz2017;

import java.util.Scanner;

public class Encoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		long index=-1;
		int count[] = new int[] {1+25+25*25+25*25*25,1+25+25*25
				,1+25,1};
		for(int i=0;i<str.length();i++) {
			int offset = str.charAt(i)-'a';
			index = index+offset*count[i];
			index++;
		}
		System.out.println(index);
	}

}
