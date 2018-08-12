package com.xmu.xz2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LikeWordOfXiaoYi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		if(str.length()==1) {
			System.out.println("Likes");
			return;
		}
		if(isAllUpCase(str)&&isConEql(str)&&isThridEql(str))
			System.out.println("Likes");
		else
			System.out.println("Dislikes");
	}
	public static boolean isAllUpCase(String str) {
		return str.matches("[A-Z]+");
	}
	public static boolean isConEql(String str) {
		return !str.matches(".*(.)(\\1).*");
	}
	public static boolean isThridEql(String str) {
		return !str.matches(".*(.).*(.).*(\\1).*(\\2).*");
	}
}
