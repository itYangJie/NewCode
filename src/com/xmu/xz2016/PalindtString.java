package com.xmu.xz2016;

import java.util.Scanner;

public class PalindtString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String str = in.nextLine();
			if(solve(str))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	private static boolean solve(String str) {
		int left=0,right=str.length()-1;
		while(left<right) {
			if(str.charAt(left)==str.charAt(right)) {
				left++;right--;
			}else {
				if(judge(str.substring(left+1, right+1)) || judge(str.substring(left, right)))
					return true;
				return false;
			}
				
		}
		return true;
	}

	private static boolean judge(String str) {
		int left=0,right=str.length()-1;
		while(left<right) {
			if(str.charAt(left)==str.charAt(right)) {
				left++;right--;
			}else
				return false;
		}
		return true;
	}

}
