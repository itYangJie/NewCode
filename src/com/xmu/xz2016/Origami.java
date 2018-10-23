package com.xmu.xz2016;

import java.util.Arrays;

public class Origami {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(foldPaper(3)));

	}

	public static String[] foldPaper(int n) {
		if(n==1)
			return new String[] {"down"};
		String[] temp = foldPaper(n-1);
		int tempN = temp.length;
		String[] res = new String[2*tempN+1];
		for(int i=0;i<2*tempN+1;i++) {
			if(i%2==1) {
				res[i] = temp[i/2];
			}else {
				if(i%4==0)
					res[i] = "down";
				else
					res[i] = "up";
			}
		}
		return res;
	}
}
