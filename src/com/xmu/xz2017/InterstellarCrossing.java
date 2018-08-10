package com.xmu.xz2017;

import java.util.Scanner;

public class InterstellarCrossing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long h = Long.parseLong(in.next());
		
		long left=0,right=1000000000;
		while(left<right-1) {
			long mid = (left+right)/2;
			if(mid+mid*mid<h)
				left = mid;
			else
				right = mid;
		}
		if(right+right*right<=h)
			System.out.println(right);
		else
			System.out.println(left);
	}

}
