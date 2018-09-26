package com.xmu.swordoffer;

public class IsNum {

	public static void main(String[] args) {

	}

	public boolean isNumeric(char[] str) {
		if(str.length<1)
			return false;
		String s = new String(str);
		return s.matches("(\\-|\\+)?\\d+(\\.\\d+)?((e|E)(\\-|\\+)?\\d+)?")||
				s.matches("(\\-|\\+)?\\.\\d+((e|E)(\\-|\\+)?\\d+)?");
	}
}
