package com.xmu.xz2017;

import java.util.Scanner;

public class InvertedStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String[] strs = str.split(" ");
		
		StringBuffer sb = new StringBuffer();
		for(int i=strs.length-1;i>=0;i--)
			sb.append(strs[i]+" ");
		System.out.println(sb.toString().trim());
	}

}
