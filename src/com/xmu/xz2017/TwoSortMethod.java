package com.xmu.xz2017;

import java.util.Scanner;

public class TwoSortMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] strs = new String[n];
		for(int i=0;i<n;i++)
			strs[i] = in.next();
		if(n==1) {
			System.out.println("both");
			return;
		}
			
		boolean isDictSort = isDictSort(strs);
		boolean isLengthSort = isLengthSort(strs);
		if(isDictSort && isLengthSort) 
			System.out.println("both");
		else if(isDictSort)
			System.out.println("lexicographically");
		else if(isLengthSort)
			System.out.println("lengths");
		else
			System.out.println("none");
		
	}

	private static boolean isLengthSort(String[] strs) {
		for(int i=1;i<strs.length;i++) {
			if(strs[i].length()<strs[i-1].length())
				return false;
		}
		return true;
	}

	private static boolean isDictSort(String[] strs) {
		for(int i=1;i<strs.length;i++) {
			if(strs[i].compareTo(strs[i-1])<0)
				return false;
		}
		return true;
	}

}
