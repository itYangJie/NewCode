package com.xmu.xz2017;

import java.util.Scanner;

public class TreasureMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String t = in.nextLine();
		if("".equals(t)) {
			System.out.println("Yes");
			return;
		}
		if("".equals(s)) {
			System.out.println("NO");
			return;
		}
		char[] sChars = s.toCharArray();
		int sCharNum = sChars.length;
		char[] tChars = t.toCharArray();
		int tCharNum = tChars.length;
		
		int sIndex = 0,tIndex = 0;
		while(tIndex<tCharNum) {
			char tChar = tChars[tIndex];
			while(sIndex<sCharNum && sChars[sIndex]!=tChar)
				sIndex++;
			if(sIndex==sCharNum) {
				System.out.println("No");
				return;
			}
			tIndex++;
			sIndex++;
		}
		System.out.println("Yes");
	}

}
