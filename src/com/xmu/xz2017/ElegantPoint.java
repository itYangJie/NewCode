package com.xmu.xz2017;

import java.util.Scanner;

public class ElegantPoint {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int rSquare = in.nextInt();
		int count =0;
		double r = Math.sqrt(rSquare);
		for(int i=0;i<r;i++){
			double j = Math.sqrt(rSquare-i*i);
			if((int) j==j)
				count++;
		}
		System.out.println(count*4);
	}

}
