package com.xmu.swordoffer;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		System.out.println(match(new char[] {'a','b','a'}, 
				new char[] {'a','.','*','b'}));
	}

	public static boolean match(char[] str, char[] pattern) {
		String s = new String(str);
		String p = new String(pattern);
		return s.matches(p);
	}
}
