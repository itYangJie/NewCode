package com.xmu.xz2017;

import java.util.Scanner;

public class GeoHashEncoding {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int left=-90,right = 90;
		String res = "";
		for(int i=0;i<6;i++) {
			int mid = (left+right)/2;
			if(n>=mid) {
				res = res+"1";
				left = mid;
			}
			else {
				res = res+"0";
				right = mid;
			}
		}
		System.out.println(res);
	}

}
