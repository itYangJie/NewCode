package com.xmu.swordoffer;

public class ReplaceBlank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
	}
	 public static String replaceSpace(StringBuffer str) {
	    return str.toString().replaceAll(" ","%20");
	}
}
