package com.xmu.xz2017;

import java.util.Scanner;

public class IntAdd {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(" ");
		String str1 = strs[0],str2 = strs[1];
		
		if(str1.matches("[0-9]+")==false || 
				str2.matches("[0-9]+")==false) {
			System.out.println("error");
			return;
		}
		if(str1.length()!=str2.length()) {
			StringBuffer fill = new StringBuffer();
			for(int i=Math.abs(str2.length()-str1.length());i>0;i--)
				fill.append(0);
			if(str1.length()<str2.length())
				str1 = fill.toString()+str1;
			else
				str2 = fill.toString()+str2;
		}
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		StringBuffer sb = new StringBuffer();
		int index = charArray1.length-1;
		
		int jin = 0;
		while(index>=0) {
			int sum = charArray1[index]-'0'+charArray2[index]-'0'+jin;
			jin = sum/10;
			sb.append(sum%10);
			index--;
		}
		if (jin!=0)
			sb.append(jin);
		System.out.println(sb.reverse().toString());
	}

}
